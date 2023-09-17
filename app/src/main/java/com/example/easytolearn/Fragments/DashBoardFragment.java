package com.example.easytolearn.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easytolearn.R;
import com.example.easytolearn.activity.ChapterList;
import com.example.easytolearn.activity.ChooseSubject;
import com.example.easytolearn.databinding.FragmentDashBoardBinding;


public class DashBoardFragment extends Fragment implements View.OnClickListener{
   FragmentDashBoardBinding binding;
   private Context context;


    public DashBoardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dash_board, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        binding.mathsLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       

    }

}
