package com.example.easytolearn.activity.e2lTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.e2lAssessmentModels.AssessmentResponse;
import com.example.easytolearn.Responses.e2lAssessmentModels.GetAssessmentModel;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.adapter.AssessmentAdapter;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityE2lSchoolAssessmentBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class E2lSchoolAssessmentActivity extends AppCompatActivity {

    ActivityE2lSchoolAssessmentBinding binding;
    private Dialog dialog;
    ArrayList<AssessmentResponse> assessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_e2l_school_assessment);

        dialog = new Dialog(this);
        getAssessments();
//        setContentView(R.layout.activity_e2l_school_assessment);
    }

    public void setAdapter(){
        binding.rvAssessments.setLayoutManager(new LinearLayoutManager(this));
        AssessmentAdapter assessmentAdapter = new AssessmentAdapter(assessList, this);
        binding.rvAssessments.setHasFixedSize(true);
        binding.rvAssessments.setAdapter(assessmentAdapter);
    }

    public void getAssessments() {
        dialog.dismiss();
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("AssessmentStatus", "true");
        hashMap.put("SchoolName", "Rainbow Group of Schools");
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getSchoolAssessment(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();

                try {

                    if (response != null && response.body() != null) {
                        GetAssessmentModel getAssessmentModel = new Gson().fromJson(jsonObject.toString(), GetAssessmentModel.class);
                        assessList  = new ArrayList<>();
                        assessList.addAll(getAssessmentModel.getResponse());

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
}