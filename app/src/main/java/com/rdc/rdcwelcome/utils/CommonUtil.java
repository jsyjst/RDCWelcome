package com.rdc.rdcwelcome.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import com.rdc.rdcwelcome.R;

/**
 * Created by 残渊 on 2018/11/5.
 */

public class CommonUtil {
    /*** 状态栏的显示和隐藏
     * @param activity
     * @param context
     * @param hide 根据hide的boolean值来决定状态栏的隐藏和显示
     */
    public static void hideStatusBar(Activity activity, Context context, boolean hide) {
        if (Build.VERSION.SDK_INT >= 22) {
            View decorView = activity.getWindow().getDecorView();
            if (hide) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                activity.getWindow().setStatusBarColor(context.getResources().getColor(R.color.colorPrimary));
            }

        }
    }
    /**
     * 获取系统状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
