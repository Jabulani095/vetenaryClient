package com.vetenary.jabu.vetenaryapp.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.vetenary.jabu.vetenaryapp.events.NetWorkEvents;
import com.vetenary.jabu.vetenaryapp.services.NetworkCall;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class BaseEntry extends AppCompatActivity implements NetWorkEvents {

    protected NetworkCall db;
    private Context context;

    public BaseEntry() {
        db = new NetworkCall();
        context = this;
    }
    protected abstract String getScreenName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void OpenScreen(Class<?> cls,Map<Object, Object>... maps){
        Intent i = new Intent(context,cls);
        if(maps != null){

        }
        startActivity(i);
    }
    protected void GET(String url, final Object Body) {
        try {
            db.client.newCall(db.GET(url))
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            listener.OnGetDataFailed(e.getMessage(), Body,500);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            if (response.isSuccessful()) {
                                listener.OnGetDataSuccess(response.body().string(), Body);
                                response.body().close();
                            } else {
                                if(response.code() == 401){

                                }else {
                                    listener.OnGetDataFailed(response.body().string(), Body, response.code());
                                    response.body().close();
                                }
                            }
                        }
                    });
        }catch (Exception ex){

        }
    }

    protected void DELETE(String url, final Object Body) {
        try {
            db.client.newCall(db.DELETE(new Gson().toJson(Body),url))
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            listener.OnGetDataFailed(e.getMessage(), Body,500);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            if (response.isSuccessful()) {
                                listener.OnGetDataSuccess(response.body().string(), Body);
                                response.body().close();
                            } else {
                                if(response.code() == 401){

                                }else {
                                    listener.OnGetDataFailed(response.body().string(), Body, response.code());
                                    response.body().close();
                                }
                            }
                        }
                    });
        }catch (Exception ex){

        }
    }

    protected void POST(final Object Body, String url) {
        try {
            db.client.newCall(db.POST(new Gson().toJson(Body), url))
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            listener.OnGetDataFailed(e.getMessage(), Body,500);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            if (response.isSuccessful()) {
                                listener.OnGetDataSuccess(response.body().string(), Body);
                                response.body().close();
                            } else {
                                if(response.code() == 401){

                                }else {
                                    listener.OnGetDataFailed(response.body().string(), Body, response.code());
                                    response.body().close();
                                }
                            }
                        }
                    });
        }catch (Exception ex){

        }
    }

    protected void PUT(final Object Body, String url) {
        try {
            db.client.newCall(db.PUT(new Gson().toJson(Body), url))
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            listener.OnGetDataFailed(e.getMessage(), Body,500);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            NetWorkEvents listener = (NetWorkEvents) context;
                            if (response.isSuccessful()) {
                                listener.OnGetDataSuccess(response.body().string(), Body);
                                response.body().close();
                            } else {
                                if(response.code() == 401){

                                }else {
                                    listener.OnGetDataFailed(response.body().string(), Body, response.code());
                                    response.body().close();
                                }
                            }
                        }
                    });
        }catch (Exception ex){

        }
    }


}
