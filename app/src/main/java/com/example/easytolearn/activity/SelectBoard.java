package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.easytolearn.R;
import com.example.easytolearn.SharePrefrence.Shareprefrence;

public class SelectBoard extends AppCompatActivity {
LinearLayout cbseLayout,apBoardLayout,telgBoardLayout;
private Shareprefrence shareprefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_select_board );
        shareprefrence=new Shareprefrence(SelectBoard.this);
        cbseLayout=findViewById( R.id.cbseLayout );
        apBoardLayout=findViewById( R.id.apLayout );
        telgBoardLayout=findViewById( R.id.TelgLayout );

        cbseLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SelectBoard.this,Registration.class );
                shareprefrence.setCourse("CBSE");
                startActivity( intent );
            }
        } );
        apBoardLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SelectBoard.this,Registration.class );
                shareprefrence.setCourse("AP State Board");
                startActivity( intent );
            }
        } );
        telgBoardLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SelectBoard.this,Registration.class );
                shareprefrence.setCourse("Telangana State Board");
                startActivity( intent );
            }
        } );

    }
}
