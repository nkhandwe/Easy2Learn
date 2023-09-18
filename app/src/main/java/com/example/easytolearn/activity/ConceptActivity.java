package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookMarkListRModel.ResponseN;
import com.example.easytolearn.Responses.GetBookmarkList.ResponseB;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetConceptModel.Response;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ConceptAdapter;
import com.example.easytolearn.callback.GetBookmarkListCallback;
import com.example.easytolearn.callback.GetConceptCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityConceptBinding;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ConceptActivity extends AppCompatActivity implements GetConceptCallback,ConceptAdapter.OnClick1, GetBookmarkListCallback {
    ActivityConceptBinding binding;
    String name, sName;
    Shareprefrence shareprefrence;
    Dialog dialog;
    private Context context;
    private List<Response> list = new ArrayList<>();
    private List<GetBookmarkModelView.ResponseBean> listbookmark = new ArrayList<>();
    private ConceptAdapter adapter;
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_concept);
        context = this;
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position=in.getIntExtra("position",0);
        shareprefrence = new Shareprefrence(context);
        dialog=new Dialog(context);
     //   dialog.showDialog(Dialog.DIALOG_CENTERED);
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCA.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCA.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCA.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCA.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingCA.setText(""+sName+"\n Chapter-"+position+" "+name);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Class", shareprefrence.getClassName());
        hashMap.put("Subject", sName);
        hashMap.put("ChapterName", name);
        Service.apiGetConcept(this, hashMap);

    }

    @Override
    public void onSuccess(final List<Response> address) {
        list.clear();
        list.addAll(address);
        Log.v("conceptList","conceptList"+address.size());
        HashMap<String, Object> hashMapBookmark = new HashMap<>();
        final String res = name.toUpperCase();

        hashMapBookmark.put("Class", shareprefrence.getClassName());
        hashMapBookmark.put("Subject", sName);
        hashMapBookmark.put("ChapterName", res);
        hashMapBookmark.put("MobileNumber",shareprefrence.getMobile());
        hashMapBookmark.put("bookmarktype","Concept");
        Log.v("hshmap","hshmap"+hashMapBookmark);
        Service.apiGetBookmarkList(this, hashMapBookmark);
    }

    @Override
    public void onSuccessB(List<GetBookmarkModelView.ResponseBean> listbookmarkR) {
       // Toast.makeText(context, "sucess", Toast.LENGTH_SHORT).show();
        listbookmark.clear();
        listbookmark.addAll(listbookmarkR);
//        Toast.makeText(context, ""+listbookmarkR.size(), Toast.LENGTH_SHORT).show();
        for(int i =0 ; i<list.size(); i++){
            for(int j =0 ; j<listbookmark.size(); j++){
                if(listbookmark.get(j).getConceptQuestion().equalsIgnoreCase(list.get(i).getConceptQuestion())){
                    list.get(i).setBookmarktype("true");
                    Log.v("position concept ","position concept" + i);
//                } else {
//                    list.get(i).setBookmarktype("0");
                }
            }
        }
        binding.recyclerConceptA.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new ConceptAdapter(list, context,ConceptActivity.this);
        binding.recyclerConceptA.setAdapter(adapter);

    }

    @Override
    public void onErrorB(String s) {
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setBookmark(Integer position1,String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ChapterName", cName);
        hashMap.put("Class", className);
        hashMap.put("ConceptAnswer", cAnswer);
        hashMap.put("ConceptQuestion",cQuestion);
        hashMap.put("ConceptType",cType);
        hashMap.put("MobileNumber",shareprefrence.getMobile());
        hashMap.put("Subject",subject);
        hashMap.put("bookmarktype",bookmarkType);
        Log.v("parmsC","parmsC"+hashMap);
        apiBookmarkConcept(hashMap,position1);
    }

    @Override
    public void setBookmarkDelete(Integer position, String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ChapterName", cName);
        hashMap.put("Class", className);
        hashMap.put("ConceptQuestion",cQuestion);
        hashMap.put("ConceptType",cType);
        hashMap.put("MobileNumber",shareprefrence.getMobile());
        hashMap.put("Subject",subject);
        hashMap.put("bookmarktype",bookmarkType);
        Log.v("parmsC","parmsC"+hashMap);
        apiBookmarkConceptDelete(hashMap,position);
    }

    public void apiBookmarkConcept(final HashMap<String, Object> jsonObject,final Integer position1) {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().bookmarkConcept(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, retrofit2.Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();
                        if(response.isSuccessful()){
                            dialog.dismiss();
                            list.get(position1).setBookmarktype("true");
                            Toast.makeText(context, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                           // adapter.refreshData(position1);

                        }
                        Log.v("json","json"+jsonObject1.toString());


                    }
                } catch (Exception e) {
                    Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, "someting went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void apiBookmarkConceptDelete(final HashMap<String, Object> jsonObject,final Integer position1) {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().bookmarkConceptDelete(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, retrofit2.Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();
                        if(response.isSuccessful()){
                            dialog.dismiss();
                            list.get(position1).setBookmarktype("false");
                            Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                            // adapter.refreshData(position1);

                        }
                        Log.v("json","json"+jsonObject1.toString());


                    }
                } catch (Exception e) {
                    Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, "someting went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
