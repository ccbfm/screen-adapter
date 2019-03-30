package com.ccbfm.screenadapter;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.ccbfm.screen.adapter.ScreenAdapter;
import com.ccbfm.screen.adapter.ScreenAdapterTools;


public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_DPI = 360;

    @ScreenAdapter(240)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("wds","MainActivity---onCreate");
        //set1();
        //long startTime = System.nanoTime();
        //ScreenAdapterTools.adaptScreen(this, 240);
        //Log.d("wds","useTime="+(System.nanoTime() - startTime));
        test1();
        test2();
        test3();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, new TestFragment()).commit();
    }

    public void buttonClick(View view){
        startActivity(new Intent(this, TestActivity.class));
    }

    private void set1(){
        final DisplayMetrics appDisplayMetrics = getApplication().getResources().getDisplayMetrics();
        DisplayMetrics activityDisplayMetrics = getResources().getDisplayMetrics();
        float targetDensity = appDisplayMetrics.widthPixels / DEFAULT_DPI;
        int targetDensityDpi = (int)(160 * targetDensity);
        float targetScaledDensity = targetDensity * (appDisplayMetrics.scaledDensity / appDisplayMetrics.density);
        Log.d("wds","set1-targetDensity="+targetDensity+",targetDensityDpi="+targetDensityDpi+",tatgetScaledDensity="+targetScaledDensity);
        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;
        appDisplayMetrics.scaledDensity = targetScaledDensity;

        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
    }

    protected void test1(){
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","test1-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","test1-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }

    protected void test2(){
        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","test2-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","test2-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }

    protected void test3(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("wds","test3-density="+density+",scaledDensity="+scaledDensity+",densityDpi="+densityDpi);
        Log.d("wds","test3-widthPixels="+widthPixels+",heightPixels="+heightPixels);
    }
}
