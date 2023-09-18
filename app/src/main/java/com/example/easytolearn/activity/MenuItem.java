package com.example.easytolearn.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.MainActivity;
import com.example.easytolearn.R;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.e2lReports.AssignmentsReportsActivity;
import com.example.easytolearn.activity.e2lReports.E2lQuizReports;
import com.example.easytolearn.activity.e2lReports.QuizReportsActivity;
import com.example.easytolearn.activity.e2lTest.E2lAssessmentActivity;
import com.example.easytolearn.activity.e2lTest.E2lSchoolAssessmentActivity;
import com.example.easytolearn.activity.e2lTest.SchoolAssignmentActivity;
import com.example.easytolearn.databinding.ActivityMenuItemBinding;

public class MenuItem extends AppCompatActivity implements View.OnClickListener {
    ActivityMenuItemBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_item);
        context = this;
        binding.backbutton.setOnClickListener(this);
        binding.backbutton.setOnClickListener(this);
        binding.tvDashboard.setOnClickListener(this);
        binding.tvMath.setOnClickListener(this);
        binding.tvPhysics.setOnClickListener(this);
        binding.tvChemistry.setOnClickListener(this);
        binding.tvBiology.setOnClickListener(this);
        binding.tvBookmarks.setOnClickListener(this);
        binding.tvLeaderboard.setOnClickListener(this);
        binding.tvPrivacy.setOnClickListener(this);
        binding.tvDoubts.setOnClickListener(this);
        binding.showR.setOnClickListener(this);
        binding.hideR.setOnClickListener(this);
        binding.showT.setOnClickListener(this);
        binding.hodeT.setOnClickListener(this);
        binding.tvTest.setOnClickListener(this);
        binding.testFirst.setOnClickListener(this);
        binding.testSecond.setOnClickListener(this);
        binding.testThird.setOnClickListener(this);
        binding.tvReports.setOnClickListener(this);
        binding.reportFirst.setOnClickListener(this);
        binding.reportSecond.setOnClickListener(this);
        binding.reportThird.setOnClickListener(this);
        binding.tvLogout.setOnClickListener(this);
        binding.tvReferEarn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backbutton:
                Intent intent = new Intent(MenuItem.this, ChooseSubject.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
                break;
            case R.id.tv_logout:
                logout();
                // binding.tvLogout.setBackgroundColor(getResources().getColor(R.color.chemistryblue));
                //Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                //Intent intentLogOut = new Intent(MenuItem.this, Registration.class);
                //startActivity(intentLogOut);
                break;
            case R.id.tv_dashboard:
                Intent intentDashboard = new Intent(MenuItem.this, ChooseSubject.class);
                startActivity(intentDashboard);
                break;
            case R.id.tv_math:
                Intent intentMaths = new Intent(MenuItem.this, ChapterList.class);
                intentMaths.putExtra("subName", "Maths");
                startActivity(intentMaths);
                break;
            case R.id.tv_physics:
                Intent physicIntent = new Intent(MenuItem.this, ChapterList
                        .class);
                physicIntent.putExtra("subName", "Physics");
                startActivity(physicIntent);
                break;
            case R.id.tv_chemistry:
                Intent chemIntent = new Intent(MenuItem.this, ChapterList.class);
                chemIntent.putExtra("subName", "Chemistry");
                startActivity(chemIntent);
                break;
            case R.id.tv_biology:
                Intent bioIntent = new Intent(MenuItem.this, ChapterList.class);
                bioIntent.putExtra("subName", "Biology");
                startActivity(bioIntent);
                break;
            case R.id.tv_bookmarks:
                Intent intentB = new Intent(MenuItem.this, ViewBookmarks.class);
                startActivity(intentB);
                break;
            case R.id.tv_leaderboard:
//                Intent intentL = new Intent(MenuItem.this, LeaderBoardActivity.class);
//                startActivity(intentL);
                break;
            case R.id.tv_doubts:
                Intent intentDoubts = new Intent(MenuItem.this, Doubts.class);
                startActivity(intentDoubts);
                break;
            case R.id.tv_privacy:
                Intent intentPrivacy = new Intent(MenuItem.this, PrivacyPolicy.class);
                startActivity(intentPrivacy);
                break;
            case R.id.hodeT:
            case R.id.tv_test:
                if(binding.testSubCat.getVisibility() == View.VISIBLE) {
                    binding.hodeT.setVisibility(View.VISIBLE);
                    binding.showT.setVisibility(View.GONE);
                    binding.testSubCat.setVisibility(View.GONE);
                } else {
                    binding.testSubCat.setVisibility(View.VISIBLE);
                    binding.showT.setVisibility(View.VISIBLE);
                    binding.hodeT.setVisibility(View.GONE);
                }
                break;
            case R.id.showT:
                binding.hodeT.setVisibility(View.VISIBLE);
                binding.showT.setVisibility(View.GONE);
                binding.testSubCat.setVisibility(View.GONE);
                break;
            case R.id.hideR:
            case R.id.tv_reports:
                if(binding.ReportSubCat.getVisibility() == View.VISIBLE){
                    binding.hideR.setVisibility(View.VISIBLE);
                    binding.showR.setVisibility(View.GONE);
                    binding.ReportSubCat.setVisibility(View.GONE);
                } else {
                    binding.ReportSubCat.setVisibility(View.VISIBLE);
                    binding.showR.setVisibility(View.VISIBLE);
                    binding.hideR.setVisibility(View.GONE);
                }
                break;
            case R.id.showR:
                binding.hideR.setVisibility(View.VISIBLE);
                binding.showR.setVisibility(View.GONE);
                binding.ReportSubCat.setVisibility(View.GONE);
                break;
            case R.id.tv_refer_earn:
                Intent in = new Intent(MenuItem.this, ReferEarnActvity.class);
                startActivity(in);
                break;

            case R.id.testFirst:
                Intent assess = new Intent(MenuItem.this, E2lAssessmentActivity.class);
                startActivity(assess);
                break;

            case R.id.testSecond:
                Intent test2 = new Intent(MenuItem.this, E2lSchoolAssessmentActivity.class);
                startActivity(test2);
                break;

            case R.id.testThird:
                Intent test3 = new Intent(MenuItem.this, SchoolAssignmentActivity.class);
                startActivity(test3);
                break;

            case R.id.reportFirst:
                Intent report1 = new Intent(MenuItem.this, E2lQuizReports.class);
                startActivity(report1);
                break;

            case R.id.reportSecond:
                Intent report2 = new Intent(MenuItem.this, QuizReportsActivity.class);
                startActivity(report2);
                break;

            case R.id.reportThird:
                Intent report3 = new Intent(MenuItem.this, AssignmentsReportsActivity.class);
                startActivity(report3);
                break;
        }
    }

    private void logout() {
        final AlertDialog alertDialog = new AlertDialog.Builder(MenuItem.this).create();
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setCancelable(false);

        alertDialog.setMessage("Are you want to logout?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(MenuItem.this, MobileNumber.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                new Shareprefrence(MenuItem.this).clearall();


            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
