package com.example.hd.fml.constant;

/**
 * Created by HD on 2016/4/13.
 */
public interface DateCallback {
    /***
     * 成功回调的数据实体
     *
     * @param o
     */
    void onSuccess(Object o);

    /***
     * 错误不做处理
     */
    void onError(Throwable throwable);
}
