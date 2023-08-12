package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.easytolearn.R;

public class Dashboard extends AppCompatActivity  {

    LinearLayout physLayout,chemLayout,bioLayout,mathsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_dashboard);

        physLayout = findViewById(R.id.physLayout);
        chemLayout = findViewById(R.id.chemLayout);
        bioLayout = findViewById(R.id.bioLayout);
        mathsLayout = findViewById(R.id.mathsLayout);

        physLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Physics.class);
                startActivity(i);
            }
        });

        chemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chemIntent=new Intent( Dashboard.this,ChapterList.class );
                chemIntent.putExtra("subName","Chemistry");
                startActivity( chemIntent );
            }
        });

        bioLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bioIntent=new Intent( Dashboard.this,ChapterList.class );
                bioIntent.putExtra("subName","Biology");
                startActivity( bioIntent );
            }
        });

        mathsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Dashboard.this,ChapterList.class );
                intent.putExtra("subName","Maths");
                startActivity( intent );
            }
        });
    }

}
