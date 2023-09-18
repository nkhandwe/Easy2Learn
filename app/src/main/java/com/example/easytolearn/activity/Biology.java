package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ChapterListAdapter;
import com.example.easytolearn.callback.ChapterListCallback;
import com.example.easytolearn.databinding.ActivityBiologyBinding;
import com.example.easytolearn.databinding.ActivityChapterListBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Biology extends AppCompatActivity implements ChapterListCallback {

    String subName;
    private Context context;
    private ActivityBiologyBinding binding;
    private List<ChapterListResponse.ResponseBean> list=new ArrayList<>();
    private ChapterListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding= DataBindingUtil.setContentView(this,R.layout.activity_biology );
        context=this;
        Intent in=getIntent();
        shareprefrence=new Shareprefrence(Biology.this);
        subName=in.getStringExtra("subName");
        Log.v("subname","subname"+subName);
        chapterList();
    }

    private Shareprefrence shareprefrence;
    private void chapterList(){
        HashMap<String,Object> chapterListRequest = new HashMap<>();
        chapterListRequest.put("Class", shareprefrence.getClassName());
        chapterListRequest.put("Subject","Biology");
        // JSONObject jsonObject = new JSONObject(chapterListRequest);
        Service.apiChapterList(this,chapterListRequest);
    }

    @Override
    public void onSuccess(List<ChapterListResponse.ResponseBean> address) {
        list.clear();
        list.addAll(address);
        binding.recyclerB.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        //adapter = new ChapterListAdapter(subName,list, context);
        binding.recyclerB.setAdapter(adapter);
    }

    @Override
    public void onError(String s) {
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
