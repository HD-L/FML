package com.example.hd.fml.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.hd.fml.R;
import com.example.hd.fml.adapter.CommentsAdapter;
import com.example.hd.fml.bean.CommentsDetailsEntity;
import com.example.hd.fml.bean.QiuMatterDetailsEntity;
import com.example.hd.fml.constant.BaseActivity;
import com.example.hd.fml.utils.ImgUtils;
import com.example.hd.fml.request.prensenter.IHttpCommentsDetailsEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpCommentsDetailsEntityPresenterImpl;
import com.example.hd.fml.request.prensenter.IHttpQiuMatterDetailsEntityPresenter;
import com.example.hd.fml.request.prensenter.IHttpQiuMatterDetailsEntityPresenterImpl;
import com.example.hd.fml.request.view.IHttpCommentsDetailsEntityView;
import com.example.hd.fml.request.view.IHttpQiuMatterDetailsView;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommentActivity extends BaseActivity implements IHttpQiuMatterDetailsView, IHttpCommentsDetailsEntityView {
    IHttpQiuMatterDetailsEntityPresenter iHttpQiuMatterDetailsEntityPresenter;
    IHttpCommentsDetailsEntityPresenter iHttpCommentsDetailsEntityPresenter;
    String id;
    CommentsAdapter commentsAdapter;
    int page = 1;
    String count = "20";
    @Bind(R.id.comment_toolbar)
    Toolbar commentToolbar;
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
    @Bind(R.id.comment_recycler)
    RecyclerView commentRecycler;

    @Bind(R.id.item_button_layout)
    RelativeLayout itemButtonLayout;
    boolean selected = true;
    @Bind(R.id.all)
    TextView all;
    @Bind(R.id.all_selected)
    View allSelected;
    @Bind(R.id.item_button_all)
    RelativeLayout itemButtonAll;
    @Bind(R.id.hot)
    TextView hot;
    @Bind(R.id.hot_selected)
    View hotSelected;
    @Bind(R.id.item_button_hot)
    RelativeLayout itemButtonHot;
//    @Bind(R.id.toolbar_title)
//    TextView toolbarTitle;
    @Bind(R.id.fenxiang)
    ImageView fenxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        commentRecycler.setNestedScrollingEnabled(false);
        Drawable mDrawable = LayoutToDrawable(id);
        commentToolbar.setTitle("");
        commentToolbar.setNavigationIcon(mDrawable);
        setSupportActionBar(commentToolbar);

        commentToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                WindowsFenXiangMenu.getInstance(mContext);
//                Toast.makeText(mContext,"都进来了还分享，烦不烦啊！！！",Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                alertDialog.show();
                Window window = alertDialog.getWindow();
                window.setContentView(R.layout.prompt_windows);
            }
        });
        iHttpQiuMatterDetailsEntityPresenter = new IHttpQiuMatterDetailsEntityPresenterImpl(this);
        iHttpCommentsDetailsEntityPresenter = new IHttpCommentsDetailsEntityPresenterImpl(this);
        iHttpQiuMatterDetailsEntityPresenter.getQiuMatterDetailsEntityPresenter(id);
        iHttpCommentsDetailsEntityPresenter.getSwtichCommentsDetailsEntityPresenter("all", id, page + "", count);
        itemButtonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allSelected.setVisibility(View.VISIBLE);
                hotSelected.setVisibility(View.INVISIBLE);
                iHttpCommentsDetailsEntityPresenter.getSwtichCommentsDetailsEntityPresenter("all", id, page + "", count);
            }
        });
        itemButtonHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allSelected.setVisibility(View.INVISIBLE);
                hotSelected.setVisibility(View.VISIBLE);
                iHttpCommentsDetailsEntityPresenter.getSwtichCommentsDetailsEntityPresenter("hot", id, page + "", count);
            }
        });
    }

    @Override
    public void getQiuMatterDetailsEntityView(QiuMatterDetailsEntity qiuMatterDetailsEntity) {
        contentText.setVisibility(View.GONE);
        contentImg.setVisibility(View.GONE);
        contentVideo.setVisibility(View.GONE);
        if (qiuMatterDetailsEntity.getArticle().getContent() != null) {
            contentText.setVisibility(View.VISIBLE);
            contentText.setText(qiuMatterDetailsEntity.getArticle().getContent());
        }
        if (qiuMatterDetailsEntity.getArticle().getImage() != null) {
            contentImg.setVisibility(View.GONE);
            Glide.with(mContext).load((ImgUtils.getMediumImgUrl(qiuMatterDetailsEntity.getArticle().getImage()))).into(contentImg);
        }
        if (qiuMatterDetailsEntity.getArticle().getUser() != null)
            Glide.with(mContext).load((ImgUtils.getHeadImgUrl(qiuMatterDetailsEntity.getArticle().getUser().getId() + "", qiuMatterDetailsEntity.getArticle().getUser().getIcon()))).into(headImg);
        if (qiuMatterDetailsEntity.getArticle().getUser() != null)
            nameText.setText(qiuMatterDetailsEntity.getArticle().getUser().getLogin());
        itemComment.setText("好笑 " + (qiuMatterDetailsEntity.getArticle().getVotes().getDown() + qiuMatterDetailsEntity.getArticle().getVotes().getUp()) + " · 评论 " + qiuMatterDetailsEntity.getArticle().getComments_count() + " · 分享 " + qiuMatterDetailsEntity.getArticle().getShare_count());
    }


    @Override
    public void getCommentsDetailsEntity(CommentsDetailsEntity commentsDetailsEntity) {
        commentRecycler.setLayoutManager(new LinearLayoutManager(this));
        if (commentsAdapter == null) {
            commentsAdapter = new CommentsAdapter(this);
        }
        commentsAdapter.setCommentsDetailsEntity(commentsDetailsEntity.getItems());
        commentRecycler.setAdapter(commentsAdapter);
    }

    @Override
    public void getThrowableView(Throwable throwable) {
        Toast.makeText(mContext, "请稍后再试", Toast.LENGTH_SHORT).show();
    }



    public Drawable LayoutToDrawable(String id) {
        LayoutInflater inflator = getLayoutInflater();
        View viewHelp = inflator.inflate(R.layout.icon, null);
        TextView textView = (TextView) viewHelp.findViewById(R.id.icon_id);
        textView.setText(id);
        int size = textView.getText().length();
        Bitmap snapshot = convertViewToBitmap(viewHelp, size);
        Drawable drawable = new BitmapDrawable(snapshot);
        return drawable;
    }

    public static Bitmap convertViewToBitmap(View view, int size) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int width = size * 60;
        view.layout(0, 0, width, view.getMeasuredHeight());  //根据字符串的长度显示view的宽度
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }
}
