package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityTestBinding;

import org.w3c.dom.Text;

public class Test extends AppCompatActivity implements View.OnClickListener {
    ActivityTestBinding binding;
    private Context context;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        context=this;
        Intent in = getIntent();
        data = in.getStringExtra("data");
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.FirstTL.setOnClickListener(this);
        binding.SecondTL.setOnClickListener(this);
        binding.ThirdTL.setOnClickListener(this);
//        if(data.equalsIgnoreCase("test")){
//            binding.toolbarIvImageLogo.setText("Tests");
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
                Intent menuLIntent=new Intent( Test.this, ChooseSubject.class);
                startActivity( menuLIntent );
                break;
            case R.id.test:
                Intent testIntent=new Intent( Test.this, Test.class);
                testIntent.putExtra("data","test");
                startActivity( testIntent );
                break;
            case R.id.analytic:
                Intent testIntent1=new Intent( Test.this, Reports.class);
                testIntent1.putExtra("data","Analytics");
                startActivity( testIntent1 );
                break;
            case R.id.doubts:
                Intent doubtsIntent=new Intent( Test.this, ViewBookmarks.class);
                startActivity( doubtsIntent );
                break;
            case R.id.menu:
                Intent menuIntent=new Intent( Test.this,MenuItem.class );
                startActivity( menuIntent );
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_left);
                break;
            case R.id.FirstTL:
                Intent in=new Intent(Test.this,QuizReportActivity.class);
                in.putExtra("first",binding.FirsttText.getText().toString());
              //  in.putExtra("second",binding.SecondtText.getText().toString());
                //in.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(in);
                break;
            case R.id.SecondTL:
                Intent inS=new Intent(Test.this,QuizReportActivity.class);
                //inS.putExtra("first",binding.FirsttText.getText().toString());
                inS.putExtra("second",binding.SecondtText.getText().toString());
                //inS.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(inS);
                break;
            case R.id.ThirdTL:
                Intent inT=new Intent(Test.this,QuizReportActivity.class);
               // inT.putExtra("first",binding.FirsttText.getText().toString());
               // inT.putExtra("second",binding.SecondtText.getText().toString());
                inT.putExtra("third",binding.ThirdtText.getText().toString());
                startActivity(inT);
                break;
        }

    }
}
