package com.example.hd.fml.request.model;

import com.example.hd.fml.constant.DateCallback;

/**
 * Created by HD on 2016/5/22.
 */
public interface IHttpCommentsDetailsEntityModel {
    void getAllCommentsDetailsEntityModel(String url, String page, String count, DateCallback dateCallback);

    void getHotCommentsDetailsEntityModel(String url, String page, String count, DateCallback dateCallback);

}
