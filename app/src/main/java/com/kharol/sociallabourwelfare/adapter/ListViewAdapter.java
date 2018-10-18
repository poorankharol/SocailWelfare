package com.kharol.sociallabourwelfare.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kharol.sociallabourwelfare.R;
import com.kharol.sociallabourwelfare.activities.SingleItemView;
import com.kharol.sociallabourwelfare.model.ListModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<ListModel> worldlist = null;
    private ArrayList<ListModel> arraylist;

    public ListViewAdapter(Context context, List<ListModel> worldlist) {
        mContext = context;
        this.worldlist = worldlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ListModel>();
        this.arraylist.addAll(worldlist);
    }

    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView place;
    }

    public int getCount() {
        return worldlist.size();
    }
    public ListModel getItem(int position) {
        return worldlist.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.name);
            holder.country = (TextView) view.findViewById(R.id.category);
            holder.place = (TextView) view.findViewById(R.id.place);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.rank.setText(worldlist.get(position).getName());
        holder.country.setText(worldlist.get(position).getCategory());
        holder.place.setText(worldlist.get(position).getPlace());

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("name",(worldlist.get(position).getName()));
                // Pass all data country
                intent.putExtra("category",(worldlist.get(position).getCategory()));
                // Pass all data population
                intent.putExtra("place",(worldlist.get(position).getPlace()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldlist.clear();
        if (charText.length() == 0) {
            worldlist.addAll(arraylist);
        }
        else
        {
            for (ListModel wp : arraylist)
            {
                if (wp.getCategory().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    worldlist.add(wp);
                }
            }
        }notifyDataSetChanged();
    }

}

