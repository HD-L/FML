package com.example.hd.fml.request.view;

import com.example.hd.fml.bean.QiuMatterDetailsEntity;

/**
 * Created by HD on 2016/5/20.
 */
public interface IHttpQiuMatterDetailsView {
    void getQiuMatterDetailsEntityView(QiuMatterDetailsEntity qiuMatterDetailsEntity);
    void getThrowableView(Throwable throwable);
}
