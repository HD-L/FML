package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.TopicEntity;
import com.example.hd.fml.request.model.IHttpTopicEntityModel;
import com.example.hd.fml.request.model.IHttpTopicEntityModelImpl;
import com.example.hd.fml.request.view.IHttpTopicEntityView;

/**
 * Created by HD on 2016/5/26.
 */
public class IHttpTopicEntityViewImpl implements IHttpTopicEntityPresenter {
    IHttpTopicEntityModel iHttpTopicEntityModel;
    IHttpTopicEntityView iHttpTopicEntityView;

    public IHttpTopicEntityViewImpl(IHttpTopicEntityView iHttpTopicEntityView) {
        this.iHttpTopicEntityView = iHttpTopicEntityView;
        iHttpTopicEntityModel = new IHttpTopicEntityModelImpl();
    }

    @Override
    public void getTopicEntityPresenter() {
        iHttpTopicEntityModel.getTopicEntityModel(this);
    }

    @Override
    public void onSuccess(Object o) {
        iHttpTopicEntityView.getTopicEntityView((TopicEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpTopicEntityView.getThrowableView(throwable);
    }
}
