package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityViewWorksheetBinding;

public class ViewWorksheetActivity extends AppCompatActivity {
    ActivityViewWorksheetBinding binding;
    String imageData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_worksheet);

        imageData = getIntent().getStringExtra("data");
//        binding.wbWorksheet.loadData(imageData, "text/html", "UTF-8");
        WebSettings settings =  binding.wbWorksheet.getSettings();
        settings.setDomStorageEnabled(true);
        binding.wbWorksheet.getSettings().setJavaScriptEnabled(true);
//        binding.wbWorksheet.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
//        binding.wbWorksheet.getSettings().setPluginState(WebSettings.PluginState.ON);
//        binding.wbWorksheet.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return false;
//            }
//
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
//                handler.proceed() ;
//            }
//        });
        binding.wbWorksheet.loadUrl(imageData);

    }
}