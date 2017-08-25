package com.xtelsolution.xmec.xmec;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by vivh on 23/08/2017.
 */

public class MyApplication extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initLeakCanary();
    }

    private void initLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
