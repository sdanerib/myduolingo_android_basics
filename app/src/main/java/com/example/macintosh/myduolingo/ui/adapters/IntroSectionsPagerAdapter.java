package com.example.macintosh.myduolingo.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.macintosh.myduolingo.ui.fragments.IntroSectionAFragment;
import com.example.macintosh.myduolingo.ui.fragments.IntroSectionBFragment;
import com.example.macintosh.myduolingo.ui.fragments.IntroSectionCFragment;

/**
 * Created by macintosh on 2/4/18.
 */

public class IntroSectionsPagerAdapter extends FragmentPagerAdapter {

    public IntroSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.d("MyDuolingo", "Seccion A");
                return new IntroSectionAFragment();
            case 1:
                Log.d("MyDuolingo", "Seccion B");
                return new IntroSectionBFragment();
            case 2:
                Log.d("MyDuolingo", "Seccion C");
                return new IntroSectionCFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
