package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityVideoShowBinding;

public class VideoShowActivity extends AppCompatActivity {
    String vedioUrl;
    private Context context;
    private ActivityVideoShowBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_video_show);
        context=this;
        Intent in=getIntent();
        vedioUrl=in.getStringExtra("vedioUrl");
        binding.web.loadUrl(vedioUrl);
        binding.web.setWebViewClient(new WebViewClient());
        binding.web.setWebChromeClient(new WebChromeClient());
        binding.web.getSettings().setJavaScriptEnabled(true);
    }
}
