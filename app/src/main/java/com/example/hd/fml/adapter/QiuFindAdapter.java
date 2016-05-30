package com.example.hd.fml.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hd.fml.R;
import com.example.hd.fml.bean.QiuFindEntity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HD on 2016/5/23.
 */
public class QiuFindAdapter extends RecyclerView.Adapter<QiuFindAdapter.QiuFindAdapterViewHolder> {


    private QiuFindEntity findEntity;
    private Context context;
    View view;

    public QiuFindAdapter(QiuFindEntity qiuFindEntity, Context context) {
        this.findEntity = qiuFindEntity;
        this.context = context;
    }


    @Override
    public QiuFindAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_find_layout, parent, false);
        QiuFindAdapterViewHolder qiuFindAdapterViewHolder = new QiuFindAdapterViewHolder(view);
        return qiuFindAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(QiuFindAdapterViewHolder holder, int position) {
        if (position == 0) {
            holder.itemFindBuyTitle.setVisibility(View.VISIBLE);
        } else if (position <= findEntity.getBuy().getItems().size()) {
            holder.setItemEntity(findEntity.getBuy(), findEntity.getBuy().getItems().size() - position);
            holder.itemFindBuyComment.setVisibility(View.VISIBLE);
        } else if (position == findEntity.getBuy().getItems().size() + 1) {
            holder.itemFindGameTitle.setVisibility(View.VISIBLE);
        } else if (position <= findEntity.getBuy().getItems().size() + 1 + findEntity.getGame().getGames().size()) {
            holder.setItemEntity(findEntity.getGame(), findEntity.getBuy().getItems().size() + 1 + findEntity.getGame().getGames().size() - position);
            holder.itemFindGameComment.setVisibility(View.VISIBLE);
        } else if (position == findEntity.getBuy().getItems().size() + 1 + findEntity.getGame().getGames().size() + 1) {
            holder.itemFindVideoTitle.setVisibility(View.VISIBLE);
        } else if (position <= findEntity.getBuy().getItems().size() + 1 + findEntity.getGame().getGames().size() + 1 + findEntity.getVideo().getVideos().size()) {
            holder.setItemEntity(findEntity.getVideo(), findEntity.getBuy().getItems().size() + 1 + findEntity.getGame().getGames().size() + 1 + findEntity.getVideo().getVideos().size() - position);
            holder.itemFindVideoComment.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return findEntity.getBuy().getItems().size() + findEntity.getGame().getGames().size() + findEntity.getVideo().getVideos().size() + 3;
    }

    public class QiuFindAdapterViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_find_buy_title)
        RelativeLayout itemFindBuyTitle;
        @Bind(R.id.item_find_buy_image)
        ImageView itemFindBuyImage;
        @Bind(R.id.item_find_buy_name)
        TextView itemFindBuyName;
        @Bind(R.id.item_find_buy_price)
        TextView itemFindBuyPrice;
        @Bind(R.id.item_find_buy_mktPrince)
        TextView itemFindBuyMktPrince;
        @Bind(R.id.item_find_buy_comment)
        RelativeLayout itemFindBuyComment;
        @Bind(R.id.item_find_game_title)
        RelativeLayout itemFindGameTitle;
        @Bind(R.id.item_find_game_image)
        ImageView itemFindGameImage;
        @Bind(R.id.item_find_game_name)
        TextView itemFindGameName;
        @Bind(R.id.item_find_game_details)
        TextView itemFindGameDetails;
        @Bind(R.id.button)
        Button button;
        @Bind(R.id.item_find_game_comment)
        RelativeLayout itemFindGameComment;
        @Bind(R.id.item_find_video_title_Image)
        ImageView itemFindVideoTitleImage;
        @Bind(R.id.item_find_video_title_name)
        TextView itemFindVideoTitleName;
        @Bind(R.id.item_find_video_title_details)
        TextView itemFindVideoTitleDetails;
        @Bind(R.id.item_find_video_title)
        RelativeLayout itemFindVideoTitle;
        @Bind(R.id.item_find_video_image)
        ImageView itemFindVideoImage;
        @Bind(R.id.item_find_video_name)
        TextView itemFindVideoName;
        @Bind(R.id.item_find_video_details)
        TextView itemFindVideoDetails;
        @Bind(R.id.item_find_video_comment)
        RelativeLayout itemFindVideoComment;


        public QiuFindAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setItemEntity(QiuFindEntity.BuyBean itemEntity, int i) {
            Glide.with(context).load(itemEntity.getItems().get(i).getImage()).into(itemFindBuyImage);
            itemFindBuyMktPrince.setText("￥" + itemEntity.getItems().get(i).getMktPrice());
            itemFindBuyMktPrince.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            itemFindBuyName.setText(itemEntity.getItems().get(i).getName());
            itemFindBuyPrice.setText("￥" + itemEntity.getItems().get(i).getPrice());

        }

        public void setItemEntity(QiuFindEntity.GameBean itemEntity, int i) {
            Glide.with(context).load(itemEntity.getGames().get(i).getImage()).into(itemFindGameImage);
            itemFindGameDetails.setText(itemEntity.getGames().get(i).getDescription());
            itemFindGameName.setText(itemEntity.getGames().get(i).getName());
        }

        public void setItemEntity(QiuFindEntity.VideoBean itemEntity, int i) {
            Glide.with(context).load(itemEntity.getVideos().get(i).getImage()).into(itemFindVideoImage);
            itemFindVideoTitleName.setText(itemEntity.getName());
            itemFindVideoTitleDetails.setText(itemEntity.getDescription() + " > ");
            itemFindVideoName.setText(itemEntity.getVideos().get(i).getSubject());
            itemFindVideoDetails.setText(itemEntity.getVideos().get(i).getDescription());
        }

    }

}
