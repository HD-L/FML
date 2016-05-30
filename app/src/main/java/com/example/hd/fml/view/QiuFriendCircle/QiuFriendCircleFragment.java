package com.example.hd.fml.view.QiuFriendCircle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hd.fml.FMLApplication;
import com.example.hd.fml.R;
import com.example.hd.fml.adapter.InterfaceAdapter;
import com.example.hd.fml.constant.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QiuFriendCircleFragment extends BaseFragment {


    @Bind(R.id.qiu_friend_circle_tab)
    TabLayout qiuFriendCircleTab;
    @Bind(R.id.qiu_friend_circle_viewpager)
    ViewPager qiuFriendCircleViewpager;
    InterfaceAdapter interfaceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_qiu_friend_circle, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new QiuFriendCircleNextDoorFragment());
        fragmentList.add(new QiuFriendCircleHavePowderFragment());
        fragmentList.add(new QiuFriendCircleVideoFragment());
        fragmentList.add(new QiuFriendCircleTopicFragment());

        interfaceAdapter = new InterfaceAdapter(getChildFragmentManager(), fragmentList);
        qiuFriendCircleViewpager.setAdapter(interfaceAdapter);
        qiuFriendCircleTab.setupWithViewPager(qiuFriendCircleViewpager);
        qiuFriendCircleTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < qiuFriendCircleTab.getTabCount(); i++) {
            qiuFriendCircleTab.getTabAt(i).setText(FMLApplication.FriendCirletitle[i]);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
