package com.rdc.rdcwelcome.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2018/12/12
 *     desc   : 屏幕相关工具类
 * </pre>
 */


public class ScreenUtils {
    /**
     * * 获取屏幕宽度
     * @return 屏幕宽度
     */
    public static int getScreenWidth(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @return 屏幕高度
     */
    public static int getScreenHeight(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
