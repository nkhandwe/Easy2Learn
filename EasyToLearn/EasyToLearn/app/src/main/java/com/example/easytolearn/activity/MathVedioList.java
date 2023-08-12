package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytolearn.R;

public class MathVedioList extends AppCompatActivity {
TextView questionset,worksheet;
    ImageView menulearn,test,analytic,doubts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_math_vedio_list );
        questionset=findViewById( R.id.questionset );
        worksheet=findViewById( R.id.worksheet );
        menulearn=findViewById( R.id.menulearn );
        test=findViewById( R.id.test );
        analytic=findViewById( R.id.analytic );
        doubts=findViewById( R.id.doubts );

        menulearn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this, ChooseSubject.class);
                startActivity( intent );
            }
        } );
        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this, Test.class);
                startActivity( intent );
            }
        } );

        analytic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this, Reports.class);
                startActivity( intent );
            }
        } );
        doubts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this, ViewBookmarks.class);
                startActivity( intent );
            }
        } );
        questionset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this,MathQuestionSetOne.class );
                startActivity( intent );
            }
        } );
        worksheet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MathVedioList.this,WorkSheet.class );
                startActivity( intent );
            }
        } );
    }
}
