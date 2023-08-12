package com.example.easytolearn.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.easytolearn.Fragments.ConceptsFragment;
import com.example.easytolearn.Fragments.EasyQuestionFragment;
import com.example.easytolearn.Fragments.QuestionsetFragment;
import com.example.easytolearn.Fragments.VideosFragment;
import com.example.easytolearn.Fragments.WorksheetFragment;

public class QuestionSetTypeAdapter extends FragmentStatePagerAdapter {

    private String[] mList = {"Easy","Medium","Hard"};
    Context context;
    String setName,cName;

    public QuestionSetTypeAdapter(String cName,String setName,FragmentManager fm) {
        super(fm);
        this.cName=cName;
        this.setName=setName;

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
                return new EasyQuestionFragment(cName,setName);
            case 1:
                return new EasyQuestionFragment(cName,setName);
            case 2:
                return new EasyQuestionFragment(cName,setName);
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

