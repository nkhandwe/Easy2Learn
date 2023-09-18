package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityNCRTBinding;

public class NCRTActivity extends AppCompatActivity {
ActivityNCRTBinding binding;
    String name, sName;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_n_c_r_t);
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position=in.getIntExtra("position",0);
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCN.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCN.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCN.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCN.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingCN.setText(""+sName+"\n Chapter-"+position+" "+name);

    }
}
