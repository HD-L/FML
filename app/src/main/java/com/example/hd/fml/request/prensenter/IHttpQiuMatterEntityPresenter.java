package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.constant.DateCallback;

/**
 * Created by HD on 2016/5/17.
 */
public interface IHttpQiuMatterEntityPresenter  extends DateCallback {
    void getQiuMatterEntityPresenter(String  url,String page, String count);
}
