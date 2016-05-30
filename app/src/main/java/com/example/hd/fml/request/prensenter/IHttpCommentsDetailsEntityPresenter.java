package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.constant.DateCallback;

/**
 * Created by HD on 2016/5/22.
 */
public interface IHttpCommentsDetailsEntityPresenter extends DateCallback {
    void getSwtichCommentsDetailsEntityPresenter(String type,String url, String page, String count);
}
