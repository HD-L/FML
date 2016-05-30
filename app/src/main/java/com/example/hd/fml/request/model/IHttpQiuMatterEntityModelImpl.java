package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/17.
 */
public class IHttpQiuMatterEntityModelImpl implements IHttpQiuMatterEntityModel {
    @Override
    public void getQiuMatterEntityModel(String url, String page, String count, final DateCallback dateCallback) {
        NetWorkUtils.initNetM2().getQiuMatterEntity(url, page, count).enqueue(new Callback<QiuMatterEntity>() {
            @Override
            public void onResponse(Response<QiuMatterEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }
}
