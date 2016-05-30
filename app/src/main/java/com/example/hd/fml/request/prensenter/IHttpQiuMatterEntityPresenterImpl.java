package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.request.model.IHttpQiuMatterEntityModel;
import com.example.hd.fml.request.model.IHttpQiuMatterEntityModelImpl;
import com.example.hd.fml.request.view.IHttpQiuMatterView;

/**
 * Created by HD on 2016/5/17.
 */
public class IHttpQiuMatterEntityPresenterImpl implements IHttpQiuMatterEntityPresenter {
    IHttpQiuMatterView iHttpQiuMatterView;
    IHttpQiuMatterEntityModel iHttpQiuMatterEntityModel;

    public IHttpQiuMatterEntityPresenterImpl(IHttpQiuMatterView iHttpQiuMatterView) {
        this.iHttpQiuMatterView = iHttpQiuMatterView;
        iHttpQiuMatterEntityModel = new IHttpQiuMatterEntityModelImpl();
    }

    @Override
    public void getQiuMatterEntityPresenter(String url, String page, String count) {
        iHttpQiuMatterEntityModel.getQiuMatterEntityModel(url, page, count, this);
    }


    @Override
    public void onSuccess(Object o) {
        iHttpQiuMatterView.getQiuMatterEntityView((QiuMatterEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpQiuMatterView.getThrowableView(throwable);
    }

}
