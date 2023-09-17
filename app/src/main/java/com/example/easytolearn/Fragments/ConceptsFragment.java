package com.example.easytolearn.Fragments;

import android.content.Context;
import android.os.Bundle;
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
import com.example.easytolearn.Responses.GetConceptModel.Response;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ConceptAdapter;
import com.example.easytolearn.callback.GetConceptCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.FragmentConceptsBinding;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConceptsFragment extends Fragment implements GetConceptCallback,ConceptAdapter.OnClick1 {
    String name,sName;
    FragmentConceptsBinding binding;
    private Context context;
    private List<Response> list=new ArrayList<>();
    private ConceptAdapter adapter;
    private Dialog dialog;
    private Shareprefrence shareprefrence;

    public ConceptsFragment(String sName,String name) {
        this.sName=sName;
        this.name = name;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_concepts, container, false);
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
        Service.apiGetConcept(this,hashMap);
    }

    @Override
    public void onSuccess(List<Response> address) {
        dialog.dismiss();
        list.clear();
        list.addAll(address);
        binding.recyclerConcept.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
       //// adapter = new ConceptAdapter(list, context,ConceptsFragment.this);
        binding.recyclerConcept.setAdapter(adapter);

    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setBookmark(Integer position,String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType) {

    }

    @Override
    public void setBookmarkDelete(Integer position, String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType) {

    }
}
