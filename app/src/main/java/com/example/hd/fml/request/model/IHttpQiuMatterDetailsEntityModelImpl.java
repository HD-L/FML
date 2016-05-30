package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.QiuMatterDetailsEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/20.
 */
public class IHttpQiuMatterDetailsEntityModelImpl implements IHttpQiuMatterDetailsEntityModel {

    @Override
    public void getQiuMatterDetailsEntityModel(String url, final DateCallback dateCallback) {
        NetWorkUtils.initNetM2().getQiuMatterDetailsEntity(url).enqueue(new Callback<QiuMatterDetailsEntity>() {
            @Override
            public void onResponse(Response<QiuMatterDetailsEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }

}
