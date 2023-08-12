package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.adapter.TabPagerAdapter;
import com.example.easytolearn.databinding.ActivityChapterOneFractionBinding;
import com.google.android.material.tabs.TabLayout;

public class ChapterOneFraction extends AppCompatActivity {
    private String[] mLiatItems = {"New Orders","Accepted Orders","Delivered Orders"};
    private ActivityChapterOneFractionBinding binding;
    String name,sName;
    private Context context;
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding= DataBindingUtil.setContentView(this,R.layout.activity_chapter_one_fraction );
        context=this;
        Intent in=getIntent();
        name=in.getStringExtra("name");
        sName=in.getStringExtra("sName");
        position=in.getIntExtra("position",0);
       position=position+1;
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingC.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingC.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingC.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingC.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingC.setText(""+sName+"\n Chapter-"+position+" "+name);
        for (int i=0;i<mLiatItems.length;i++)
        {
            binding.mainTablayout.addTab(binding.mainTablayout.newTab().setText(""+mLiatItems[i]),i);
        }
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(sName,name,position,getSupportFragmentManager());
        binding.mainViewPager.setAdapter(tabPagerAdapter);
        binding.mainTablayout.setupWithViewPager(binding.mainViewPager);
    }
}
