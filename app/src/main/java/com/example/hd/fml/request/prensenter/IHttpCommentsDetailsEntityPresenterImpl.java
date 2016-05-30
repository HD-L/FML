package com.example.hd.fml.request.prensenter;

import com.example.hd.fml.bean.CommentsDetailsEntity;
import com.example.hd.fml.request.model.IHttpCommentsDetailsEntityModel;
import com.example.hd.fml.request.model.IHttpCommentsDetailsEntityModelImpl;
import com.example.hd.fml.request.view.IHttpCommentsDetailsEntityView;

/**
 * Created by HD on 2016/5/22.
 */
public class IHttpCommentsDetailsEntityPresenterImpl implements IHttpCommentsDetailsEntityPresenter {
    IHttpCommentsDetailsEntityModel iHttpCommentsDetailsEntityModel;
    IHttpCommentsDetailsEntityView iHttpCommentsDetailsEntityViewl;

    public IHttpCommentsDetailsEntityPresenterImpl(IHttpCommentsDetailsEntityView iHttpCommentsDetailsEntityViewl) {
        this.iHttpCommentsDetailsEntityViewl = iHttpCommentsDetailsEntityViewl;
        iHttpCommentsDetailsEntityModel = new IHttpCommentsDetailsEntityModelImpl();
    }

    @Override
    public void getSwtichCommentsDetailsEntityPresenter(String type, String url, String page, String count) {
        if (type.equals("all")) {
            iHttpCommentsDetailsEntityModel.getAllCommentsDetailsEntityModel(url, page, count, this);
        } else {
            iHttpCommentsDetailsEntityModel.getHotCommentsDetailsEntityModel(url, page, count, this);
        }
    }

    @Override
    public void onSuccess(Object o) {
        iHttpCommentsDetailsEntityViewl.getCommentsDetailsEntity((CommentsDetailsEntity) o);
    }

    @Override
    public void onError(Throwable throwable) {
        iHttpCommentsDetailsEntityViewl.getThrowableView(throwable);
    }
}
