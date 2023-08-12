package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.easytolearn.R;

public class MathQuestionSet extends AppCompatActivity {
LinearLayout correct_a,correct_b,correct_c,correct_d;
    ImageView menulearn,test,analytic,doubts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_math_question_set );
        correct_a=findViewById( R.id.correct_a );
        correct_b=findViewById( R.id.correct_b );
        correct_c=findViewById( R.id.correct_c );
        correct_d=findViewById( R.id.correct_d );
        menulearn=findViewById( R.id.menulearn );
        test=findViewById( R.id.test );
        analytic=findViewById( R.id.analytic );
        doubts=findViewById( R.id.doubts );

        menulearn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSet.this, ChooseSubject.class);
                startActivity( intent );
            }
        } );

        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSet.this, Test.class);
                startActivity( intent );
            }
        } );

        analytic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSet.this, Reports.class);
                startActivity( intent );
            }
        } );
        doubts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSet.this, ViewBookmarks.class);
                startActivity( intent );
            }
        } );
        correct_a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct_a.setBackgroundColor(getResources().getColor(R.color.red));
                Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MathQuestionSet.this,EasyAnswerViewSecond.class);
                startActivity( intent );
            }
        } );
        correct_b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct_b.setBackgroundColor(getResources().getColor(R.color.green));
                Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MathQuestionSet.this,EasyAnswerViewSecond.class);
                startActivity( intent );
            }
        } );
        correct_c.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct_c.setBackgroundColor(getResources().getColor(R.color.red));
                Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MathQuestionSet.this,EasyAnswerViewSecond.class);
                startActivity( intent );
            }
        } );
        correct_d.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct_d.setBackgroundColor(getResources().getColor(R.color.red));
                Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();

            }
        } );
    }
}
