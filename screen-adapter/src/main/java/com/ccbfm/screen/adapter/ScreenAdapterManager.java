package com.ccbfm.screen.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

class ScreenAdapterManager {

    static final int DEFAULT_DPI = 360;
    private static final int BASIC_DPI = 160;

    static void adaptScreen(Activity activity, int screenDpi) {
        if (activity == null || screenDpi <= 0) {
            Log.d(("ScreenAdapterManager"), ("activity=" + activity + ",screenDpi=" + screenDpi));
            return;
        }
        DisplayMetrics appDisplayMetrics = getDisplayMetrics(activity.getApplication());
        DisplayMetrics activityDisplayMetrics = getDisplayMetrics(activity);

        float targetDensity = appDisplayMetrics.widthPixels / screenDpi;
        int targetDensityDpi = (int) (BASIC_DPI * targetDensity);
        float targetScaledDensity = targetDensity * (appDisplayMetrics.scaledDensity / appDisplayMetrics.density);

        setDisplayMetrics(appDisplayMetrics, targetDensity, targetDensityDpi, targetScaledDensity);

        setDisplayMetrics(activityDisplayMetrics, targetDensity, targetDensityDpi, targetScaledDensity);

    }

    private static void setDisplayMetrics(DisplayMetrics displayMetrics, float targetDensity,
                                          int targetDensityDpi, float targetScaledDensity) {
        displayMetrics.density = targetDensity;
        displayMetrics.densityDpi = targetDensityDpi;
        displayMetrics.scaledDensity = targetScaledDensity;
    }

    static DisplayMetrics getDisplayMetrics(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }
}
