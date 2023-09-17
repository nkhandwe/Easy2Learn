package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.adapter.ChapterListAdapter;
import com.example.easytolearn.callback.ChapterListCallback;
import com.example.easytolearn.databinding.ActivityPhysicsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Physics extends AppCompatActivity implements ChapterListCallback {
    String subName;
    private Context context;
    private ActivityPhysicsBinding binding;
    private List<ChapterListResponse.ResponseBean> list = new ArrayList<>();
    private ChapterListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_physics);
        context = this;
        Intent in = getIntent();
        subName = in.getStringExtra("subName");
        //  binding.heading.setText(""+subName+""+"List of Chapters");
        Log.v("subname", "subname" + subName);
        chapterList();
    }

    private void chapterList() {
        HashMap<String, Object> chapterListRequest = new HashMap<>();
        chapterListRequest.put("Class", 10);
        chapterListRequest.put("Subject", "Physics");
        // JSONObject jsonObject = new JSONObject(chapterListRequest);
        Service.apiChapterList(this, chapterListRequest);
    }

    @Override
    public void onSuccess(List<ChapterListResponse.ResponseBean> address) {
        list.clear();
        list.addAll(address);
        binding.recyclerP.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        //adapter = new ChapterListAdapter(subName,list, context);
        binding.recyclerP.setAdapter(adapter);
    }

    @Override
    public void onError(String s) {
        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();
    }
}
