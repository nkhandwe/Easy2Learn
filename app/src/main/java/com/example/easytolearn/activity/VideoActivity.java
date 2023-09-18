package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookMarkListVideoView;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetVideoModel.ResponseVideo;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ConceptAdapter;
import com.example.easytolearn.adapter.GetVideoAdapter;
import com.example.easytolearn.callback.GetBookmarkCallbackV;
import com.example.easytolearn.callback.GetBookmarkListCallback;
import com.example.easytolearn.callback.GetVideoCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityVideoBinding;
import com.example.easytolearn.databinding.FragmentVideosBinding;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class VideoActivity extends AppCompatActivity implements GetVideoCallback,GetVideoAdapter.OnClick1, GetBookmarkCallbackV {
    String name,sName;
    List<ResponseVideo> list=new ArrayList<>();
    private GetVideoAdapter adapter;
    private Context context;
    private Dialog dialog;
    private Shareprefrence shareprefrence;
    ActivityVideoBinding binding;
    int position=0;
    private List<GetBookMarkListVideoView.ResponseBean> listbookmark = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_video);
        context = this;
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position=in.getIntExtra("position",0);
        dialog=new Dialog(context);
        shareprefrence=new Shareprefrence(context);
        dialog=new Dialog(context);
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCV.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCV.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCV.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCV.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingCV.setText(""+sName+"\n Chapter-"+position+" "+name);

        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("Class",shareprefrence.getClassName());
        hashMap.put("Subject",sName);
        hashMap.put("ChapterName",name);
        Log.v("name","name"+name);
        Log.v("hashmap","hasmap"+hashMap);
        Service.apiGetVideo(this,hashMap);

    }

    @Override
    public void onSuccess(List<ResponseVideo> address) {
        dialog.dismiss();
        list.clear();
        list.addAll(address);
        HashMap<String, Object> hashMapBookmark = new HashMap<>();
        final String res = name.toUpperCase();

        hashMapBookmark.put("Class", shareprefrence.getClassName());
        hashMapBookmark.put("Subject", sName);
        hashMapBookmark.put("ChapterName", res);
        hashMapBookmark.put("MobileNumber",shareprefrence.getMobile());
        hashMapBookmark.put("bookmarktype","Videos");
        Log.v("hshmap","hshmap"+hashMapBookmark);
        Service.apiGetBookmarkListV(this, hashMapBookmark);
      /*  binding.recyclerVedioA.setLayoutManager(new GridLayoutManager(context,2));
        adapter = new GetVideoAdapter(list, context,VideoActivity.this);
        binding.recyclerVedioA.setAdapter(adapter);*/
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setBookmark(Integer position1, String cName, Integer className, String vImage, String vName, String vUrl, String subject, String bookmarkType) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ChapterName", cName);
        hashMap.put("Class", className);
        hashMap.put("VideoImage", vImage);
        hashMap.put("VideoName",vName);
        hashMap.put("VideoUrl",vUrl);
        hashMap.put("MobileNumber",shareprefrence.getMobile());
        hashMap.put("Subject",subject);
        hashMap.put("bookmarktype",bookmarkType);
        Log.v("parmsC","parmsC"+hashMap);
        apiBookmarkConcept(hashMap,position1);

    }

    @Override
    public void setBookmarkDelete(Integer position, String cName, Integer className, String vImage, String vName, String vUrl, String subject, String bookmarkType) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ChapterName", cName);
        hashMap.put("Class", className);
        hashMap.put("VideoName",vName);
        hashMap.put("VideoUrl",vUrl);
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
                            list.get(position1).setBookmarktype("1");
                            Toast.makeText(context, "Bookmarked Successfully", Toast.LENGTH_SHORT).show();
                           // adapter.notifyDataSetChanged();
                            //adapter.refreshData(position1);
                              adapter.notifyItemChanged(position1);

                        }
                        Log.v("json","json"+jsonObject1.toString());


                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

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
                            list.get(position1).setBookmarktype("0");
                            Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                            // adapter.notifyDataSetChanged();
                            //adapter.refreshData(position1);
                            adapter.notifyItemChanged(position1);

                        }
                        Log.v("json","json"+jsonObject1.toString());


                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }



    @Override
    public void onSuccessB(List<GetBookMarkListVideoView.ResponseBean> listbookmarkR) {
        listbookmark.clear();
        listbookmark.addAll(listbookmarkR);
        for(int i =0 ; i<list.size(); i++){
            for(int j =0 ; j<listbookmark.size(); j++){
                if(list.get(i).getVideoImage().equalsIgnoreCase(listbookmark.get(j).getVideoImage())){
                    list.get(i).setBookmarktype("1");
                    Log.v("position set","position set"+i);
                } /*else {
                    list.get(i).setBookmarktype("0");
                }*/
            }
        }
        binding.recyclerVedioA.setLayoutManager(new GridLayoutManager(context,2));
        adapter = new GetVideoAdapter(list, context,VideoActivity.this);
        binding.recyclerVedioA.setAdapter(adapter);
    }

    @Override
    public void onErrorB(String s) {
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
