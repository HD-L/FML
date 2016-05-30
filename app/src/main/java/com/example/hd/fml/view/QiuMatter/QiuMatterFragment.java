package com.example.hd.fml.view.QiuMatter;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hd.fml.FMLApplication;
import com.example.hd.fml.R;
import com.example.hd.fml.adapter.QiuMatterAdapter;
import com.example.hd.fml.constant.BaseFragment;
import com.example.hd.fml.view.HomePageActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class QiuMatterFragment extends BaseFragment {

    QiuMatterAdapter interfaceAdapter;

    @Bind(R.id.qiu_matter_tab)
    TabLayout qiuMatterTab;
    @Bind(R.id.qiu_matter_viewpager)
    ViewPager qiuMatterViewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_qiu_matter, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<Fragment> fragmentList = new ArrayList<>();
        TemplateFragment templateFragment;
        for (int i = 0; i < FMLApplication.Mattertitle.length; i++) {
            templateFragment = new TemplateFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", FMLApplication.LayoutType[i]);
            templateFragment.setArguments(bundle);
            fragmentList.add(templateFragment);
        }
        qiuMatterViewpager.setOffscreenPageLimit(4);
        interfaceAdapter = new QiuMatterAdapter(this.getChildFragmentManager(), fragmentList);
        qiuMatterViewpager.setAdapter(interfaceAdapter);
        qiuMatterTab.setupWithViewPager(qiuMatterViewpager);
        qiuMatterTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < qiuMatterTab.getTabCount(); i++) {
            qiuMatterTab.getTabAt(i).setText(FMLApplication.Mattertitle[i]);
            qiuMatterTab.getTabAt(i).setTag(FMLApplication.MatterMenu[i]);
        }
        qiuMatterTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                qiuMatterViewpager.setCurrentItem(tab.getPosition());
                ((HomePageActivity) getActivity()).setSwitchMenu((String) tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
