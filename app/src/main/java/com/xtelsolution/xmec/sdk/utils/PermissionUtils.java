package com.xtelsolution.xmec.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by vivh on 23/08/2017.
 */

public class PermissionUtils {

    public static boolean checkListPermission(String[] permission, Activity activity, int REQUEST_CODE) {
        boolean isAllow = true;

        for (int i = (permission.length - 1); i >= 0; i--) {
            if (ActivityCompat.checkSelfPermission(activity, permission[i]) != PackageManager.PERMISSION_GRANTED) {
                isAllow = false;
                break;
            }
        }

        if (!isAllow) {
            boolean isShould = true;
            for (int i = (permission.length - 1); i >= 0; i--) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission[i])) {
                    isShould = false;
                    break;
                }
            }
            // Should we show an explanation?
            if (isShould) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(activity, permission, REQUEST_CODE);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, permission, REQUEST_CODE);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            return false;
        }

        return true;
    }

    public static boolean checkListPermission(String[] permission, Context context) {
        boolean isAllow = true;

        for (int i = (permission.length - 1); i >= 0; i--) {
            if (ActivityCompat.checkSelfPermission(context, permission[i]) != PackageManager.PERMISSION_GRANTED) {
                isAllow = false;
                break;
            }
        }

        return isAllow;
    }

    public static boolean checkOnlyPermission(String permission, Activity activity, int REQUEST_CODE) {
        if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            return false;
        }
        return true;
    }

    public static boolean checkResult(int[] grantResults) {
        boolean result = true;

        for (int grant : grantResults) {
            if (grant == PackageManager.PERMISSION_DENIED)
                result = false;
        }

        return result;
    }
}
