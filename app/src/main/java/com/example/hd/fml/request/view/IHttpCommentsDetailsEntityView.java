package com.example.hd.fml.request.view;

import com.example.hd.fml.bean.CommentsDetailsEntity;

/**
 * Created by HD on 2016/5/22.
 */
public interface IHttpCommentsDetailsEntityView {
    void getCommentsDetailsEntity(CommentsDetailsEntity commentsDetailsEntity);
    void getThrowableView(Throwable throwable);
}
