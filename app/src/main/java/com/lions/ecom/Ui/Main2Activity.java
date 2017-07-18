package com.lions.ecom.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.lions.ecom.Adapters.MyListAdapter;
import com.lions.ecom.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {
ListView listView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    HashMap<String, String> hashMap = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // listView=(ListView)findViewById(R.id.listView2);
        hashMap.put("Red","#ff0000");
        hashMap.put("Blue","#0083FF");
        hashMap.put("Pink","#E000FF");
        Set<String> keySet = hashMap.keySet();

        //Creating an ArrayList of keys

        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collection<String> values = hashMap.values();

        //Creating an ArrayList of values

        ArrayList<String> listOfValues = new ArrayList<String>(values);
       // MyListAdapter adapter= new MyListAdapter(this,listOfKeys,listOfValues);
       // listView.setAdapter(adapter);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MainAdapter(listOfKeys,listOfValues);
        recyclerView.setAdapter(adapter);



    }
}
