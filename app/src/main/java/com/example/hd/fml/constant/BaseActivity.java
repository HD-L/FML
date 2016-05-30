package com.example.hd.fml.constant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HD on 2016/5/16.
 */
public class BaseActivity extends AppCompatActivity {
    public Context mContext;
    public BaseActivity mActivity;
    public final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
    }
}