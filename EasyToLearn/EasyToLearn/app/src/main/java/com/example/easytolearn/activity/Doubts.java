package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityDoubtsBinding;

public class Doubts extends AppCompatActivity implements View.OnClickListener {
    private ActivityDoubtsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_doubts);
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.mathsLayout.setOnClickListener(this);
        binding.bioLayout.setOnClickListener(this);
        binding.chemLayout.setOnClickListener(this);
        binding.phyLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
                Intent menuLIntent = new Intent(Doubts.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(Doubts.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(Doubts.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(Doubts.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(Doubts.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                break;
            case R.id.mathsLayout:
                Intent in = new Intent(Doubts.this, DoubtsChatActivity.class);
                startActivity(in);
                break;
            case R.id.bioLayout:
                Intent inb = new Intent(Doubts.this, DoubtsChatActivity.class);
                startActivity(inb);
                break;
            case R.id.chemLayout:
                Intent inc = new Intent(Doubts.this, DoubtsChatActivity.class);
                startActivity(inc);
                break;
            case R.id.phyLayout:
                Intent inp = new Intent(Doubts.this, DoubtsChatActivity.class);
                startActivity(inp);
                break;
        }

    }
}
