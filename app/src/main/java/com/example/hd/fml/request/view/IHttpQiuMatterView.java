package com.example.hd.fml.request.view;


import com.example.hd.fml.bean.QiuMatterEntity;

/**
 * Created by HD on 2016/5/17.
 */
public interface IHttpQiuMatterView {
    void getQiuMatterEntityView(QiuMatterEntity entity);

    void getThrowableView(Throwable throwable);
}
