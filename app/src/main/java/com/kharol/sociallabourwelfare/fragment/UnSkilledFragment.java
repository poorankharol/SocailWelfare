package com.kharol.sociallabourwelfare.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.VolleyError;
import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.Service.RequestGenerator;
import com.kharol.sociallabourwelfare.Service.ResponseListener;
import com.kharol.sociallabourwelfare.adapter.UnskilledAdapter;
import com.kharol.sociallabourwelfare.helper.AppConstant;
import com.kharol.sociallabourwelfare.model.UnSkilledModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class UnSkilledFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<UnSkilledModel> unSkilledModels=new ArrayList<>();
    public UnSkilledFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_unskilled, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        getData();
        return view;
}

    private void getData()
    {
        RequestGenerator.makeGetRequest(getActivity(), AppConstant.UNSKILLED, true, new ResponseListener() {
            @Override
            public void onError(VolleyError error) {

            }

            @Override
            public void onSuccess(String string) throws JSONException {
                JSONObject jsonObject=new JSONObject(string);
                if (jsonObject.getString("status").equalsIgnoreCase("1"))
                {
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    unSkilledModels.clear();
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject object=jsonArray.getJSONObject(i);
                        UnSkilledModel unSkilledModel=new UnSkilledModel();
                        unSkilledModel.setId(object.getString("id"));
                        unSkilledModel.setName(object.getString("Name"));
                        unSkilledModel.setPlace(object.getString("Place"));
                        unSkilledModel.setAge(object.getString("Age"));
                        unSkilledModel.setCategory((object.getString("category")));
                        unSkilledModels.add(unSkilledModel);
                    }
                    recyclerView.setAdapter(new UnskilledAdapter(getActivity(),unSkilledModels));
                }
            }
        });
    }
}



