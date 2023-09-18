package com.example.easytolearn.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.adapter.SelectStateAdapter;
import com.example.easytolearn.databinding.ActivityRegistrationBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class Registration extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, View.OnClickListener, SelectStateAdapter.OnClick1 {
    Spinner citySpinner,/*stateSpinner*/
            districtSpinner, schoolSpinner;
    ActivityRegistrationBinding binding;
    String[] schoolArray = {"", "Yes", "No"};
    String[] cityArray = {"", "C1", "C2"};
    String[] districtArray = {"", "D1", "D2"};
    String mSelectedCity = "", mSelectedState = "", mSelectedDistrict = "", mSelectedSchool = "";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private Dialog dialog1;
    private Context context;
    private ArrayList<String> arrayList;
    private SelectStateAdapter selectStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        binding.schoolNameLayout.setVisibility(View.GONE);
        context = this;
        ArrayAdapter aa = new ArrayAdapter(Registration.this, R.layout.spinner_item, schoolArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.schoolSpinner.setAdapter(aa);
        ArrayAdapter cs = new ArrayAdapter(Registration.this, R.layout.spinner_item, cityArray);
        cs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.citySpinner.setAdapter(cs);
        ArrayAdapter ds = new ArrayAdapter(Registration.this, R.layout.spinner_item, districtArray);
        ds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.districtSpinner.setAdapter(ds);
        binding.tvLogin.setPaintFlags(binding.tvLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvPrivPol.setPaintFlags(binding.tvPrivPol.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvTnc.setPaintFlags(binding.tvTnc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.stateT.setOnClickListener(this);
    }

    private boolean checkValidation() {
        if (binding.etName.getText().toString().trim().equals("")) {
            binding.etName.requestFocus();
            binding.etName.setError("Enter your name");
            return true;
        }
        if (binding.etEmail.getText().toString().trim().equals("")) {
            binding.etEmail.requestFocus();
            binding.etEmail.setError("Enter your email address");
            return true;
        }

        if (!binding.etEmail.getText().toString().trim().matches(emailPattern)) {
            binding.etEmail.requestFocus();
            binding.etEmail.setError("Invalid email address");
            return true;
        }


        if (binding.etMobile.getText().toString().trim().equals("")) {
            binding.etMobile.requestFocus();
            binding.etMobile.setError("Enter your number.");
            return true;
        }

        if (binding.etMobile.getText().toString().trim().length() != 10) {
            binding.etMobile.requestFocus();
            binding.etMobile.setError("Invalid phone number");
            return true;
        }


        if (binding.etName.getText().toString().trim().equals("")) {
            binding.etName.requestFocus();
            binding.etName.setError("Enter your name");
            return true;
        }
        if (binding.etParentsName.getText().toString().trim().equals("")) {
            binding.etParentsName.requestFocus();
            binding.etParentsName.setError("Enter this field.");
            return true;
        }
        if (binding.etAddr.getText().toString().trim().equals("")) {
            binding.etAddr.requestFocus();
            binding.etAddr.setError("Enter this field.");
            return true;
        }

        if (mSelectedSchool.equalsIgnoreCase("yes") && binding.etSchoolName.getText().toString().trim().equals("")) {
            binding.etSchoolName.requestFocus();
            binding.etSchoolName.setError("Enter this field");
            return true;
        }


        if (mSelectedSchool.equals("")) {
            binding.schoolSpinner.requestFocus();
            return true;
        }

        if (mSelectedCity.equals("")) {
            binding.citySpinner.requestFocus();
            return true;
        }

        if (mSelectedState.equals("")) {
            // stateSpinner.requestFocus();
            // Toast.makeText(this, "Please select state.", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (mSelectedDistrict.equals("")) {
            binding.districtSpinner.requestFocus();
            return true;
        }
        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (adapterView.getId() == schoolSpinner.getId()) {
            mSelectedSchool = schoolArray[position];
            if (mSelectedSchool.equalsIgnoreCase("Yes"))
                binding.schoolNameLayout.setVisibility(View.VISIBLE);
            else
                binding.schoolNameLayout.setVisibility(View.GONE);
        } else if (adapterView.getId() == binding.citySpinner.getId()) {
            mSelectedCity = cityArray[position];
        } else if (adapterView.getId() == districtSpinner.getId()) {
            mSelectedDistrict = districtArray[position];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mSelectedSchool = "";
        mSelectedCity = "";
        mSelectedDistrict = "";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                Intent intent = new Intent(Registration.this, MobileNumber.class);
                startActivity(intent);
                break;
            case R.id.tvPrivPol:
                Intent intent1 = new Intent(Registration.this, PrivacyPolicy.class);
                startActivity(intent1);
                break;
            case R.id.bt_register:
               /* Intent intent2 = new Intent(Registration.this, ChooseClass.class);
                startActivity(intent2);
*/                break;
            case R.id.stateT:
                openDialog();
                break;

        }
    }

    private void openDialog() {
        dialog1 = new Dialog(context);
        dialog1.setContentView(R.layout.select_state);
        RecyclerView recyclerState = dialog1.findViewById(R.id.recyclerState);
        arrayList = new ArrayList<>();
        arrayList.add("Andhra Pradesh");
        arrayList.add("Arunachal Pradesh");
        arrayList.add("Assam");
        arrayList.add("Bihar");
        arrayList.add("Chhattisgarh");
        arrayList.add("Goa");
        arrayList.add("Gujarat");
        arrayList.add("Haryana");
        arrayList.add("Himachal");
        arrayList.add("Jharkhand");
        arrayList.add("Karnataka");
        arrayList.add("Kerala");
        arrayList.add("Madhya");
        arrayList.add("Maharashtra");
        arrayList.add("Manipur");
        arrayList.add("Meghalaya");
        arrayList.add("Mizoram");
        arrayList.add("Nagaland");
        arrayList.add("Odisha");
        arrayList.add("Punjab");
        arrayList.add("Rajasthan");
        arrayList.add("Sikkim");
        arrayList.add("Tamil Nadu");
        arrayList.add("Telangana");
        arrayList.add("Tripura");
        arrayList.add("Uttar Pradesh");
        arrayList.add("Uttarakhand");
        arrayList.add("West Bengal");
        recyclerState.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        selectStateAdapter = new SelectStateAdapter(arrayList, context, Registration.this);
        recyclerState.setAdapter(selectStateAdapter);
        dialog1.show();
    }

    @Override
    public void setState(int position, String name) {
        binding.statText.setText("" + name);
        dialog1.dismiss();
    }
    private void register(HashMap<String,Object> hashMap){

    }
}
