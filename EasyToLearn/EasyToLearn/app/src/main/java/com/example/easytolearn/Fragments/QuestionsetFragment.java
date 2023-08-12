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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetQuestionSetModel.ResponseQuestionSet;
import com.example.easytolearn.Responses.GetSubQuestionModel.ResponseSub;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.GetQuestionSetAdapter;
import com.example.easytolearn.adapter.GetVideoAdapter;
import com.example.easytolearn.callback.GetQuestionSet;
import com.example.easytolearn.callback.GetSubQuestionCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.FragmentQuestionsetBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionsetFragment extends Fragment implements GetQuestionSet {
    String name,sName;
    FragmentQuestionsetBinding binding;
    private Context context;
    private List<ResponseQuestionSet> list=new ArrayList<>();
    GetQuestionSetAdapter adapter;
    private Dialog dialog;
    int position=0;
    Shareprefrence shareprefrence;
    public QuestionsetFragment(String sName,String name,Integer position) {
        this.sName=sName;
        this.name = name;
        this.position=position;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_questionset, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        dialog=new Dialog(context);
        shareprefrence=new Shareprefrence(context);
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("Class",shareprefrence.getClassName());
        hashMap.put("Subject",sName);
        hashMap.put("ChapterName",name);
        Log.v("name","name"+name);
        Log.v("hashmap","hasmap"+hashMap);
        Service.apiGetQuestionSet(this,hashMap);
    }

    @Override
    public void onSuccess(List<ResponseQuestionSet> address) {
        dialog.dismiss();
        list.clear();
        list.addAll(address);
        binding.recyclerQuestion.setLayoutManager(new GridLayoutManager(context, 2));
       // adapter = new GetQuestionSetAdapter(position,list, context);
        binding.recyclerQuestion.setAdapter(adapter);
    }


    @Override
    public void onError(String s) {
        dialog.dismiss();
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
    }
}
