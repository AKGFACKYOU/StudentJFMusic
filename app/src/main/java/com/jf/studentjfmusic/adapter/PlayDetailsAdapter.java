package com.jf.studentjfmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jf.studentjfmusic.fragment.RoundFragment;

import java.util.ArrayList;

/**
 * Created by weidong on 2017/6/14.
 */

public class PlayDetailsAdapter extends FragmentPagerAdapter {
    ArrayList<RoundFragment> mRoundFragments;

    public PlayDetailsAdapter(FragmentManager fm, ArrayList<RoundFragment> mRoundFragments) {
        super(fm);
        this.mRoundFragments = mRoundFragments;
    }

    public PlayDetailsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mRoundFragments.get(position);
    }

    @Override
    public int getCount() {
        return mRoundFragments.size();
    }
}
