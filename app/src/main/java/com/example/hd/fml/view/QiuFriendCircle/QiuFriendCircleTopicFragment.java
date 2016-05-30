package com.example.hd.fml.view.QiuFriendCircle;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hd.fml.R;
import com.example.hd.fml.bean.TopicEntity;
import com.example.hd.fml.constant.BaseFragment;
import com.example.hd.fml.request.prensenter.IHttpTopicEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpTopicEntityViewImpl;
import com.example.hd.fml.request.view.IHttpTopicEntityView;

public class QiuFriendCircleTopicFragment extends BaseFragment implements IHttpTopicEntityView {
    IHttpTopicEntityPresenter iHttpTopicEntityPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_qiu_friend_circle_topic, container, false);
        iHttpTopicEntityPresenter = new IHttpTopicEntityViewImpl(this);
        iHttpTopicEntityPresenter.getTopicEntityPresenter();
        return view;
    }

    @Override
    public void getTopicEntityView(TopicEntity entity) {
        Log.i(TAG, "getTopicEntityView: "+entity.getData());
    }

    @Override
    public void getThrowableView(Throwable throwable) {

    }
}
