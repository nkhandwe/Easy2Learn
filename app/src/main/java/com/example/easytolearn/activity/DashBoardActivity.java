package com.example.easytolearn.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.easytolearn.Fragments.DashBoardFragment;
import com.example.easytolearn.MainActivity;
import com.example.easytolearn.R;
import com.example.easytolearn.adapter.ChapterListAdapter;
import com.example.easytolearn.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityDashBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board);
        binding.menu.setOnClickListener(this);
        binding.learnL.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_container_main, new DashBoardFragment()).commit();

    }

    @Override
    public void onClick(View view) {
        

    }
    @Override
    public void onBackPressed() {
       /* Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.activity_home_container_main);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (fragment instanceof DashBoardFragment) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } /*else if (fragment instanceof ChapterListFragment) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else {
            final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(DashBoardActivity.this).create();
            alertDialog.setTitle(R.string.app_name);
            alertDialog.setCancelable(false);

            alertDialog.setMessage("fvvvcdcxd");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, DashBoardActivity.this.getString(android.R.string.ok), new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                  finish();
                  finishAffinity();
                    dialog.dismiss();

                }
            });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }*/
}}
