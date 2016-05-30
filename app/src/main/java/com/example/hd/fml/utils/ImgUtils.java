package com.example.hd.fml.utils;

import java.util.regex.Pattern;

/**
 * Created by HD on 2016/5/19.
 */
public class ImgUtils {

    static String uri = "http://pic.qiushibaike.com/system/";
    static String uriContent = "pictures/";
    static String uriHeadImg = "avtnew/";
    static String uriMedium = "/medium/";
    static String uriSmall = "/small/";

    /**
     * 传入image，获得完整图网络路径
     * @param image
     * @return
     */
    public static String getMediumImgUrl(String image) {
        String code = image.substring(3, 12);
        return uri + uriContent + code.substring(0, 5) + "/" + code + uriMedium + image;
    }

    /**
     * 传入image，获得缩略图网络路径
     * @param image
     * @return
     */
    public static String getSmallImgUrl(String image) {
        String code = image.substring(3, 12);
        return uri + uriContent + code.substring(0, 5) + "/" + code + uriSmall + image;
    }

    /**
     *  传入user和icon获得头像网络路径
     * @param user
     * @param icon
     * @return
     */
    public static String getHeadImgUrl(String user, String icon) {
        String userid = null;
        switch (user.length()) {
            case 7:
                userid = user.substring(0, 3);
                break;
            case 8:
                userid = user.substring(0, 4);
                break;
        }
        return uri + uriHeadImg + userid + "/" + user + uriMedium + icon;
    }

    public static String isNumeric(String str) {
        Pattern pattern = Pattern.compile("[^0-9]");
        return pattern.matcher(str).group();
    }

}
