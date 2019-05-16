package com.example.zakifaizal.protp4d;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Handler {

    public static Handler mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private Handler(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        }
        return requestQueue;
    }
    public static synchronized Handler getInstance(Context c)
    {
        if(mInstance == null){
            mInstance = new Handler(c);
        }
        return mInstance;
    }
    public <T> void addRequestQueue(Request<T> request){
        requestQueue.add(request);
    }

}
