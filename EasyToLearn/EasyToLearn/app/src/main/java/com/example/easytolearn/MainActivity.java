package com.example.easytolearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.ChooseSubject;
import com.example.easytolearn.activity.MobileNumber;
import com.example.easytolearn.activity.MobileNumberSignup;
import com.example.easytolearn.activity.Registration;
import com.example.easytolearn.adapter.ImageSliderAdapter;
import com.example.easytolearn.adapter.ViewPagerAdapter;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_login,bt_signup;
    ViewPager mPager;
    ViewPagerAdapter viewPagerAdapter;

    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private Shareprefrence shareprefrence;
    private Context context;
    private Integer[] images = {R.mipmap.learn, R.mipmap.vedio, R.mipmap.mock, R.mipmap.mindmap, R.mipmap.detailedanalysis, R.mipmap.doubt};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        bt_login = findViewById(R.id.bt_login);
        bt_signup = findViewById(R.id.bt_signup);
        shareprefrence = new Shareprefrence(context);

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MobileNumberSignup.class);
                startActivity(intent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MobileNumber.class);
                startActivity(intent);
            }
        });

        if ((shareprefrence.getRememberMe())) {
            Intent intent = new Intent(MainActivity.this, ChooseSubject.class);
            startActivity(intent);
        }

        setUpImageSliderView();
    }


    public  void setUpImageSliderView(){

        mPager = findViewById(R.id.view_pager);
        sliderDotspanel = findViewById(R.id.SliderDots);
         ImageSliderAdapter viewPagerAdapter = new ImageSliderAdapter(MainActivity.this);
        mPager.setAdapter(viewPagerAdapter);
        dotscount = images.length;
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.non_active_dot);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageResource(R.drawable.non_active_dot);
                }

                dots[position].setImageResource(R.drawable.active_dot);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
