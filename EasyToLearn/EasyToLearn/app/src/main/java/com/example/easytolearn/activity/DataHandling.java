package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.easytolearn.R;

public class DataHandling extends AppCompatActivity {
TextView ncertsolution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_data_handling );
        ncertsolution=findViewById( R.id.ncertsolution );
        ncertsolution.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( DataHandling.this,NcertSolution.class );
                startActivity( intent );
            }
        } );
    }
}
