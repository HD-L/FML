package com.example.hd.fml.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hd.fml.R;
import com.example.hd.fml.bean.StartPageEntity;
import com.example.hd.fml.constant.BaseActivity;
import com.example.hd.fml.view.HomePageActivity;
import com.example.hd.fml.request.prensenter.IHttpStartPageEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpStartPageEntityPresenterImpl;
import com.example.hd.fml.request.view.IHttpStartPageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IHttpStartPageView {
    IHttpStartPageEntityPresenter iHttpStartPageEntityPresenter;
    @Bind(R.id.skip_OnClick)
    TextView skipOnClick;
    @Bind(R.id.advertisement_Img)
    ImageView advertisementImg;
    int i = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iHttpStartPageEntityPresenter = new IHttpStartPageEntityPresenterImpl(this);
        iHttpStartPageEntityPresenter.getStartPageEntityPresenter("ad");

        Animation animation = new AlphaAnimation(1.0f, 1.0f);
        animation.setDuration(1000);
        skipOnClick.setAnimation(animation);
        animation.setRepeatCount(5);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                SkipOnClick();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                skipOnClick.setText(i-- + "|跳过");
            }
        });
        animation.start();
        skipOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkipOnClick();
            }
        });
    }

    @Override
    public void getStartPageEntityView(StartPageEntity entity) {
        Glide.with(mContext).load(entity.getItems().get(0).getPic_url()).into(advertisementImg);
    }

    @Override
    public void getThrowableView(Throwable throwable) {
        SkipOnClick();
    }


    public void SkipOnClick() {
        Intent intent = new Intent();
        intent.setClass(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}
