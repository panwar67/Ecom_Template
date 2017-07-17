package com.lions.ecom;

import android.widget.ListAdapter;

/*
 * List item containing a vertically scrollable ListView
 */
public class VerticalScrollableItem {

    private ListAdapter adapter;

    // Initialize it with the ListAdapter necessary to populate and drive the vertical ListView
    // contained by this item
    public VerticalScrollableItem() {

    }

    public ListAdapter getAdapter() {
        return adapter;
    }

    public  String PATH;

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }


}