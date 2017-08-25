package com.xtelsolution.xmec.xmec.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.xtelsolution.xmec.xmec.view.activity.home.MainActivity;

/**
 * Created by vivh on 23/08/2017.
 */

public class SplashActivity extends Activity {

    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Start home activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                //Close Activity
                finish();
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        handler = null;
        super.onDestroy();
    }
}
