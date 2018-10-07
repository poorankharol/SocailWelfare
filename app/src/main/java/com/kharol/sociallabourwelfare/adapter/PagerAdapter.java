package com.kharol.sociallabourwelfare.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kharol.sociallabourwelfare.fragment.SkilledFragment;
import com.kharol.sociallabourwelfare.fragment.UnSkilledFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SkilledFragment tab1 = new SkilledFragment();
                return tab1;
            case 1:
                UnSkilledFragment tab2 = new UnSkilledFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}