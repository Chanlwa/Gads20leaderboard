package com.njala.gads20leaderboard.adapters;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.njala.gads20leaderboard.ui.main.IqLeadersFragment;
import com.njala.gads20leaderboard.ui.main.LearningLeadersFragment;


public class ViewPagerAdapter extends FragmentStateAdapter {


    private final Context mContext;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Context context) {
        super(fragmentActivity);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new LearningLeadersFragment();
        } else {
            return new IqLeadersFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
