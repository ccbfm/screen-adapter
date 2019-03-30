package com.ccbfm.screen.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author ccbfm
 */
public class ScreenAdapterTools {

    static int sDesignDpi = ScreenAdapterManager.DEFAULT_DPI;

    public static void initScreenDpi(int screenDpi) {
        sDesignDpi = screenDpi;
    }

    public static int getsDesignDpi() {
        return sDesignDpi;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return ScreenAdapterManager.getDisplayMetrics(context);
    }

    public static void adaptScreen(Activity activity) {
        ScreenAdapterManager.adaptScreen(activity, getsDesignDpi());
    }

    public static void adaptScreen(Activity activity, int screenDpi) {
        ScreenAdapterManager.adaptScreen(activity, screenDpi);
    }
}
