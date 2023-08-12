package com.example.easytolearn.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetSubQuestionModel.ResponseSub;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.adapter.ChapterListAdapter;
import com.example.easytolearn.adapter.GetSubQuestionAdapter;
import com.example.easytolearn.callback.GetSubQuestionCallback;
import com.example.easytolearn.databinding.FragmentEasyQuestionBinding;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EasyQuestionFragment extends Fragment implements GetSubQuestionCallback {
    String setName,cName;
    private FragmentEasyQuestionBinding binding;
    private Context context;
    List<ResponseSub> list=new ArrayList<>();
    GetSubQuestionAdapter adapter;

    public EasyQuestionFragment(String cName,String setName) {
        this.cName=cName;
        this.setName = setName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_easy_question, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("Class",10);
        hashMap.put("Subject","Maths");
        hashMap.put("ChapterName",cName);
        hashMap.put("QuestionSetName",setName);
        Log.v("hashmap","hasmap"+hashMap);
        Service.apiGetSubQuestionSet(this,hashMap);
    }

    @Override
    public void onSuccessSub(List<ResponseSub> address) {
        list.clear();
        list.addAll(address);
        binding.recyclersetQuestion.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
      //  adapter = new GetSubQuestionAdapter(list, context);
        binding.recyclersetQuestion.setAdapter(adapter);
    }

    @Override
    public void onError(String s) {
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
