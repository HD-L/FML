package com.example.hd.fml.view.QiuFind;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hd.fml.R;
import com.example.hd.fml.adapter.QiuFindAdapter;
import com.example.hd.fml.bean.QiuFindEntity;
import com.example.hd.fml.constant.BaseFragment;
import com.example.hd.fml.request.prensenter.IHttpQiuFindEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpQiuFindEntityPresenterImpl;
import com.example.hd.fml.request.view.IHttpQiuFindEntityView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class QiuFindFragment extends BaseFragment implements IHttpQiuFindEntityView {
    IHttpQiuFindEntityPresenter iHttpQiuFindEntityPresenter;
    QiuFindAdapter qiuFindAdapter;
    @Bind(R.id.qiu_find_recycler)
    RecyclerView qiuFindRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_qiu_find, container, false);
        ButterKnife.bind(this, view);
        qiuFindRecycler.setNestedScrollingEnabled(false);
        iHttpQiuFindEntityPresenter = new IHttpQiuFindEntityPresenterImpl(this);
        iHttpQiuFindEntityPresenter.getQiuFindEntityPresenter();
        return view;
    }

    @Override
    public void getQiuFindEntityView(QiuFindEntity qiuFindEntity) {
        qiuFindRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        qiuFindAdapter = new QiuFindAdapter(qiuFindEntity, mContext);
        qiuFindRecycler.setAdapter(qiuFindAdapter);
    }

    @Override
    public void getThrowableView(Throwable throwable) {
        Toast.makeText(mContext,"请稍后再试",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
