package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.databinding.ActivityChooseClassBinding;

public class ChooseClass extends AppCompatActivity implements View.OnClickListener {
    private ActivityChooseClassBinding binding;
    private Shareprefrence shareprefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_class);
        shareprefrence=new Shareprefrence(ChooseClass.this);
        binding.btFirst.setOnClickListener(this);
        binding.btSecond.setOnClickListener(this);
        binding.btThird.setOnClickListener(this);
        binding.btFour.setOnClickListener(this);
        binding.btFive.setOnClickListener(this);
        binding.btSix.setOnClickListener(this);
        binding.btSeven.setOnClickListener(this);
        binding.btEight.setOnClickListener(this);
        binding.btNine.setOnClickListener(this);
        binding.btTen.setOnClickListener(this);
        binding.btEleven.setOnClickListener(this);
        binding.btTwelve.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_first:
                Intent intent1 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(1);
                startActivity(intent1);
                break;
            case R.id.bt_second:
                Intent intent2 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(2);
                startActivity(intent2);
                break;
            case R.id.bt_third:
                Intent intent3 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(3);
                startActivity(intent3);
                break;
            case R.id.bt_four:
                Intent intent4 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(4);
                startActivity(intent4);
                break;
            case R.id.bt_five:
                Intent intent5 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(5);
                startActivity(intent5);
                break;
            case R.id.bt_six:
                Intent intent6 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(6);
                startActivity(intent6);
                break;
            case R.id.bt_seven:
                Intent intent7 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(7);
                startActivity(intent7);
                break;
            case R.id.bt_eight:
                Intent intent8 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(8);
                startActivity(intent8);
            case R.id.bt_nine:
                Intent intent9 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(9);
                startActivity(intent9);
            case R.id.bt_ten:
                Intent intent10 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(10);
                startActivity(intent10);
                break;
            case R.id.bt_eleven:
                Intent intent11 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(11);

                startActivity(intent11);
                break;
            case R.id.bt_twelve:
                Intent intent12 = new Intent(ChooseClass.this, SelectBoard.class);
                shareprefrence.setClassName(12);
                startActivity(intent12);
                break;

        }
    }
}
