package com.example.hd.fml.constant;

import com.example.hd.fml.bean.CommentsDetailsEntity;
import com.example.hd.fml.bean.QiuFindEntity;
import com.example.hd.fml.bean.QiuMatterDetailsEntity;
import com.example.hd.fml.bean.QiuMatterEntity;
import com.example.hd.fml.bean.StartPageEntity;
import com.example.hd.fml.bean.TopicEntity;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by HD on 2016/5/16.
 */
public interface IConstantURL {
    //这就是利用注解在你用GET方式请求的时候会自动给你补全一部分URL路径，花括号里面的有user点类似变量对应下面参数
    @GET("/open/{url}")
    //这个注解的大概理解为传过来的的String参数会添加到上面的花括号里
    Call<StartPageEntity> getStartPageEntity(@Path("url") String url);

    @GET("/article/list/{url}")
    Call<QiuMatterEntity> getQiuMatterEntity(@Path("url") String url, @Query("page") String page, @Query("count") String count);

    @GET("/article/list/{url}")
    Call<QiuMatterEntity> getQiuMatterEntity(@Path("url") String url);

    @GET("/article/{url}")
    Call<QiuMatterDetailsEntity> getQiuMatterDetailsEntity(@Path("url") String url);

    @GET("/article/{url}/comments")
    Call<CommentsDetailsEntity> getAllCommentsDetailsEntity(@Path("url") String url, @Query("page") String page, @Query("count") String count);

    @GET("/article/{url}/hot/comments")
    Call<CommentsDetailsEntity> getHotCommentsDetailsEntity(@Path("url") String url, @Query("page") String page, @Query("count") String count);

    @GET("/found/info")
    Call<QiuFindEntity> getQiuFindEntity();

    @GET("/article/topic/top")
    Call<TopicEntity> getQiuFriendCircleEntity();
}
