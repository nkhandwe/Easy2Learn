package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easytolearn.Fragments.ConceptsFragment;
import com.example.easytolearn.Fragments.QuestionsetFragment;
import com.example.easytolearn.Fragments.VideosFragment;
import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityChooseOneFBinding;

public class ChooseOneF extends AppCompatActivity implements View.OnClickListener{
ActivityChooseOneFBinding binding;
    String name,sName;
    private Context context;
    int position=0,position1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_choose_one_f);
        context=this;
        Intent in=getIntent();
        name=in.getStringExtra("name");
        sName=in.getStringExtra("sName");
        position=in.getIntExtra("position",0);
        position1=position+1;
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
        binding.headingC.setText(""+sName+"\n Chapter-"+position1+" "+name);
        binding.conceptButton.setOnClickListener(this);
        binding.VideosButton.setOnClickListener(this);
        binding.QuestionSetButton.setOnClickListener(this);
        binding.WorksheetButton.setOnClickListener(this);
        binding.MindMapButton.setOnClickListener(this);
        binding.NCRTSolutionsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.conceptButton:
                Intent in=new Intent(ChooseOneF.this,ConceptActivity.class);
                in.putExtra("name",name);
                in.putExtra("sName",sName);
                in.putExtra("position",position1);
                startActivity(in);
                break;
            case R.id.VideosButton:
                Intent in1=new Intent(ChooseOneF.this,VideoActivity.class);
                in1.putExtra("name",name);
                in1.putExtra("sName",sName);
                in1.putExtra("position",position1);
                startActivity(in1);
                break;
            case R.id.Question_Set_button:
                Intent in2=new Intent(ChooseOneF.this,QuestionSetActivityNew.class);
                in2.putExtra("name",name);
                in2.putExtra("sName",sName);
                in2.putExtra("position",position1);
                startActivity(in2);
                break;
            case R.id.WorksheetButton:
                Intent in3=new Intent(ChooseOneF.this,WorkSheetActivity.class);
                in3.putExtra("name",name);
                in3.putExtra("sName",sName);
                in3.putExtra("position",position1);
                startActivity(in3);
                break;
            case R.id.Mind_Map_button:
                Intent in4=new Intent(ChooseOneF.this,MindMapActivity.class);
                in4.putExtra("name",name);
                in4.putExtra("sName",sName);
                in4.putExtra("position",position1);
                startActivity(in4);
                break;
            case R.id.NCRT_Solutions_button:
                Intent in5=new Intent(ChooseOneF.this,NCRTActivity.class);
                in5.putExtra("name",name);
                in5.putExtra("sName",sName);
                in5.putExtra("position",position1);
                startActivity(in5);
                break;
        }
    }
}
