package com.kharol.sociallabourwelfare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.model.HomeModel;
import com.kharol.sociallabourwelfare.model.UnSkilledModel;

import java.util.ArrayList;

public class UnskilledAdapter extends RecyclerView.Adapter<UnskilledAdapter.ViewHolder>
{
    Context context;
    ArrayList<UnSkilledModel> unSkilledModels=new ArrayList<>();

    public UnskilledAdapter(Context context, ArrayList<UnSkilledModel> unSkilledModels) {
        this.context = context;
        this.unSkilledModels= unSkilledModels;
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
        UnSkilledModel unSkilledModel=unSkilledModels.get(position);
        holder.name.setText(unSkilledModel.getName());
        holder.age.setText(unSkilledModel.getAge());
        holder.place.setText(unSkilledModel.getPlace());
        holder.category.setText(unSkilledModel.getCategory());
    }

    @Override
    public int getItemCount() {
        return unSkilledModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,place,age,category;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            category=itemView.findViewById(R.id.category);
            place=itemView.findViewById(R.id.place);
        }
    }
}
