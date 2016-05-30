package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.StartPageEntity;
import com.example.hd.fml.request.model.IHttpStartPageModel;
import com.example.hd.fml.request.model.IHttpStartPageModelImpl;
import com.example.hd.fml.request.view.IHttpStartPageView;

/**
 * Created by HD on 2016/5/16.
 */
public class IHttpStartPageEntityPresenterImpl implements IHttpStartPageEntityPresenter {
    IHttpStartPageModel iHttpStartPageModel;
    IHttpStartPageView iHttpStartPageView;

    public IHttpStartPageEntityPresenterImpl(IHttpStartPageView iHttpStartPageView) {
        this.iHttpStartPageView = iHttpStartPageView;
        iHttpStartPageModel = new IHttpStartPageModelImpl();
    }

    @Override
    public void getStartPageEntityPresenter(String url) {
        iHttpStartPageModel.getStartPageEntityModel(url, this);
    }

    @Override
    public void onSuccess(Object o) {
        iHttpStartPageView.getStartPageEntityView((StartPageEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpStartPageView.getThrowableView(throwable);
    }

}
