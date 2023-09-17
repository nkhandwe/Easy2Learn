package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.databinding.ActivityLeaderBoardBinding;

public class LeaderBoardActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityLeaderBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_leader_board);
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.filter.setOnClickListener(this);
        binding.filter1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
                Intent menuLIntent = new Intent(LeaderBoardActivity.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(LeaderBoardActivity.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(LeaderBoardActivity.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(LeaderBoardActivity.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(LeaderBoardActivity.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                break;
            case R.id.filter:
                binding.filter1.setVisibility(View.VISIBLE);
                binding.header.setVisibility(View.VISIBLE);
                binding.filter.setVisibility(View.GONE);
                break;
            case R.id.filter1:
                binding.filter1.setVisibility(View.GONE);
                binding.filter.setVisibility(View.VISIBLE);
                binding.header.setVisibility(View.GONE);
                break;
        }
    }
}
