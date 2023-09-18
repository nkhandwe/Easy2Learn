package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easytolearn.R;

public class SelectCourseSet extends AppCompatActivity {
Button bt_completesetup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_select_course_set );
        bt_completesetup=findViewById( R.id.bt_completesetup );
        bt_completesetup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SelectCourseSet.this,ChooseSubject.class );
                startActivity( intent );
            }
        } );
    }
}
