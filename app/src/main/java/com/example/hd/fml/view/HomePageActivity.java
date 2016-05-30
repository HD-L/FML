package com.example.hd.fml.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hd.fml.FMLApplication;
import com.example.hd.fml.R;
import com.example.hd.fml.adapter.QiuMatterAdapter;
import com.example.hd.fml.constant.BaseActivity;
import com.example.hd.fml.constant.ControlScrollViewPager;
import com.example.hd.fml.view.QiuFind.QiuFindFragment;
import com.example.hd.fml.view.QiuFriendCircle.QiuFriendCircleFragment;
import com.example.hd.fml.view.QiuMatter.QiuMatterFragment;
import com.example.hd.fml.view.QiuMe.QiuMeFragment;
import com.example.hd.fml.view.QiuNotes.QiuNotesFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomePageActivity extends BaseActivity {
    int[] imageResId = {R.drawable.qiumatter, R.drawable.qiufriendcircle, R.drawable.qiufind, R.drawable.qiunotes, R.drawable.qiume};
    QiuMatterAdapter interfaceAdapter;
    String type = "text";
    @Bind(R.id.home_title_tab)
    TabLayout homeTitleTab;
    @Bind(R.id.home_fragment_layout)
    ControlScrollViewPager homeFragmentLayout;
    @Bind(R.id.home_title_toolbar)
    Toolbar homeTitleToolbar;
    String tyep;
    @Bind(R.id.qiandao)
    RelativeLayout qiandao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        homeTitleToolbar.setNavigationIcon(R.drawable.icon);
        setToolbarTitle(FMLApplication.Hometitle[0]);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        switch (type) {
            case FMLApplication.QIUMATTERTEXTMENU:
                qiandao.setVisibility(View.GONE);
                getMenuInflater().inflate(R.menu.qiu_matter_text, menu);
                break;
            case FMLApplication.QIUMATTERVIDEOMENU:
                qiandao.setVisibility(View.GONE);
                getMenuInflater().inflate(R.menu.qiu_matter_video, menu);
                break;
            case FMLApplication.QIUFRIENDCIRLE:
                qiandao.setVisibility(View.VISIBLE);
                getMenuInflater().inflate(R.menu.qiu_friend_circle_menu, menu);
                break;
            case FMLApplication.QIUNOTES:
                qiandao.setVisibility(View.GONE);
                getMenuInflater().inflate(R.menu.qiu_notes_add, menu);
                break;
            case FMLApplication.QIUWUMENU:
                qiandao.setVisibility(View.GONE);
                break;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void setSwitchMenu(String tag) {
        switch (tag) {
            case "视频":
                type = FMLApplication.QIUMATTERVIDEOMENU;
                break;
            case "糗友":
                type = FMLApplication.QIUMATTERTEXTMENU;
                break;
            case "糗友圈":
                type = FMLApplication.QIUFRIENDCIRLE;
                break;
            case "小纸条":
                type = FMLApplication.QIUNOTES;
                break;
            default:
                type = FMLApplication.QIUWUMENU;
                break;
        }
        invalidateOptionsMenu();
    }

    public void setToolbarTitle(String s) {
        switch (s) {
            case "糗友":
                homeTitleToolbar.setTitle("糗事百科");
                break;
            case "糗友圈":
                Log.i(TAG, "setToolbarTitle: " + "@@@@@@@@@@@@@@");
                homeTitleToolbar.setTitle("糗友圈");
                break;
            case "发现":
                homeTitleToolbar.setTitle("发现");
                break;
            case "小纸条":
                homeTitleToolbar.setTitle("小纸条");
                break;
            case "我":
                homeTitleToolbar.setTitle("个人中心");
                break;
        }
        homeTitleToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(homeTitleToolbar);
    }


    private void initView() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new QiuMatterFragment());
        fragmentList.add(new QiuFriendCircleFragment());
        fragmentList.add(new QiuFindFragment());
        fragmentList.add(new QiuNotesFragment());
        fragmentList.add(new QiuMeFragment());
        interfaceAdapter = new QiuMatterAdapter(getSupportFragmentManager(), fragmentList);

        homeFragmentLayout.setAdapter(interfaceAdapter);
        homeTitleTab.setupWithViewPager(homeFragmentLayout);
        homeTitleTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < homeTitleTab.getTabCount(); i++) {
            homeTitleTab.getTabAt(i).setText(FMLApplication.Hometitle[i]).setIcon(imageResId[i]);
            homeTitleTab.getTabAt(i).setTag(FMLApplication.Hometitle[i]);

        }
        homeTitleTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homeFragmentLayout.setCurrentItem(tab.getPosition());
                setToolbarTitle((String) tab.getTag());
                setSwitchMenu((String) tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
