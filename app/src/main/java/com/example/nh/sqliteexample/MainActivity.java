package com.example.nh.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Store s = new Store(3,"store3","description3");
        DatabaseHelper helper = new DatabaseHelper(this);
        //helper.addStore(s);
        ArrayList<Store> stores = helper.getAllStores();
        Log.e("size",stores.size()+"");
        for (int i = 0;i<stores.size();i++){
            Log.e("store data",stores.get(i).getName());
        }
    }
}
