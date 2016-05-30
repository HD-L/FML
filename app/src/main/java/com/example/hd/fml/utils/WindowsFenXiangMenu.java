package com.example.hd.fml.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;

import com.example.hd.fml.R;

/**
 * Created by HD on 2016/5/25.
 */
public class WindowsFenXiangMenu {
    static Context mContext;
    static WindowsFenXiangMenu windowsFenXiangMenu;

    public WindowsFenXiangMenu() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.prompt_windows);
    }

    public static WindowsFenXiangMenu getInstance(Context context) {
        mContext = context;
        if (windowsFenXiangMenu == null) {
            windowsFenXiangMenu = new WindowsFenXiangMenu();
        }
        return windowsFenXiangMenu;
    }
}
