package com.kharol.sociallabourwelfare.Service;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bilal on 01/06/2018.
 */
public class RequestGenerator {

    private static ProgressDialog progressDialog;
    private static int COUNT;

    public static void showProgressDialog(final Activity context) {
        try {
            cancelProgressDialog();
            context.runOnUiThread(new Runnable() {
                public void run() {
                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    COUNT++;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cancelProgressDialog() {
        try {
            if (progressDialog != null) {
                if (COUNT <= 1) {
                    progressDialog.cancel();
                    progressDialog = null;
                }
                COUNT--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // For Activity

    public static void makePostRequest(Activity context, String url, JSONObject body, boolean showDialog, final ResponseListener responseListener) {

        try {
            if (showDialog) {
                showProgressDialog(context);
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(body));
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                responseListener.onSuccess(response.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            cancelProgressDialog();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            responseListener.onError(error);
                            cancelProgressDialog();
                        }
                    }) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }

                @Override
                protected VolleyError parseNetworkError(VolleyError volleyError) {
                    if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
                        VolleyError error = new VolleyError(new String(volleyError.networkResponse.data));
                        volleyError = error;
                    }
                    return volleyError;
                }

            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 8, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void makeGetRequest(final Activity context, String url, boolean showDialog, final ResponseListener responseListener) {

        try {
            if (showDialog) {
                showProgressDialog(context);
            }
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        responseListener.onSuccess(response.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    cancelProgressDialog();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    responseListener.onError(error);
                    error.printStackTrace();
                    cancelProgressDialog();
                }
            }) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }

                @Override
                protected VolleyError parseNetworkError(VolleyError volleyError) {
                    if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
                        VolleyError error = new VolleyError(new String(volleyError.networkResponse.data));
                        volleyError = error;
                    }
                    return volleyError;
                }

            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 8, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // For Fragment

    public static void showProgressDialog(final Fragment fragment) {
        try {
            cancelProgressDialog();
            fragment.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    progressDialog = new ProgressDialog(fragment.getActivity());
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    COUNT++;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makePostRequest(final Fragment fragment, String url, JSONObject body, boolean showDialog, final ResponseListener responseListener) {
        try {
            if (showDialog) {
                showProgressDialog(fragment.getActivity());
            }

            JSONObject jsonObject = new JSONObject(String.valueOf(body));
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                responseListener.onSuccess(response.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            cancelProgressDialog();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            responseListener.onError(error);
                            cancelProgressDialog();
                        }
                    }) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }

                @Override
                protected VolleyError parseNetworkError(VolleyError volleyError) {
                    if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
                        VolleyError error = new VolleyError(new String(volleyError.networkResponse.data));
                        volleyError = error;
                    }
                    return volleyError;
                }

            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 8, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(fragment.getActivity()).addToRequestQueue(jsonObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void makeGetRequest(final Fragment fragment, String url, boolean showDialog, final ResponseListener responseListener) {

        try {
            if (showDialog) {
                showProgressDialog(fragment.getActivity());
            }
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        responseListener.onSuccess(response.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    cancelProgressDialog();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    responseListener.onError(error);
                    error.printStackTrace();
                    cancelProgressDialog();
                }
            }) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }

                @Override
                protected VolleyError parseNetworkError(VolleyError volleyError) {
                    if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
                        VolleyError error = new VolleyError(new String(volleyError.networkResponse.data));
                        volleyError = error;
                    }
                    return volleyError;
                }

            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 8, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(fragment.getActivity()).addToRequestQueue(stringRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
/*        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("", "");

            Log.e("Requ", jsonObject.toString());

            RequestGenerator.makePostRequest(EditProfile.this, "", jsonObject, true, new ResponseListener() {
                @Override
                public void onError(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Please Try Again", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(String string) throws JSONException {
                    if (!string.equals("")) {
                        Log.e("Resp", string);
                        JSONObject jsonObject1 = new JSONObject(string);
                        String Status = jsonObject1.getString("Status");
                        if (Status.equals("Success")) {

                        } else {

                        }

                    }

                }
            });

        } catch (JSONException e) {
        }
*/