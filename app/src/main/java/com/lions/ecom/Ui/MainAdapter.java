package com.lions.ecom.Ui;

import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lions.ecom.R;

import java.util.ArrayList;

/**
 * Created by Sourabh on 18-07-2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<String> listOfKeys = new ArrayList<String>();

    //Creating an ArrayList of values

    ArrayList<String> listOfValues = new ArrayList<String>();

    public MainAdapter(ArrayList<String> listOfKeys,ArrayList<String> listOfValues) {
        this.listOfKeys=listOfKeys;
        this.listOfValues=listOfValues;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sample,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
holder.textView.setText(listOfKeys.get(position));
        holder.imageView.setBackgroundColor(Color.parseColor(listOfValues.get(position)));
    }

    @Override
    public int getItemCount() {
        return listOfKeys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView6);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);

        }
    }
}
