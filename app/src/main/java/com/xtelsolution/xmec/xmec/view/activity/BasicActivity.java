package com.xtelsolution.xmec.xmec.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.sdk.callback.Dialog.DialogListener;

/**
 * Created by vivh on 23/08/2017.
 */

public class BasicActivity extends IActivity {

    protected final int REQUEST_CALL = 1;
    protected String phone;
    boolean isWaitingForExit = false;
    private Dialog dialogProgress;
    private Toast toast;
    private ProgressBar progressBar;


    public void initToolbar(int id, String title) {
        Toolbar toolbar = (Toolbar) findViewById(id);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (title != null)
            actionBar.setTitle(title);
    }

    public void initToolbar(int id, String title, int iconLeft) {
        Toolbar toolbar = (Toolbar) findViewById(id);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (iconLeft != -1)
            toolbar.setNavigationIcon(iconLeft);

        if (title != null)
            actionBar.setTitle(title);
    }

    /*
    * Hiển thị thông báo snackbar 2s
    * */
    public void showShortSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    /*
    * Hiển thị thông báo snackbar 3.5s
    * */
    public void showLongSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    /*
    * Hiển thị thông báo 3.5s
    * */
    public void showLongToast(String message) {
        if (toast != null)
            toast.cancel();

        toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    /*
    * Hiển thị thông báo 2s
    * */
    public void showShortToast(String message) {
        if (toast != null)
            toast.cancel();

        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showConfirmExitApp() {
        if (isWaitingForExit) {
            finish();
        } else {
            new AsyncTask<Object, Object, Object>() {

                @Override
                public void onPreExecute() {
                    super.onPreExecute();
                    isWaitingForExit = true;
                    showShortToast(getString(R.string.message_back_press_to_exit));

                }

                @Override
                public Object doInBackground(Object... params) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                public void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    isWaitingForExit = false;
                }
            }.execute();
        }
    }

    @Override
    public void showProgressBar(boolean isTouchOutside, boolean isCancel, String title, String message) {

    }

    @Override
    public void showProgressBarWithProgress(String title, String message) {

    }

    @Override
    public void setProgress(int uploaded, int total) {

    }

    @Override
    public void closeProgressBar() {

    }

    /*
   * Hiển thị thông báo (chuẩn material)
   * */
    @SuppressWarnings("ConstantConditions")
    public void showMaterialDialog(boolean isTouchOutside, boolean isCancelable, String title, String message, String negative, String positive, final DialogListener dialogListener) {
        try {
            final Dialog dialog = new Dialog(BasicActivity.this, R.style.Theme_Transparent);
            dialog.setContentView(R.layout.dialog_material);
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(isTouchOutside);
            dialog.setCanceledOnTouchOutside(isCancelable);

            TextView txt_title = (TextView) dialog.findViewById(R.id.dialog_txt_title);
            TextView txt_message = (TextView) dialog.findViewById(R.id.dialog_txt_message);
            Button btn_negative = (Button) dialog.findViewById(R.id.dialog_btn_negative);
            Button btn_positive = (Button) dialog.findViewById(R.id.dialog_btn_positive);

            if (title == null)
                txt_title.setVisibility(View.GONE);
            else
                txt_title.setText(title);

            if (message == null)
                txt_message.setVisibility(View.GONE);
            else
                txt_message.setText(message);

            if (negative == null)
                btn_negative.setVisibility(View.GONE);
            else
                btn_negative.setText(negative);

            if (positive == null)
                btn_positive.setVisibility(View.GONE);
            else
                btn_positive.setText(positive);

            btn_negative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    dialogListener.negativeClicked();
                }
            });

            btn_positive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    dialogListener.positiveClicked();
                }
            });

            if (dialog != null)
                dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void startActivity(Class clazz) {

    }

    @Override
    public void startActivity(Class clazz, String key, Object object) {

    }

    @Override
    public void startActivityAndFinish(Class clazz) {

    }

    @Override
    public void startActivityAndFinish(Class clazz, String key, Object object) {

    }

    @Override
    public void startActivityForResult(Class clazz, int requestCode) {

    }

    @Override
    public void startActivityForResultWithInteger(Class clazz, String key, int data, int requestCode) {

    }

    @Override
    public void startActivityForResult(Class clazz, String key, Object object, int requestCode) {

    }

    @Override
    public void onNoNetwork() {

    }

    @Override
    public void showComfirmDialogFull(String message, DialogListener dialogListener) {

    }

    @Override
    public void onRequestFail() {

    }

    @Override
    public void onDataInvalid(int errorCode) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
