package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.checkUserModel.CheckUserModel;
import com.example.easytolearn.Responses.verifyOtpModel.VerifyOtpModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpPage extends AppCompatActivity {
    Button bt_submit;
    TextView tv_Login, tv_PrivPol, tv_tnc;
    String mobileNumber;
    EditText et_pin1, et_pin2, et_pin3, et_pin4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        bt_submit = findViewById(R.id.bt_submit);

        tv_Login = findViewById(R.id.tv_login);
        tv_PrivPol = findViewById(R.id.tv_PrivPol);
        tv_tnc = findViewById(R.id.tv_tnc);
        et_pin1 = findViewById(R.id.et_pin1);
        et_pin2 = findViewById(R.id.et_pin2);
        et_pin3 = findViewById(R.id.et_pin3);
        et_pin4 = findViewById(R.id.et_pin4);

        tv_Login.setPaintFlags(tv_Login.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv_PrivPol.setPaintFlags(tv_PrivPol.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv_tnc.setPaintFlags(tv_tnc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tv_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtpPage.this, MobileNumber.class);
                startActivity(intent);
            }
        });

        tv_PrivPol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtpPage.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            mobileNumber = intent.getStringExtra("mobileNumber");
        }


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_pin1.getText() != null && et_pin2.getText() != null && et_pin3.getText() != null && et_pin4.getText() != null) {
                    if (!et_pin1.getText().toString().isEmpty() && !et_pin2.getText().toString().isEmpty() &&
                            !et_pin3.getText().toString().isEmpty() && !et_pin4.getText().toString().isEmpty()) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("phoneNumber", mobileNumber);
                        hashMap.put("OTP", et_pin1.getText().toString() + et_pin2.getText().toString() + et_pin3.getText().toString() + et_pin4.getText().toString());
                        apiVerifyOtp(hashMap);
                    } else {
                        Toast.makeText(OtpPage.this, "Please enter correct OTP", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(OtpPage.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void apiVerifyOtp(final HashMap<String, Object> jsonObject) {
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().verifyOTP(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
                            VerifyOtpModel verifyOtpModel = new Gson().fromJson(jsonObject1.toString(), VerifyOtpModel.class);
                            if (verifyOtpModel.getSuccess()) {
                                Intent in = new Intent(OtpPage.this, SetPassword.class);
                                in.putExtra("mobileNumber", mobileNumber);
                                startActivity(in);
                            }

                        } else {
                            Toast.makeText(OtpPage.this, "Please enter correct OTP", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(OtpPage.this, "Something went wrong.... Please Try again", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
