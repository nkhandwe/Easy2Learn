package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.verifyOtpModel.VerifyOtpModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPassword extends AppCompatActivity {
    Button bt_submit;
    TextView tvLogin, tv_PrivPol, tv_tnc;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        bt_submit = findViewById(R.id.bt_submit);

        tvLogin = findViewById(R.id.tv_login);
        tv_PrivPol = findViewById(R.id.tv_privPol);
        tv_tnc = findViewById(R.id.tv_tnc);

        tvLogin.setPaintFlags(tvLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv_PrivPol.setPaintFlags(tv_PrivPol.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv_tnc.setPaintFlags(tv_tnc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Intent intent = getIntent();
        if (intent != null) {
            mobileNumber = intent.getStringExtra("mobileNumber");
        }

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this, ChooseClass.class);
                startActivity(intent);
            }
        });

        tv_PrivPol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    public void apiSETPASSWORD(final HashMap<String, Object> jsonObject) {
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().verifyOTP(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();

                        if (jsonObject1.get("success").toString().equalsIgnoreCase("true")) {
//                            VerifyOtpModel verifyOtpModel = new Gson().fromJson(jsonObject1.toString(), VerifyOtpModel.class);
//                            if (verifyOtpModel.getSuccess()) {
//                                Intent in = new Intent(SetPassword.this, SetPassword.class);
//                                in.putExtra("mobileNumber", mobileNumber);
//                                startActivity(in);
//                            }

                        } else {
                            Toast.makeText(SetPassword.this, "Please enter correct OTP", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(SetPassword.this, "Something went wrong.... Please Try again", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
