package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityQuizReportBinding;

public class QuizReportActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityQuizReportBinding binding;
    String first,second,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_report);
        Intent in=getIntent();
        first=in.getStringExtra("first");
        second=in.getStringExtra("second");
        third=in.getStringExtra("third");
        if(first!=null){
            if(!first.equalsIgnoreCase("")){
                binding.headingQ.setText(""+first);
            }
        }
        if(second!=null){
            if(!second.equalsIgnoreCase("")){
                binding.headingQ.setText(""+second);
            }
        }
        if(third!=null){
            if(!third.equalsIgnoreCase("")){
                binding.headingQ.setText(""+third);
            }
        }

        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
                Intent menuLIntent = new Intent(QuizReportActivity.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(QuizReportActivity.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(QuizReportActivity.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(QuizReportActivity.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(QuizReportActivity.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                break;
        }
    }
}
