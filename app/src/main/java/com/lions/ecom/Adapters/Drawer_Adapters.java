package com.lions.ecom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lions.ecom.R;

import java.util.ArrayList;

/**
 * Created by Panwar on 17/07/17.
 */

public class Drawer_Adapters extends BaseAdapter {

    ArrayList<String> list = new ArrayList<String>();
    Context context;
    LayoutInflater inflater;
    public Drawer_Adapters(Context cont, ArrayList<String> data)
    {
        context = cont;
        list = data;
        inflater = (LayoutInflater)cont
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = inflater.inflate(R.layout.drawer_item,null,false);
        TextView item = (TextView)root.findViewById(R.id.drawer_item_text);
        item.setText(""+list.get(position));

        return root;
    }
}
