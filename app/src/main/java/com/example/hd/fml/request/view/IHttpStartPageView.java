package com.example.hd.fml.request.view;

import com.example.hd.fml.bean.StartPageEntity;

/**
 * Created by HD on 2016/5/16.
 */
public interface IHttpStartPageView {
    void getStartPageEntityView(StartPageEntity entity);

    void getThrowableView(Throwable throwable);
}
