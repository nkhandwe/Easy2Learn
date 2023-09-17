package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityReportsBinding;

public class Reports extends AppCompatActivity implements View.OnClickListener{
    ActivityReportsBinding binding;
    private Context context;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        binding = DataBindingUtil.setContentView(this, R.layout.activity_reports);
        context=this;
        Intent in=getIntent();
        data=in.getStringExtra("data");
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.FirstTL.setOnClickListener(this);
        binding.SecondTL.setOnClickListener(this);
        binding.ThirdTL.setOnClickListener(this);
//        if(data.equalsIgnoreCase("Reports")){
//            binding.toolbarIvImageLogo.setText("Reportss");
//            binding.FirsttText.setText("E2I Assessments");
//            binding.SecondtText.setText("School Assessment");
//            binding.ThirdtText.setText("School Assignment");
//
//        }
//        if(data.equalsIgnoreCase("Analytics")){
//            binding.toolbarIvImageLogo.setText("Analytics");
//            binding.FirsttText.setText("E2I Quiz Reports");
//            binding.SecondtText.setText("Quiz Reports");
//            binding.ThirdtText.setText("Assignment Reports");
//        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menulearn:
                Intent menuLIntent=new Intent( Reports.this, ChooseSubject.class);
                startActivity( menuLIntent );
                break;
            case R.id.test:
                Intent ReportsIntent=new Intent( Reports.this, Reports.class);
                ReportsIntent.putExtra("data","Reports");
                startActivity( ReportsIntent );
                break;
            case R.id.analytic:
//                Intent ReportsIntent1=new Intent( Reports.this, Reports.class);
//                ReportsIntent1.putExtra("data","Analytics");
//                startActivity( ReportsIntent1 );
                break;
            case R.id.doubts:
                Intent doubtsIntent=new Intent( Reports.this, ViewBookmarks.class);
                startActivity( doubtsIntent );
                break;
            case R.id.menu:
                Intent menuIntent=new Intent( Reports.this,MenuItem.class );
                startActivity( menuIntent );
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_left);
                break;
            case R.id.FirstTL:
                Intent in=new Intent(Reports.this,QuizReportActivity.class);
                in.putExtra("first",binding.FirsttText.getText().toString());
                //  in.putExtra("second",binding.SecondtText.getText().toString());
                //in.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(in);
                break;
            case R.id.SecondTL:
                Intent inS=new Intent(Reports.this,QuizReportActivity.class);
                //inS.putExtra("first",binding.FirsttText.getText().toString());
                inS.putExtra("second",binding.SecondtText.getText().toString());
                //inS.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(inS);
                break;
            case R.id.ThirdTL:
                Intent inT=new Intent(Reports.this,QuizReportActivity.class);
                // inT.putExtra("first",binding.FirsttText.getText().toString());
                // inT.putExtra("second",binding.SecondtText.getText().toString());
                inT.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(inT);
                break;
        }

    }
}
