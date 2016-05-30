package com.example.hd.fml.utils;

import com.example.hd.fml.constant.IConstantURL;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/16.
 */
public class NetWorkUtils {
    private static Retrofit retrofit;
    private static IConstantURL iConstantURL;

    public static IConstantURL initNetM2() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iConstantURL = retrofit.create(IConstantURL.class);
        return iConstantURL;
    }
    public static IConstantURL initNetCircle() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://circle.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iConstantURL = retrofit.create(IConstantURL.class);
        return iConstantURL;
    }
}
