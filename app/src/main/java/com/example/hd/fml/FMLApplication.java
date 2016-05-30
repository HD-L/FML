package com.example.hd.fml;

import android.app.Application;

/**
 * Created by HD on 2016/5/20.
 */
public class FMLApplication extends Application {
    public static final String QIUMATTERTEXTMENU = "text";
    public static final String QIUMATTERVIDEOMENU = "video";
    public static final String QIUFRIENDCIRLE = "friend";
    public static final String QIUNOTES = "notes";
//    public static final String QIUFIND = "find";
//    public static final String QIUME = "me";
    public static final String QIUWUMENU= "WU";


    public static final String DAY = "day";
    public static final String VIDEO = "video";
    public static final String TEXT = "text";
    public static final String IMGRANK = "imgrank";
    public static final String SUGGEST = "suggest";
    public static final String[] Hometitle = {"糗友", "糗友圈", "发现", "小纸条", "我"};

    public static final String[] Mattertitle = {"专享", "视频", "纯文", "纯图", "精华"};
    public static final String[] MatterMenu = {"糗友", "视频", "糗友", "糗友", "糗友"};
    public static final String[] FriendCirletitle = {"隔壁", "已粉", "视频", "话题"};
    public static final String[] LayoutType = {DAY, VIDEO, TEXT, IMGRANK, SUGGEST};

    public static FMLApplication fmlApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static FMLApplication getInstance() {
        if (fmlApplication != null) {
            fmlApplication = new FMLApplication();
        }
        return fmlApplication;
    }
}
