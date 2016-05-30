package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.QiuMatterDetailsEntity;
import com.example.hd.fml.request.model.IHttpQiuMatterDetailsEntityModel;
import com.example.hd.fml.request.model.IHttpQiuMatterDetailsEntityModelImpl;
import com.example.hd.fml.request.view.IHttpQiuMatterDetailsView;

/**
 * Created by HD on 2016/5/20.
 */
public class IHttpQiuMatterDetailsEntityPresenterImpl implements IHttpQiuMatterDetailsEntityPresenter {
    IHttpQiuMatterDetailsEntityModel iHttpQiuMatterDetailsEntityModel;
    IHttpQiuMatterDetailsView iHttpQiuMatterDetailsView;

    public IHttpQiuMatterDetailsEntityPresenterImpl(IHttpQiuMatterDetailsView iHttpQiuMatterDetailsView) {
        this.iHttpQiuMatterDetailsView = iHttpQiuMatterDetailsView;
        iHttpQiuMatterDetailsEntityModel = new IHttpQiuMatterDetailsEntityModelImpl();
    }

    @Override
    public void getQiuMatterDetailsEntityPresenter(String url) {
        iHttpQiuMatterDetailsEntityModel.getQiuMatterDetailsEntityModel(url, this);
    }

    @Override
    public void onSuccess(Object o) {
        iHttpQiuMatterDetailsView.getQiuMatterDetailsEntityView((QiuMatterDetailsEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpQiuMatterDetailsView.getThrowableView(throwable);
    }
}
