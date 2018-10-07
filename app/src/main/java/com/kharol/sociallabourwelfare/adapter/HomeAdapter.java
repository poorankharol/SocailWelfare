package com.kharol.sociallabourwelfare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.model.HomeModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    Context context;
    ArrayList<HomeModel> homeModels=new ArrayList<>();

    public HomeAdapter(Context context, ArrayList<HomeModel> homeModels) {
        this.context = context;
        this.homeModels = homeModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        HomeModel homeModel=homeModels.get(position);
        holder.name.setText(homeModel.getName());
        holder.place.setText(homeModel.getPlace());
        holder.address.setText(homeModel.getAddress());
    }

    @Override
    public int getItemCount() {
        return homeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,place,address;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            place=itemView.findViewById(R.id.place);
            address=itemView.findViewById(R.id.address);
        }
    }
}
