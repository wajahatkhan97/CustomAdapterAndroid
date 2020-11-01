package com.example.project2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class listview extends ListActivity {
    private ListView listview;
    private String[] string_name;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        listview = getListView();
        this.position = intent.getIntExtra("dealer_position",0);
        if(position==0) {
            string_name = getResources().getStringArray(R.array.kia_dealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }

        if(position==1) {
            string_name = getResources().getStringArray(R.array.nissandealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }

        if(position==2) {
            string_name = getResources().getStringArray(R.array.BMWdealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }

        if(position==3) {
            string_name = getResources().getStringArray(R.array.HondaDealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }

        if(position==4) {
            string_name = getResources().getStringArray(R.array.Chevydealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }

        if(position==5) {
            string_name = getResources().getStringArray(R.array.maseratidealers); //here you have to make sure for the appropiate dealer name and address
            Log.i("name",string_name[2]);
            ArrayAdapter<String> madapter= new ArrayAdapter<>(this,R.layout.listview,string_name);
            setListAdapter(madapter);
        }


    }
}
