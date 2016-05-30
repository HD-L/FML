package com.example.hd.fml.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.hd.fml.R;
import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.utils.ImgUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HD on 2016/5/18.
 */
public class TemplateAdapter extends RecyclerView.Adapter<TemplateAdapter.TemplateAdapterViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    List<QiuMatterEntity.ItemsBean> itemDisplayList;

    Context mContext;
    View view;


    public TemplateAdapter(Context context) {
        this.mContext = context;
    }

    public void setQiuMatterEntity(List<QiuMatterEntity.ItemsBean> itemDisplayList) {
        this.itemDisplayList = itemDisplayList;
        notifyDataSetChanged();
    }

    @Override
    public TemplateAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_qiu_template, parent, false);
        TemplateAdapterViewHolder templateAdapterViewHolder = new TemplateAdapterViewHolder(view);
        return templateAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(final TemplateAdapterViewHolder holder, int position) {
        holder.setItemsBean(itemDisplayList.get(position));

        if (mOnItemClickListener != null) {
            holder.fenxiang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.fenxiang, pos);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemDisplayList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickListener = mOnItemClickLitener;
    }

    class TemplateAdapterViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.head_Img)
        RoundedImageView headImg;
        @Bind(R.id.name_text)
        TextView nameText;
        @Bind(R.id.item_hot)
        TextView itemHot;
        @Bind(R.id.content_text)
        TextView contentText;
        @Bind(R.id.content_img)
        ImageView contentImg;
        @Bind(R.id.content_video)
        VideoView contentVideo;
        @Bind(R.id.item_comment)
        TextView itemComment;
        @Bind(R.id.item_like)
        ImageView itemLike;
        @Bind(R.id.item_hate)
        ImageView itemHate;
        @Bind(R.id.item_comments)
        ImageView itemComments;

        @Bind(R.id.fenxiang)
        ImageView fenxiang;

        public TemplateAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setItemsBean(QiuMatterEntity.ItemsBean itemsBean) {
            contentText.setVisibility(View.GONE);
            contentImg.setVisibility(View.GONE);
            contentVideo.setVisibility(View.GONE);
            switch (itemsBean.getFormat()) {
                case "word":
                    contentText.setVisibility(View.VISIBLE);
                    break;
                case "video":
                    contentText.setVisibility(View.VISIBLE);
                    contentImg.setVisibility(View.VISIBLE);
                    break;
                case "image":
                    contentText.setVisibility(View.VISIBLE);
                    contentImg.setVisibility(View.VISIBLE);
                    break;
            }
            if (itemsBean.getContent() != null) {
                contentText.setText(itemsBean.getContent());
            }
            if (itemsBean.getImage() != null) {
                Glide.with(mContext).load((ImgUtils.getMediumImgUrl(itemsBean.getImage()))).into(contentImg);
            }
            if (itemsBean.getUser() != null)
                Glide.with(mContext).load((ImgUtils.getHeadImgUrl(itemsBean.getUser().getId() + "", itemsBean.getUser().getIcon()))).into(headImg);
            if (itemsBean.getUser() != null)
                nameText.setText(itemsBean.getUser().getLogin());

            itemComment.setText("好笑 " + (itemsBean.getVotes().getDown() + itemsBean.getVotes().getUp()) + " · 评论 " + itemsBean.getComments_count() + " · 分享 " + itemsBean.getShare_count());
        }

    }
}
