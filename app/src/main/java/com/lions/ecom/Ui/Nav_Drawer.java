package com.lions.ecom.Ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.lions.ecom.Adapters.Drawer_Adapters;
import com.lions.ecom.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nav_Drawer extends AppCompatActivity
         {

    ViewFlipper viewFlipper;
    ListView Main_Cat, Sub_Cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__drawer);
        final HashMap<String,ArrayList<String>> sub_list_container = new HashMap<String, ArrayList<String>>();
        ArrayList<String> main_list = new ArrayList<String>();
        for(int i =0;i<8;i++)
        {
            ArrayList<String> temp = new ArrayList<String>();
            main_list.add(" Main Options "+i+"");

            for(int j=0;j<8;j++)
            {
                temp.add("Sub Options "+j+"");
            }


            sub_list_container.put(""+i,temp);
        }
        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
        Main_Cat = (ListView)findViewById(R.id.main_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);

        Main_Cat.setAdapter(new Drawer_Adapters(getApplicationContext(),main_list));
        Main_Cat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                viewFlipper.showNext();
                View root = viewFlipper.getCurrentView();
                Sub_Cat = (ListView)root.findViewById(R.id.sub_cat);
                ImageView back = (ImageView)root.findViewById(R.id.back_drawer);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        viewFlipper.showNext();
                    }
                });
                Sub_Cat.setAdapter(new Drawer_Adapters(getApplicationContext(),sub_list_container.get(position)));
                Sub_Cat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Sub_Cat.getAdapter().getItem(position);
                        Sub_Cat.getItemAtPosition(position);

                    }
                });

            }
        });




    }

    public void Init_Lists()
    {


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav__drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
