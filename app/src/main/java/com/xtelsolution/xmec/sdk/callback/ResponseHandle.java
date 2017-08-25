package com.xtelsolution.xmec.sdk.callback;

import android.text.TextUtils;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.sdk.utils.JsonHelper;
import com.xtelsolution.xmec.xmec.MyApplication;
import com.xtelsolution.xmec.xmec.model.rest.RestBasic;
import com.xtelsolution.xmec.xmec.model.entity.Error;

/**
 * Created by vivh on 23/08/2017.
 */

public abstract class ResponseHandle<T extends RestBasic> {

    private Class<T> clazz;

    protected ResponseHandle(Class<T> clazz) {
        this.clazz = clazz;
    }

    void onSuccess(String result) {
//        Log.e("ResponseHandle", "null: " + result);

        if (TextUtils.isEmpty(result)) {
            onSuccess((T) null);
        } else if (result.equals("\"\"")) {
            onError(new Error(-1, MyApplication.context.getString(R.string.error_try_again)));
        } else {
            result = getNewJson(result);
//            Log.e("ResponseHandle", "new result " + result);

            T t = JsonHelper.getObjectNoException(result, clazz);
//            Log.e("ResponseHandle", "object " + JsonHelper.toJson(t));

            if (t == null)
                onError(new Error(-1, MyApplication.context.getString(R.string.error_try_again)));
            else if (t.getErrorCode() != null || t.getMessage() != null) {
                if (t.getErrorCode() == null) {
                    onError(new Error(-1, MyApplication.context.getString(R.string.error_try_again)));
                } else {
                    if (t.getErrorCode() == 0)
                        onSuccess(t);
                    else
                        onError(new Error(t.getErrorCode(), t.getMessage()));
                }
            } else {
                onSuccess(t);
            }
        }
    }

    private String getNewJson(String result) {
        if (result.charAt(0) == '[' && result.charAt((result.length() - 1)) == ']') {
            return "{ \"data\": " + result + "}";
        }
        return result;
    }

    public abstract void onSuccess(T obj);

    public abstract void onError(Error error);

}
