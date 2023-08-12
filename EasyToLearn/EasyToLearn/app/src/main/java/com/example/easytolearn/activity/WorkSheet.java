package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.easytolearn.R;

public class WorkSheet extends AppCompatActivity {
ImageView menulearn,test,analytic,doubts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_work_sheet );

        menulearn=findViewById( R.id.menulearn );
        test=findViewById( R.id.test );
        analytic=findViewById( R.id.analytic );
        doubts=findViewById( R.id.doubts );

        menulearn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( WorkSheet.this, ChooseSubject.class);
                startActivity( intent );
            }
        } );
        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( WorkSheet.this, Test.class);
                startActivity( intent );
            }
        } );

        analytic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( WorkSheet.this, Reports.class);
                startActivity( intent );
            }
        } );
        doubts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( WorkSheet.this, ViewBookmarks.class);
                startActivity( intent );
            }
        } );

    }
}
