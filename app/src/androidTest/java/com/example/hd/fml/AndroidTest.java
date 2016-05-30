package com.example.hd.fml;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/18.
 */
public class AndroidTest extends AndroidTestCase {
    public void testModel() {
        NetWorkUtils.initNetM2().getQiuMatterEntity("text").enqueue(new Callback<QiuMatterEntity>() {
            @Override
            public void onResponse(Response<QiuMatterEntity> response, Retrofit retrofit) {
                Log.i("lhd", "onResponse: "+response.body().getCount());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
