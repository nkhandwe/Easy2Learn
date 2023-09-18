package com.example.easytolearn.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetVideoModel.GetVideoRModel;
import com.example.easytolearn.Responses.GetVideoModel.ResponseVideo;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ConceptAdapter;
import com.example.easytolearn.adapter.GetVideoAdapter;
import com.example.easytolearn.callback.GetVideoCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.FragmentConceptsBinding;
import com.example.easytolearn.databinding.FragmentVideosBinding;
import com.facebook.share.Share;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VideosFragment extends Fragment implements GetVideoCallback {
String name,sName;
FragmentVideosBinding binding;
List<ResponseVideo> list=new ArrayList<>();
private GetVideoAdapter adapter;
private Context context;
private Dialog dialog;
private Shareprefrence shareprefrence;
    public VideosFragment(String sName,String name) {
        this.sName=sName;
        this.name=name;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_videos, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        dialog=new Dialog(context);
        shareprefrence=new Shareprefrence(context);
        dialog.showDialog(Dialog.DIALOG_CENTERED);
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
        binding.recyclerVedio.setLayoutManager(new GridLayoutManager(context,2));
        //adapter = new GetVideoAdapter(list, context);
        //binding.recyclerVedio.setAdapter(adapter);
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
