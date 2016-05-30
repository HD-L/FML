package com.example.hd.fml.request.model;

import com.example.hd.fml.constant.DateCallback;

/**
 * Created by HD on 2016/5/17.
 */
public interface IHttpQiuMatterEntityModel {
    void getQiuMatterEntityModel(String url, String page, String count, DateCallback dateCallback);
}
