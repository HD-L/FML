package com.example.hd.fml.request.model;

import com.example.hd.fml.bean.TopicEntity;
import com.example.hd.fml.constant.DateCallback;
import com.example.hd.fml.utils.NetWorkUtils;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HD on 2016/5/26.
 */
public class IHttpTopicEntityModelImpl implements IHttpTopicEntityModel {
    @Override
    public void getTopicEntityModel(final DateCallback dateCallback) {
        NetWorkUtils.initNetCircle().getQiuFriendCircleEntity().enqueue(new Callback<TopicEntity>() {
            @Override
            public void onResponse(Response<TopicEntity> response, Retrofit retrofit) {
                dateCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                dateCallback.onError(t);
            }
        });
    }
}
