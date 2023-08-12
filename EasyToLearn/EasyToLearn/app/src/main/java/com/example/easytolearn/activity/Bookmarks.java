package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.easytolearn.R;

public class Bookmarks extends AppCompatActivity {

        LinearLayout mathsLayout,physLayout,chemLayout,bioLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bookmarks );

        mathsLayout = findViewById(R.id.mathsLayout);
        physLayout = findViewById(R.id.phyLayout);
        chemLayout = findViewById(R.id.chemLayout);
        bioLayout = findViewById(R.id.bioLayout);

        mathsLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Bookmarks.this,ChapterList.class );
                intent.putExtra("subName","Maths");
                startActivity( intent );
            }
        } );
        physLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent physicIntent=new Intent( Bookmarks.this,ChapterList
                        .class );
                physicIntent.putExtra("subName","Physics");
                startActivity( physicIntent );
            }
        } );
        chemLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chemIntent=new Intent( Bookmarks.this,ChapterList.class );
                chemIntent.putExtra("subName","Chemistry");
                startActivity( chemIntent );
            }
        } );
        bioLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bioIntent=new Intent( Bookmarks.this,ChapterList.class );
                bioIntent.putExtra("subName","Biology");
                startActivity( bioIntent );
            }
        } );

    }
}
