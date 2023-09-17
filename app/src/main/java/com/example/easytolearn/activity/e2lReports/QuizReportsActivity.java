package com.example.easytolearn.activity.e2lReports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.quizReportsModels.GetQuizReportsModel;
import com.example.easytolearn.Responses.quizReportsModels.QuizReportsResponseModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.e2lTest.E2lAssessmentActivity;
import com.example.easytolearn.adapter.QuizReportAdapter;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityE2lQuizReports2Binding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizReportsActivity extends AppCompatActivity {
    ActivityE2lQuizReports2Binding binding;
    private Dialog dialog;
    ArrayList<QuizReportsResponseModel> assessList;
    Shareprefrence shareprefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_e2l_quiz_reports2);

        shareprefrence = new Shareprefrence(this);
        dialog = new Dialog(this);
        getAssessments();
    }

    public void getAssessments() {
        dialog.dismiss();
        HashMap<String, Object> hashMap = new HashMap();
//        hashMap.put("MobileNumber", Long.parseLong(shareprefrence.getMobile()));
        hashMap.put("MobileNumber", Long.parseLong("9100091000"));
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getQuizReports(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();

                try {

                    if (response != null && response.body() != null) {
                        GetQuizReportsModel getQuizReportsModel = new Gson().fromJson(jsonObject.toString(), GetQuizReportsModel.class);
                        assessList  = new ArrayList<>();
                        assessList.addAll(getQuizReportsModel.getResponse());

                        setAdapter();
                    }
                } catch (Exception e) {
                    Toast.makeText(QuizReportsActivity.this, "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //Toast.makeText(context, "Somethiing went wrong1", Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }

    public void setAdapter(){
        binding.rvReports.setLayoutManager(new LinearLayoutManager(this));
        QuizReportAdapter quizReportAdapter = new QuizReportAdapter(assessList, this);
        binding.rvReports.setHasFixedSize(true);
        binding.rvReports.setAdapter(quizReportAdapter);
    }
}