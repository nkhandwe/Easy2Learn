package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetLoginModel.LoginModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.callback.LoginCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityMobileNumberBinding;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileNumber extends AppCompatActivity implements View.OnClickListener, LoginCallback {
    ActivityMobileNumberBinding binding;
    Dialog dialog;
    private Context context;
    private Shareprefrence shareprefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mobile_number);
        context = this;
        shareprefrence = new Shareprefrence(context);
        dialog = new Dialog(this);
        binding.tvLogin.setPaintFlags(binding.tvLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvPrivPol.setPaintFlags(binding.tvPrivPol.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvTnc.setPaintFlags(binding.tvTnc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvPrivPol.setOnClickListener(this);
        binding.btSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_submit:
                if (Validation(view)) {
                    HashMap<String, Object> hashMap = new HashMap<>();
//                    hashMap.put("MobileNumber", binding.edtMobNumR.getText().toString());
                    hashMap.put("phoneNumber", binding.edtMobNum.getText().toString());
                    apiCheckUser(hashMap);
                    // loginApi();
                }
                break;
            case R.id.tv_privPol:
                Intent intentP = new Intent(MobileNumber.this, PrivacyPolicy.class);
                startActivity(intentP);
                break;

        }
    }

    private boolean Validation(View view) {
        if (binding.edtMobNum.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.edtMobNum.getText().toString().length() < 10) {
            Toast.makeText(this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }

    public void apiCheckUser(final HashMap<String, Object> jsonObject) {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().checkUser(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
                            dialog.dismiss();
//                            CheckUserModel checkUserModel = new Gson().fromJson(response.body().toString(), CheckUserModel.class);
//                            if (checkUserModel.getSuccess()) {
                            if (jsonObject1.get("response").getAsJsonArray().get(0).getAsJsonObject().get("Verify").toString().equalsIgnoreCase("true")) {
                                binding.passwordL.setVisibility(View.VISIBLE);
                                binding.pass.setVisibility(View.VISIBLE);
                                binding.btSubmit.setVisibility(View.VISIBLE);

                                binding.btSubmit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (binding.editPassword.getText().toString().equalsIgnoreCase("")) {
                                            Toast.makeText(context, "Please enter Password", Toast.LENGTH_SHORT).show();
                                        } else {
                                            HashMap<String, Object> hashMap = new HashMap<>();
                                            hashMap.put("phoneNumber", binding.edtMobNum.getText().toString());
                                            hashMap.put("Password", binding.editPassword.getText().toString());
                                            apiVerifyOtp(hashMap);
                                        }
                                    }
                                });


                                //
//                                if(checkUserModel.getResponse().get(0).getVerify()){
                                //    Toast.makeText(MobileNumberSignup.this, "Already Registered", Toast.LENGTH_SHORT).show();
                                //Intent in = new Intent(MobileNumberSignup.this, SetPassword.class);
                                //startActivity(in);
                            } else {
                                // Intent in = new Intent(MobileNumberSignup.this, OtpPage.class);
                                // in.putExtra("mobileNumber", binding.edtMobNumR.getText().toString());
                                //startActivity(in);
                            }
//                            }
                        } else {
                            dialog.dismiss();
                            Toast.makeText(context, "This mobile number not registered", Toast.LENGTH_SHORT).show();
                            //HashMap<String, Object> hashMap = new HashMap<>();
                            //hashMap.put("phoneNumber", binding.edtMobNumR.getText().toString());
                            //apiRegistrationWithOTP(jsonObject);
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

    public void apiVerifyOtp(final HashMap<String, Object> jsonObject) {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().verifyOTP(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                Log.v("response", "response" + response);
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
                            //  dialog.dismiss();
                            loginApi();
                            //Intent in=new Intent(MobileNumber.this,ChooseSubject.class);
                            //startActivity(in);
//                            CheckUserModel checkUserModel = new Gson().fromJson(response.body().toString(), CheckUserModel.class);
//                            if (checkUserModel.getSuccess()) {
                            // if (jsonObject1.get("response").getAsJsonArray().get(0).getAsJsonObject().get("Verify").toString().equalsIgnoreCase("true")) {
                            //   binding.passwordL.setVisibility(View.VISIBLE);
                            // binding.pass.setVisibility(View.VISIBLE);

                            //
//                                if(checkUserModel.getResponse().get(0).getVerify()){
                            //    Toast.makeText(MobileNumberSignup.this, "Already Registered", Toast.LENGTH_SHORT).show();
                            //Intent in = new Intent(MobileNumberSignup.this, SetPassword.class);
                            //startActivity(in);
                            //}/* else {
                            // Intent in = new Intent(MobileNumberSignup.this, OtpPage.class);
                            // in.putExtra("mobileNumber", binding.edtMobNumR.getText().toString());
                            //startActivity(in);
                            //}*/
//                            }
                        } else {
                            dialog.dismiss();
                            Toast.makeText(context, "Password does not match", Toast.LENGTH_SHORT).show();/*else {
                            Toast.makeText(context, "This mobile number not registered", Toast.LENGTH_SHORT).show();
                            //HashMap<String, Object> hashMap = new HashMap<>();
                            //hashMap.put("phoneNumber", binding.edtMobNumR.getText().toString());
                            //apiRegistrationWithOTP(jsonObject);
                        }*/
//                        loginCallback.onSuccessLogin(response.body());
                        }
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


    private void loginApi() {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("MobileNumber", binding.edtMobNum.getText().toString());
        Service.apiLogin(this, hashMap);
    }

    @Override
    public void onSuccessLogin(LoginModel loginModel) {

        if (loginModel.getSuccess().equals(true)) {
            shareprefrence.setClassName(loginModel.getResponse().get(0).getClass_());
            shareprefrence.setRememberMe(loginModel.getSuccess());
            shareprefrence.setMobile(loginModel.getResponse().get(0).getMobileNumber());
            shareprefrence.setBoard(loginModel.getResponse().get(0).getSelectedStateOrCentral());
            shareprefrence.setUserName(loginModel.getResponse().get(0).getName());
            dialog.dismiss();
            Intent intent = new Intent(MobileNumber.this, ChooseSubject.class);
            startActivity(intent);
        } else {
            dialog.dismiss();
            Toast.makeText(MobileNumber.this, "Your Mobile Number not Registered", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
//        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
