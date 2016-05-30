package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.CommentsDetailsEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/22.
 */
public class IHttpCommentsDetailsEntityModelImpl implements IHttpCommentsDetailsEntityModel {


    @Override
    public void getAllCommentsDetailsEntityModel(String url, String page, String count, final DateCallback dateCallback) {
        NetWorkUtils.initNetM2().getAllCommentsDetailsEntity(url, page, count).enqueue(new Callback<CommentsDetailsEntity>() {
            @Override
            public void onResponse(Response<CommentsDetailsEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }

    @Override
    public void getHotCommentsDetailsEntityModel(String url, String page, String count, final DateCallback dateCallback) {
        NetWorkUtils.initNetM2().getHotCommentsDetailsEntity(url, page, count).enqueue(new Callback<CommentsDetailsEntity>() {
            @Override
            public void onResponse(Response<CommentsDetailsEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }
}
