package com.example.mani.shell;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class HomePageFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mFragmentArrayList;

    public HomePageFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.mFragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0: return mFragmentArrayList.get(0);
            case 1: return mFragmentArrayList.get(1);
            case 2: return mFragmentArrayList.get(2);

        }

        return null;
    }
    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){

            case 0: return "Olx";
            case 1: return "Oppo";
            case 2: return "Feeds";

        }

        return null;
    }
}
