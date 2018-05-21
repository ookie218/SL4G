package com.example.android.sl4g;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ookie on 12/17/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm){
      super(fm);
      mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } if (position == 1) {
            return new ArtistMasterFragment();
        } if (position == 2) {
            return new MediaFragment();
        } else {
            return new ContactFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position){
        if (position == 0) {
            return mContext.getString(R.string.home_tab);
        } if (position == 1) {
            return mContext.getString(R.string.artist_tab);
        } if (position == 2) {
            return mContext.getString(R.string.media_tab);
        } else {
            return mContext.getString(R.string.contact_tab);
        }
    }
}
