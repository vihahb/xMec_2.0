package com.xtelsolution.xmec.xmec.view.activity.inf;

import android.app.Activity;
import android.view.View;

import com.xtelsolution.xmec.sdk.callback.Dialog.DialogListener;

/**
 * Created by vivh on 23/08/2017.
 */

public interface BasicView {

    void showShortSnackBar(View view, String message);

    void showLongSnackBar(View view, String message);

    void showLongToast(String message);

    void showShortToast(String message);

    void showProgressBar(boolean isTouchOutside, boolean isCancel, String title, String message);

    void showProgressBarWithProgress(String title, String message);

    void setProgress(int uploaded, int total);

    void closeProgressBar();

    void showMaterialDialog(boolean isTouchOutside, boolean isCancelable, String title, String message, String negative, String positive, final DialogListener dialogListener);

    void startActivity(Class clazz);

    void startActivity(Class clazz, String key, Object object);

    void startActivityAndFinish(Class clazz);

    void startActivityAndFinish(Class clazz, String key, Object object);

    void startActivityForResult(Class clazz, int requestCode);

    void startActivityForResultWithInteger(Class clazz, String key, int data, int requestCode);

    void startActivityForResult(Class clazz, String key, Object object, int requestCode);

    void onNoNetwork();

    void showComfirmDialogFull(String message, DialogListener dialogListener);

    void onRequestFail();

    void onDataInvalid(int errorCode);

    Activity getActivity();

}
