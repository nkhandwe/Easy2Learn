package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetLoginModel.LoginModel;
import com.example.easytolearn.Responses.checkUserModel.CheckUserModel;
import com.example.easytolearn.Responses.registerWithOtpModels.GetRegisWithOtpModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.callback.LoginCallback;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.ActivityMobileNumberSignupBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileNumberSignup extends AppCompatActivity implements View.OnClickListener {
    ActivityMobileNumberSignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mobile_number_signup);
        binding.btSubmitR.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_submitR:
                if (validation()) {
                    HashMap<String, Object> hashMap = new HashMap<>();
//                    hashMap.put("MobileNumber", binding.edtMobNumR.getText().toString());
                    hashMap.put("phoneNumber", binding.edtMobNumR.getText().toString());
                    apiCheckUser(hashMap);
//                    apiRegistrationWithOTP(hashMap);
                }
              /*  if(validation(view)){

                }*/

        }
    }

    private void getOtp() {

    }

    private boolean validation() {
        if (binding.edtMobNumR.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.edtMobNumR.getText().toString().length() > 10) {
            Toast.makeText(this, "Please enter valid Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void apiRegistrationWithOTP(final HashMap<String, Object> jsonObject) {
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getRegistrationWithOTP(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {
                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
                            GetRegisWithOtpModel getRegisWithOtpModel = new Gson().fromJson(jsonObject1.toString(), GetRegisWithOtpModel.class);
                            if (getRegisWithOtpModel.getSuccess()) {
                                Intent in = new Intent(MobileNumberSignup.this, OtpPage.class);
                                in.putExtra("mobileNumber", binding.edtMobNumR.getText().toString());
                                startActivity(in);
                            }

                        } else {
                            Toast.makeText(MobileNumberSignup.this, "Already Registered", Toast.LENGTH_SHORT).show();

                        }
//                        loginCallback.onSuccessLogin(response.body());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }

    public void apiCheckUser(final HashMap<String, Object> jsonObject) {
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().checkUser(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
//                            CheckUserModel checkUserModel = new Gson().fromJson(response.body().toString(), CheckUserModel.class);
//                            if (checkUserModel.getSuccess()) {
                            if(jsonObject1.get("response").getAsJsonArray().get(0).getAsJsonObject().get("Verify").toString().equalsIgnoreCase("true")){
//                                if(checkUserModel.getResponse().get(0).getVerify()){
                                    Toast.makeText(MobileNumberSignup.this, "Already Registered", Toast.LENGTH_SHORT).show();
                                    /*Intent in = new Intent(MobileNumberSignup.this, SetPassword.class);
                                    startActivity(in);*/
                                } else {
                                    Intent in = new Intent(MobileNumberSignup.this, OtpPage.class);
                                    in.putExtra("mobileNumber", binding.edtMobNumR.getText().toString());
                                    startActivity(in);
                                }
//                            }
                        } else {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("phoneNumber", binding.edtMobNumR.getText().toString());
                            apiRegistrationWithOTP(jsonObject);
                        }
//                        loginCallback.onSuccessLogin(response.body());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }
}
