package com.kharol.sociallabourwelfare.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.Service.RequestGenerator;
import com.kharol.sociallabourwelfare.Service.ResponseListener;
import com.kharol.sociallabourwelfare.helper.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_email,edt_password;
    Button login,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_email=findViewById(R.id.edt_email);
        edt_password=findViewById(R.id.edt_password);
        login=findViewById(R.id.btnlogin);
        login.setOnClickListener(this);
        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v==login)
        {
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            //i.putExtra("id",id);
            startActivity(i);
            /*final String email=edt_email.getText().toString();
            final String password=edt_password.getText().toString();
//            Log.e("url",AppConstant.LOGIN);
//            //http://localhost:7080/slw/Login.php
            StringRequest stringRequest=new StringRequest(Request.Method.POST, AppConstant.LOGIN, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        JSONObject jsonObject=new JSONObject(response);
                        if (jsonObject.getString("status").equalsIgnoreCase("1"))
                        {
                            String id="";
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject object=jsonArray.getJSONObject(i);
                                id=object.getString("id");
                            }
                            Intent i=new Intent(LoginActivity.this,MainActivity.class);
                            i.putExtra("id",id);
                            startActivity(i);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Log.e("ERror",error.toString());
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String,String> stringMap=new HashMap<>();
                    stringMap.put("username",email);
                    stringMap.put("password",password);
                    return stringMap;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(stringRequest);*/
        }
        if (v==btnRegister)
        {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }
}
