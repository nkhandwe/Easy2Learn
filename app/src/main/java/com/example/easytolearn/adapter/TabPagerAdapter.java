package com.example.easytolearn.adapter;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.easytolearn.Fragments.ConceptsFragment;
import com.example.easytolearn.Fragments.MindMapFragment;
import com.example.easytolearn.Fragments.NCRTSolutionFragment;
import com.example.easytolearn.Fragments.QuestionsetFragment;
import com.example.easytolearn.Fragments.VideosFragment;
import com.example.easytolearn.Fragments.WorksheetFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mList = {"Concepts","Videos","Question Set","Worksheet","Mind Map","NCRT Solutions"};
    Context context;
    String name,sName;
    int position2;

    public TabPagerAdapter(String sName,String name,Integer position2,FragmentManager fm) {
        super(fm);
        this.sName=sName;
        this.name=name;
        this.position2=position2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return mList[position];
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ConceptsFragment(sName,name);
            case 1:
                return new VideosFragment(sName,name);
            case 2:
                return new QuestionsetFragment(sName,name,position2);
            case 3:
                return new WorksheetFragment();
            case 4:
                 return new MindMapFragment();
            case 5:
                return  new NCRTSolutionFragment();
            default:
                break;
        }
        return null;
    }
    @Override
    public int getCount() {
        return mList.length;
    }
}
