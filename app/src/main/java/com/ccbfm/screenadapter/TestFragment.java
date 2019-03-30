package com.ccbfm.screenadapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        test1();
        test2();
        test3();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void test1(){
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","TestFragment-test1-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","TestFragment-test1-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }

    private void test2(){
        DisplayMetrics displayMetrics = getActivity().getApplication().getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","TestFragment-test2-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","TestFragment-test2-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }

    private void test3(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","TestFragment-test3-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","TestFragment-test3-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }
}
