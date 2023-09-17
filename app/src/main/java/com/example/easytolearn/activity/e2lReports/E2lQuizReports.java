package com.example.easytolearn.activity.e2lReports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.e2lAssessmentModels.GetAssessmentModel;
import com.example.easytolearn.Responses.e2lQuizReportsModels.E2lQuizReportsResponse;
import com.example.easytolearn.Responses.e2lQuizReportsModels.GetE2lQuizReportsModel;
import com.example.easytolearn.Responses.quizReportsModels.QuizReportsResponseModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.AssessmentAdapter;
import com.example.easytolearn.adapter.E2lQuizReportAdapter;
import com.example.easytolearn.adapter.QuizReportAdapter;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityE2lBinding;
import com.example.easytolearn.databinding.ActivityE2lQuizReports2Binding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class E2lQuizReports extends AppCompatActivity {
    ActivityE2lQuizReports2Binding binding;
    private Dialog dialog;
    ArrayList<E2lQuizReportsResponse> assessList;
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
        hashMap.put("MobileNumber", Long.parseLong("9100091000"));
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getE2lQuizReports(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();

                try {

                    if (response != null && response.body() != null) {
                        GetE2lQuizReportsModel getE2lQuizReportsModel = new Gson().fromJson(jsonObject.toString(), GetE2lQuizReportsModel.class);
                        assessList  = new ArrayList<>();
                        assessList.addAll(getE2lQuizReportsModel.getResponse());

                        setAdapter();
                    }
                } catch (Exception e) {
//                    Toast.makeText(E2lAssessmentActivity.this, "" + e, Toast.LENGTH_SHORT).show();
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
        E2lQuizReportAdapter quizReportAdapter = new E2lQuizReportAdapter(assessList, this);
        binding.rvReports.setHasFixedSize(true);
        binding.rvReports.setAdapter(quizReportAdapter);
    }

}