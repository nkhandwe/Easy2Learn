package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytolearn.R;

public class IntegersQuestions extends AppCompatActivity {
TextView correct_answer,wrong_answer;
LinearLayout linear_correct,linear_wrong;
    ImageView menulearn,test,analytic,doubts;

Button Submit_question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_integers_questions );
        correct_answer=findViewById( R.id.correct_answer );
        wrong_answer=findViewById( R.id.wrong_answer);
        Submit_question=findViewById( R.id.next_question );
        linear_correct=findViewById( R.id.linear_correct );
        linear_wrong=findViewById( R.id.linear_wrong );
        menulearn=findViewById( R.id.menulearn );
        test=findViewById( R.id.test );
        analytic=findViewById( R.id.analytic );
        doubts=findViewById( R.id.doubts );

        menulearn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntegersQuestions.this, ChooseSubject.class);
                startActivity( intent );
            }
        } );
        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntegersQuestions.this, Test.class);
                startActivity( intent );
            }
        } );

        analytic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntegersQuestions.this, Reports.class);
                startActivity( intent );
            }
        } );
        doubts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntegersQuestions.this, ViewBookmarks.class);
                startActivity( intent );
            }
        } );
        linear_correct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_correct.setBackgroundColor(getResources().getColor(R.color.green));
                Toast.makeText(getApplicationContext(),"Please Submit Answer",Toast.LENGTH_SHORT).show();
            }
        } );

        linear_wrong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_wrong.setBackgroundColor(getResources().getColor(R.color.red));
                Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(IntegersQuestions.this,AnswerView.class);
                startActivity( intent );
            }
        } );


        Submit_question.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntegersQuestions.this,AnswerView.class);
                startActivity( intent );
            }
        } );
    }
}
