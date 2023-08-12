package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.getWoeksheetModels.GetWorksheetsModel;
import com.example.easytolearn.Responses.getWoeksheetModels.WorksheetResponse;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.WorksheetAdapter;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityWorkSheet2Binding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class WorkSheetActivity extends AppCompatActivity {
    ActivityWorkSheet2Binding binding;
    String name, sName;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_sheet2);
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position = in.getIntExtra("position", 0);

        shareprefrence = new Shareprefrence(this);
        dialog = new Dialog(this);
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCW.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCW.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCW.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCW.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingCW.setText("" + sName + "\n Chapter-" + position + " " + name);
        getWorksheet();
    }

    Shareprefrence shareprefrence;
    Dialog dialog;

    public void getWorksheet() {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Class", shareprefrence.getClassName());
        hashMap.put("Subject", sName);
        hashMap.put("ChapterName", name);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getWorkSheets(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, retrofit2.Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();
                        if (response.isSuccessful()) {
                            dialog.dismiss();
                            GetWorksheetsModel getWorksheetsModel = new Gson().fromJson(jsonObject1.toString(), GetWorksheetsModel.class);
                            ArrayList<WorksheetResponse> worksheetList = new ArrayList<>();
                            worksheetList.addAll(getWorksheetsModel.getResponse());

                            binding.rvWorksheet.setLayoutManager(new LinearLayoutManager(WorkSheetActivity.this));
                            WorksheetAdapter worksheetAdapter = new WorksheetAdapter(worksheetList, WorkSheetActivity.this);
                            binding.rvWorksheet.setAdapter(worksheetAdapter);

                        }
                        Log.v("json", "json" + jsonObject1.toString());

                    }
                } catch (Exception e) {
                    dialog.dismiss();
                    Toast.makeText(WorkSheetActivity.this, "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(WorkSheetActivity.this, "someting went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
