package com.example.mymusic_final.ui.main;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mymusic_final.Fragments.fragment_artist_list;
import com.example.mymusic_final.Fragments.fragment_music;
import com.example.mymusic_final.Fragments.fragmentalbums;
import com.example.mymusic_final.R;
import com.example.mymusic_final.View.album_details;
import com.example.mymusic_final.util.Constants;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return fragment_music.newInstance(null,null);
            }
            case 1:{
                fragmentalbums fragment=fragmentalbums.newInstance(2);
                return fragment;
            }
            case 2:{
                return fragment_artist_list.newInstance(2);
            }

        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}