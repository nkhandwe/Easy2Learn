package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.databinding.ActivityMindMapBinding;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MindMapActivity extends AppCompatActivity {
    ActivityMindMapBinding binding;
    String name, sName;
    int position = 0;
    Shareprefrence shareprefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mind_map);
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position = in.getIntExtra("position", 0);
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCM.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCM.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCM.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCM.setBackgroundResource(R.drawable.iconred);
            }
        }
        shareprefrence = new Shareprefrence(this);
        binding.headingCM.setText("" + sName + "\n Chapter-" + position + " " + name);
        getMindMap();
    }

    public void getMindMap() {
        HashMap<String, Object> hashMapBookmark = new HashMap<>();
        hashMapBookmark.put("Class", shareprefrence.getClassName());
        hashMapBookmark.put("ChapterName", shareprefrence.getMobile());
        hashMapBookmark.put("Subject", sName);

        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getMindMaps(hashMapBookmark);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
//                        bookmarkedList = new ArrayList<>();
//                        bookmarkedList.addAll(response.body().getResponse());
//
//                        setData();
                    } else {
//                        setData();
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(MindMapActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
