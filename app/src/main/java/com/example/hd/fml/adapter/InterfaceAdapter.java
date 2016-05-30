package com.example.hd.fml.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by HD on 2016/5/17.
 */
public class InterfaceAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;
    FragmentManager commit;

    public InterfaceAdapter(FragmentManager fm, List<Fragment> list_fragment) {
        super(fm);
        commit = fm;
        this.list_fragment = list_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.commit.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = list_fragment.get(position);
        commit.beginTransaction().hide(fragment).commit();
    }
}