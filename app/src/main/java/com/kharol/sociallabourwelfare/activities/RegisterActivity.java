package com.kharol.sociallabourwelfare.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.helper.AppConstant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_name,edt_email,edt_number,edt_password;
    Button Reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_name=findViewById(R.id.edt_name);
        edt_email=findViewById(R.id.edt_email);
        edt_number=findViewById(R.id.edt_number);
        edt_password=findViewById(R.id.edt_password);
        Reg=findViewById(R.id.btnRegister);
        Reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view==Reg)
        {
            final String name=edt_name.getText().toString();
            final String email=edt_email.getText().toString();
            final String number=edt_number.getText().toString();
            final String password=edt_password.getText().toString();
            if (name.equals("") || name.isEmpty())
            {
                Toast.makeText(this, "Enter name!!", Toast.LENGTH_SHORT).show();
            }
            else if (email.equals("") || email.isEmpty())
            {
                Toast.makeText(this, "Enter email!!", Toast.LENGTH_SHORT).show();
            }


            else if (password.equals("") || password.isEmpty())
            {
                Toast.makeText(this, "Enter password!!", Toast.LENGTH_SHORT).show();
            }
            else {
                StringRequest request=new StringRequest(Request.Method.POST, AppConstant.REGISTER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jsonObject=new JSONObject(response);
                            if (jsonObject.getString("status").equals("1"))
                            {
                                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(i);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> stringMap=new HashMap<>();
                        stringMap.put("name",name);
                        stringMap.put("email",email);
                        stringMap.put("number", number);
                        stringMap.put("password",password);
                        return stringMap;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(request);
            }

        }
    }
}
