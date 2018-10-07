package com.kharol.sociallabourwelfare.Service;

import com.android.volley.VolleyError;

import org.json.JSONException;

/**
 * Created by Bilal on 01/06/2018.
 */
public interface ResponseListener {
    void onError(VolleyError error);
	void onSuccess(String string) throws JSONException;
//	ArrayList<NotificationModel> onSuccess_one(JSONObject response);
}
