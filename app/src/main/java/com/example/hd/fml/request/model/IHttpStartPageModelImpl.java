package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.StartPageEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/16.
 */
public class IHttpStartPageModelImpl implements IHttpStartPageModel {
    @Override
    public void getStartPageEntityModel(String url, final DateCallback dateCallback) {
        NetWorkUtils.initNetM2().getStartPageEntity(url).enqueue(new Callback<StartPageEntity>() {
            @Override
            public void onResponse(Response<StartPageEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }
}
