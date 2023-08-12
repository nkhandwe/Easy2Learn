package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.easytolearn.R;
import com.example.easytolearn.adapter.QuestionSetTypeAdapter;
import com.example.easytolearn.databinding.ActivityQuestionSetBinding;
import com.google.android.material.tabs.TabLayout;

public class QuestionSetActivity extends AppCompatActivity {
    private String[] mLiatItems = {"Easy ","Medium","Hard"};
    private ActivityQuestionSetBinding binding;
    private Context context;
    private String setName,cName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_question_set);
        context=this;
        Intent in=getIntent();
        setName=in.getStringExtra("setName");
        cName=in.getStringExtra("cName");
        for (int i=0;i<mLiatItems.length;i++)
        {
            binding.mainTablayout.addTab(binding.mainTablayout.newTab().setText(""+mLiatItems[i]),i);
        }
        QuestionSetTypeAdapter tabPagerAdapter = new QuestionSetTypeAdapter(cName,setName,getSupportFragmentManager());
        binding.mainViewPager.setAdapter(tabPagerAdapter);
        binding.mainTablayout.setupWithViewPager(binding.mainViewPager);
    }
}
