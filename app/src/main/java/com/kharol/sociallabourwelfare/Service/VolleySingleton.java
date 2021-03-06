package com.kharol.sociallabourwelfare.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 *
 */
public class VolleySingleton {
	private static VolleySingleton mInstance;
	private RequestQueue mRequestQueue;
	private static Context mCtx;

	private VolleySingleton(Context context) {
		mCtx = context;
		mRequestQueue = getmRequestQueue();
	}

	public static synchronized VolleySingleton getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new VolleySingleton(context);
		}
		return mInstance;
	}

	public RequestQueue getmRequestQueue() {
		if (mRequestQueue == null) {
			// getApplicationContext() is key, it keeps you from leaking the
			// Activity or BroadcastReceiver if someone passes one in.
			mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
		}
		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req) {
		getmRequestQueue().add(req);
	}

	public static VolleySingleton getInstance() {
		return null;
	}

	public ImageLoader getImageLoader() {
		return null;
	}

	public static VolleySingleton getsInstance() {
		return null;
	}
}