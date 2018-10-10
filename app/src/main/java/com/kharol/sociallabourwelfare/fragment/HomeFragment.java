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
import com.kharol.sociallabourwelfare.adapter.HomeAdapter;
import com.kharol.sociallabourwelfare.helper.AppConstant;
import com.kharol.sociallabourwelfare.model.HomeModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<HomeModel> homeModels=new ArrayList<>();
    public HomeFragment() {
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        getData();
        return view;
    }

    private void getData()
    {
        RequestGenerator.makeGetRequest(getActivity(), AppConstant.HOME, true, new ResponseListener() {
            @Override
            public void onError(VolleyError error) {

            }

            @Override
            public void onSuccess(String string) throws JSONException {
                JSONObject jsonObject=new JSONObject(string);
                if (jsonObject.getString("status").equalsIgnoreCase("1"))
                {
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    homeModels.clear();
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject object=jsonArray.getJSONObject(i);
                        HomeModel homeModel=new HomeModel();
                        homeModel.setId(object.getString("id"));
                        homeModel.setName(object.getString("Name"));
                        homeModel.setPlace(object.getString("Place"));
                        homeModel.setAddress(object.getString("Address"));
                        homeModels.add(homeModel);
                    }
                    recyclerView.setAdapter(new HomeAdapter(getActivity(),homeModels));
                }
            }
        });
    }


}
