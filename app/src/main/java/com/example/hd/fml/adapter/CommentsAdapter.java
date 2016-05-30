package com.example.hd.fml.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hd.fml.R;
import com.example.hd.fml.bean.CommentsDetailsEntity;
import com.example.hd.fml.utils.ImgUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HD on 2016/5/22.
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsAdapterViewHolder> {
    static String TAG = "CommentsAdapter";
    Context mContext;
    View view;

    List<CommentsDetailsEntity.ItemsBean> Items = new ArrayList<>();

    public CommentsAdapter(Context context) {
        this.mContext = context;
    }

    public void setCommentsDetailsEntity(List<CommentsDetailsEntity.ItemsBean> items) {
        Items.clear();
        this.Items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public CommentsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_qiu_matter_comment, parent, false);
        CommentsAdapterViewHolder commentsAdapterViewHolder = new CommentsAdapterViewHolder(view);
        return commentsAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentsAdapterViewHolder holder, int position) {
        holder.setItemEntity(Items.get(position));

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    class CommentsAdapterViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_details_head_img)
        ImageView itemDetailsHeadImg;
        @Bind(R.id.item_details_name)
        TextView itemDetailsName;
        @Bind(R.id.item_details_floor)
        TextView itemDetailsFloor;
        @Bind(R.id.item_details_comment)
        TextView itemDetailsComment;
        @Bind(R.id.item_time)
        TextView itemTime;

        public CommentsAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setItemEntity(CommentsDetailsEntity.ItemsBean itemsBean) {
            Glide.with(mContext).load(ImgUtils.getHeadImgUrl(itemsBean.getUser().getId() + "", itemsBean.getUser().getIcon())).into(itemDetailsHeadImg);
            itemDetailsName.setText(itemsBean.getUser().getLogin());
            itemDetailsFloor.setText(itemsBean.getFloor() + "");
            itemDetailsComment.setText(itemsBean.getContent());

        }
    }
}
