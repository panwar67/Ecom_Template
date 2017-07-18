package com.lions.ecom.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lions.ecom.R;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sourabh on 18-07-2017.
 */
public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    ArrayList<String> listOfKeys = new ArrayList<String>();

    //Creating an ArrayList of values

    ArrayList<String> listOfValues = new ArrayList<String>();

    public MyListAdapter(Activity context, ArrayList<String> listOfKeys,ArrayList<String>listOfValues) {
        super(context, R.layout.activity_imagelist,listOfKeys);
        this.context=context;
        this.listOfKeys=listOfKeys;
        this.listOfValues=listOfValues;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.sample,null,true);
        TextView txtTitle=(TextView)rowview.findViewById(R.id.textView6);
        ImageView imageView=(ImageView)rowview.findViewById(R.id.imageView);

        txtTitle.setText(listOfKeys.get(position));
        imageView.setBackgroundColor(Color.parseColor(listOfValues.get(position)));

        return rowview;
    }
}
