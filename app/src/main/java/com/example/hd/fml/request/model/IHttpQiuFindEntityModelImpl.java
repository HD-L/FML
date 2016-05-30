package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.QiuFindEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/23.
 */
public class IHttpQiuFindEntityModelImpl implements IHttpQiuFindEntityModel {
    @Override
    public void getQiuFindEntityEntityModel(final DateCallback dateCallback) {
        NetWorkUtils.initNetCircle().getQiuFindEntity().enqueue(new Callback<QiuFindEntity>() {
            @Override
            public void onResponse(Response<QiuFindEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }
}
