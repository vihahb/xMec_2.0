package com.xtelsolution.xmec.sdk.callback;

import android.os.AsyncTask;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.xmec.MyApplication;
import com.xtelsolution.xmec.xmec.model.entity.Error;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by vivh on 23/08/2017.
 */

public class RequestServer {

    protected final String SESSION = "session";

    public RequestServer() {
    }

    private class PostToServer extends AsyncTask<String, Integer, String> {
        private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        private ResponseHandle responseHandle;
        private boolean isSuccess = true;

        PostToServer(ResponseHandle responseHandle) {
            this.responseHandle = responseHandle;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(params[0]);

                if (params[1] != null) {
                    RequestBody body = RequestBody.create(JSON, params[1]);
                    builder.post(body);
                }

                if (params[2] != null)
                    builder.header(SESSION, params[2]);

                Request request = builder.build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                isSuccess = false;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (isSuccess)
                responseHandle.onSuccess(s);
            else
                responseHandle.onError(new Error(-1, MyApplication.context.getString(R.string.message_can_not_request)));
        }
    }

    private class GetToServer extends AsyncTask<String, Integer, String> {
        private ResponseHandle responseHandle;
        private boolean isSuccess = true;

        GetToServer(ResponseHandle responseHandle) {
            this.responseHandle = responseHandle;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(params[0]);

                if (params[1] != null)
                    builder.header(SESSION, params[1]);

                Request request = builder.build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                isSuccess = false;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (isSuccess)
                responseHandle.onSuccess(s);
            else
                responseHandle.onError(new Error(-1, MyApplication.context.getString(R.string.message_can_not_request)));
        }
    }

    private class PutToServer extends AsyncTask<String, Integer, String> {
        private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        private ResponseHandle responseHandle;
        private boolean isSuccess = true;

        PutToServer(ResponseHandle responseHandle) {
            this.responseHandle = responseHandle;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(params[0]);

                if (params[1] != null) {
                    RequestBody body = RequestBody.create(JSON, params[1]);
                    builder.put(body);
                }

                if (params[2] != null)
                    builder.header(SESSION, params[2]);

                Request request = builder.build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                isSuccess = false;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (isSuccess)
                responseHandle.onSuccess(s);
            else
                responseHandle.onError(new Error(-1, MyApplication.context.getString(R.string.message_can_not_request)));
        }
    }

    private class DeleteToServer extends AsyncTask<String, Integer, String> {
        private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        private ResponseHandle responseHandle;
        private boolean isSuccess = true;

        DeleteToServer(ResponseHandle responseHandle) {
            this.responseHandle = responseHandle;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(params[0]);

                if (params[1] != null) {
                    RequestBody body = RequestBody.create(JSON, params[1]);
                    builder.delete(body);
                }

                if (params[2] != null)
                    builder.header(SESSION, params[2]);

                Request request = builder.build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                isSuccess = false;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (isSuccess)
                responseHandle.onSuccess(s);
            else
                responseHandle.onError(new Error(-1, MyApplication.context.getString(R.string.message_can_not_request)));
        }
    }

}
