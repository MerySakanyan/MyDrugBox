package com.example.mery.drugbox;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mery on 4/17/2018.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private  ArrayList<DrugList> list;
    public FragmentAdapter(FragmentManager fm, ArrayList<DrugList> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DrugFragment fragment=new DrugFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("key", list);
                fragment.setArguments(bundle);
                return fragment;
            case 1:
              return new PharmacyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
