package com.example.easytolearn.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.easytolearn.Fragments.FragmentData;


public class TapPagerAdapterNew extends FragmentStatePagerAdapter {

    private String[] mList = {"Concepts","Videos","Question Set"};
    Context context;
    String name,sName;

    public TapPagerAdapterNew( FragmentManager fm) {
        super(fm);
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
                return new FragmentData();
            case 1:
                return new FragmentData();
            case 2:
                return new FragmentData();

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
