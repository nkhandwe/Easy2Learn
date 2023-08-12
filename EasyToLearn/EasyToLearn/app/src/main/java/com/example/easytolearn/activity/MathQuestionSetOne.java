package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.easytolearn.R;

public class MathQuestionSetOne extends AppCompatActivity {
ImageView easy_question;
    ImageView menulearn,test,analytic,doubts;

    LinearLayout medLayout,hardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_math_question_set_one );
        easy_question=findViewById( R.id.easy_question);
        menulearn=findViewById( R.id.menulearn );
        test=findViewById( R.id.test );
        analytic=findViewById( R.id.analytic );
        doubts=findViewById( R.id.doubts );

        medLayout = findViewById(R.id.medQuesLayout);
        hardLayout = findViewById(R.id.hardQuesLayout);

        medLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this,MathQuestionSet.class );
                startActivity( intent );
            }
        });

        hardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this,MathQuestionSet.class );
                startActivity( intent );
            }
        });


        menulearn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this, ChooseSubject.class);
                startActivity( intent );
            }
        } );
        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this, Test.class);
                startActivity( intent );
            }
        } );

        analytic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this, Reports.class);
                startActivity( intent );
            }
        } );
        doubts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this, ViewBookmarks.class);
                startActivity( intent );
            }
        } );
        easy_question.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathQuestionSetOne.this,MathQuestionSet.class );
                startActivity( intent );
            }
        } );
    }
}
