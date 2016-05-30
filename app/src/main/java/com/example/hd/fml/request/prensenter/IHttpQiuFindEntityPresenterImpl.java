package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.QiuFindEntity;
import com.example.hd.fml.request.model.IHttpQiuFindEntityModel;
import com.example.hd.fml.request.model.IHttpQiuFindEntityModelImpl;
import com.example.hd.fml.request.view.IHttpQiuFindEntityView;

/**
 * Created by HD on 2016/5/23.
 */
public class IHttpQiuFindEntityPresenterImpl implements IHttpQiuFindEntityPresenter {
    IHttpQiuFindEntityView iHttpQiuFindEntityView;
    IHttpQiuFindEntityModel iHttpQiuFindEntityModel;

    public IHttpQiuFindEntityPresenterImpl(IHttpQiuFindEntityView iHttpQiuFindEntityView) {
        this.iHttpQiuFindEntityView = iHttpQiuFindEntityView;
        iHttpQiuFindEntityModel = new IHttpQiuFindEntityModelImpl();
    }

    @Override
    public void getQiuFindEntityPresenter() {
        iHttpQiuFindEntityModel.getQiuFindEntityEntityModel(this);
    }

    @Override
    public void onSuccess(Object o) {
        iHttpQiuFindEntityView.getQiuFindEntityView((QiuFindEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpQiuFindEntityView.getThrowableView(throwable);
    }
}
