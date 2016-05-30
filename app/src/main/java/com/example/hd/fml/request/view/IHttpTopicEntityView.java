package com.example.hd.fml.request.view;

import com.example.hd.fml.bean.StartPageEntity;
import com.example.hd.fml.bean.TopicEntity;

/**
 * Created by HD on 2016/5/26.
 */
public interface IHttpTopicEntityView {
    void getTopicEntityView(TopicEntity entity);

    void getThrowableView(Throwable throwable);
}
