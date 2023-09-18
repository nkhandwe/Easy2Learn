package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetDashboardData.Response;
import com.example.easytolearn.Responses.getPaidClasses.ClassPaid;
import com.example.easytolearn.Responses.getPaidClasses.GetPaidClassesModel;
import com.example.easytolearn.Responses.getPaidClasses.PaidClassesResponse;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.DashBoardAdapter;
import com.example.easytolearn.callback.GetDashboardData;
import com.example.easytolearn.databinding.ActivityChooseSubjectBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ChooseSubject extends AppCompatActivity implements View.OnClickListener, GetDashboardData {
    private ActivityChooseSubjectBinding binding;
    private Context context;
    private Shareprefrence shareprefrence;
    List<Response> dashList = new ArrayList<>();
    private DashBoardAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_subject);
        context = this;
        shareprefrence = new Shareprefrence(ChooseSubject.this);
        binding.tvGreeting.setText("Good Morning " + shareprefrence.getUserName());
        binding.menulearn.setOnClickListener(this);
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        Log.v("id", "id" + shareprefrence.getClassName());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Class", shareprefrence.getClassName());
        Service.apiDashboard(this, hashMap);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
//                Intent menuLIntent = new Intent(ChooseSubject.this, ChooseSubject.class);
//                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(ChooseSubject.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(ChooseSubject.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(ChooseSubject.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(ChooseSubject.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public void onSuccess(com.example.easytolearn.Responses.GetDashboardData.GetDashboardData Daaddress) {
        if (Daaddress.getSuccess().equals(true)) {
            if (Daaddress.getResponse().size() > 0) {
                dashList.clear();
                dashList.addAll(Daaddress.getResponse());
                getPaidClasses();
                binding.recyclerDash.setLayoutManager(new GridLayoutManager(context, 2));
                adapter = new DashBoardAdapter(dashList, context);
                binding.recyclerDash.setAdapter(adapter);

            }
        }
    }

    @Override
    public void onError(String s) {
//        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }

    private void getPaidClasses(){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("MobileNumber", Long.parseLong(shareprefrence.getMobile()));
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getPaidClasses(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, retrofit2.Response<JsonObject> response) {
                Log.v("response","response"+response);
                try {

                    //     Toast.makeText(context, "success1", Toast.LENGTH_SHORT).show();
                    shareprefrence.setPaidClass("0");
                    if (response != null && response.body() != null) {
                        JsonObject jsonObject = response.body();
                        GetPaidClassesModel getPaidClassesModel = new Gson().fromJson(jsonObject.toString(), GetPaidClassesModel.class);
                        ArrayList<PaidClassesResponse> paidClassList = new ArrayList<>();
                        ArrayList<ClassPaid> classList = new ArrayList<>();
                        paidClassList.addAll(getPaidClassesModel.getResponse());
                        for(int i=0; i < paidClassList.size(); i++){
                            classList.add(paidClassList.get(i).getClasses().get(0));
                            if(shareprefrence.getClass().toString().equalsIgnoreCase(paidClassList.get(i).getClasses().get(0).getClass_().toString())){
                                shareprefrence.setPaidClass("1");
                            }
                        }
                        // apiGetCompletedQuestion(hashMap,i);
                    } else {
                        shareprefrence.setPaidClass("0");
                    }
                } catch (Exception e) {
//                    Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }
}
