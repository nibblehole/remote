package io.treehouses.remote.Fragments;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private Fragment f1, f2;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm, Fragment fragment1, Fragment fragment2) {
        super(fm);
        this.f1 = fragment1;
        this.f2 = fragment2;
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return f1;
        } else if (position == 1){
            return f2;
        }
        return null;
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Overview";
            case 1:
                return "Details";
            default:
                return null;
        }
    }
}
