package com.example.hd.fml.view.QiuMatter;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.example.hd.fml.R;
import com.example.hd.fml.adapter.TemplateAdapter;
import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.constant.BaseFragment;
import com.example.hd.fml.view.CommentActivity;
import com.example.hd.fml.request.prensenter.IHttpQiuMatterEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpQiuMatterEntityPresenterImpl;
import com.example.hd.fml.request.view.IHttpQiuMatterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TemplateFragment extends BaseFragment implements IHttpQiuMatterView, SwipeRefreshLayout.OnRefreshListener {
    IHttpQiuMatterEntityPresenter iHttpQiuMatterEntityPresenter;
    String url;
    List<QiuMatterEntity.ItemsBean> itemDisplayList = new ArrayList<>();
    @Bind(R.id.template_recycler)
    RecyclerView templateRecycler;
    int page = 2;
    String count = "20";
    TemplateAdapter templateAdapter;
    @Bind(R.id.swipe_refresh_widget)
    SwipeRefreshLayout swipeRefreshWidget;
    LinearLayoutManager mLayoutManager;
    int lastVisibleItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_template, container, false);
        ButterKnife.bind(this, view);
        url = getArguments().getString("url");

        swipeRefreshWidget.setOnRefreshListener(this);
        swipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mLayoutManager = new LinearLayoutManager(mContext);

        iHttpQiuMatterEntityPresenter = new IHttpQiuMatterEntityPresenterImpl(this);
        iHttpQiuMatterEntityPresenter.getQiuMatterEntityPresenter(url, "1", count);

        return view;
    }


    @Override
    public void getQiuMatterEntityView(final QiuMatterEntity entity) {

        templateRecycler.setLayoutManager(mLayoutManager);
        swipeRefreshWidget.setRefreshing(false);
        if (templateAdapter == null) {
            templateAdapter = new TemplateAdapter(mContext);
            templateRecycler.setAdapter(templateAdapter);
        }
        itemDisplayList.addAll(entity.getItems());
        templateAdapter.setQiuMatterEntity(itemDisplayList);


        templateAdapter.setOnItemClickListener(new TemplateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (view.getId() == R.id.fenxiang) {
//                    WindowsFenXiangMenu.getInstance(getContext());
//                    Toast.makeText(mContext,"分享你个大西瓜啊！！！",Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                    alertDialog.show();
                    Window window = alertDialog.getWindow();
                    window.setContentView(R.layout.prompt_windows);
                } else {
                    Intent intent = new Intent(getContext(), CommentActivity.class);
                    intent.putExtra("id", String.valueOf(itemDisplayList.get(position).getId()));
                    startActivity(intent);
                }
            }
        });

        templateRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == templateAdapter.getItemCount()) {
                    swipeRefreshWidget.setRefreshing(true);
                    iHttpQiuMatterEntityPresenter.getQiuMatterEntityPresenter(url, page++ + "", count);
                    new Handler().sendEmptyMessageDelayed(0, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }


    @Override
    public void getThrowableView(Throwable throwable) {
        Toast.makeText(mContext, "请稍后再试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iHttpQiuMatterEntityPresenter.getQiuMatterEntityPresenter(url, "1", count);
                swipeRefreshWidget.setRefreshing(false);
            }
        }, 3000);

    }
}
