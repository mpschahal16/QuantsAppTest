package com.example.quantsapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CpuUsageInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private String data_source_filename = "datafile.json";
    private ArrayList<Symbol> allArraylist;
    private ArrayList<Symbol> arrayList_s;
    private  ArrayList<Symbol> arrayList_l;
    private ArrayList<Symbol> arrayList_sc;
    private  ArrayList<Symbol> arrayList_lu;

    private ArrayList<Symbol> display_arraylist;

    private Button all_button;
    private Button l_button;
    private Button s_button;
    private Button lu_button;
    private Button sc_button;

    private ListView listView;

    private CustomListAdaptor customListAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view1);
        all_button = findViewById(R.id.all_btn);
        l_button =findViewById(R.id.l_btn);
        s_button = findViewById(R.id.s_btn);
        lu_button = findViewById(R.id.lu_btn);
        sc_button = findViewById(R.id.sc_btn);

        loadData();
        display_arraylist = new ArrayList<Symbol>();
        display_arraylist.addAll(allArraylist);
        customListAdaptor = new CustomListAdaptor(this,display_arraylist);
        listView.setAdapter(customListAdaptor);
        customListAdaptor.notifyDataSetChanged();

        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_arraylist.clear();
                display_arraylist.addAll(allArraylist);
                customListAdaptor.notifyDataSetChanged();

            }
        });

        l_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_arraylist.clear();
                display_arraylist.addAll(arrayList_l);
                customListAdaptor.notifyDataSetChanged();

            }
        });

        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_arraylist.clear();
                display_arraylist.addAll(arrayList_s);
                customListAdaptor.notifyDataSetChanged();

            }
        });

        lu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_arraylist.clear();
                display_arraylist.addAll(arrayList_lu);
                customListAdaptor.notifyDataSetChanged();

            }
        });

        sc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_arraylist.clear();
                display_arraylist.addAll(arrayList_sc);
                customListAdaptor.notifyDataSetChanged();

            }
        });

    }

    private void loadData(){
        JsonUtil jsonUtil = new JsonUtil();
        String json_str =  jsonUtil.get_fromJson(getApplicationContext(),data_source_filename);

        Gson gson = new Gson();
        KeyValue keyValue = gson.fromJson(json_str, KeyValue.class);

        /*Log.d("mpschahal16",keyValue.getL());
        Log.d("mpschahal16",keyValue.getLu());
        Log.d("mpschahal16",keyValue.getS());
        Log.d("mpschahal16",keyValue.getSc());*/


        arrayList_l = jsonUtil.getSymbolList(keyValue.getL());
        arrayList_lu = jsonUtil.getSymbolList(keyValue.getLu());
        arrayList_s = jsonUtil.getSymbolList(keyValue.getS());
        arrayList_sc = jsonUtil.getSymbolList(keyValue.getSc());
        allArraylist = new ArrayList<Symbol>();
        allArraylist.addAll(arrayList_l);
        allArraylist.addAll(arrayList_lu);
        allArraylist.addAll(arrayList_s);
        allArraylist.addAll(arrayList_sc);

        //Log.d("Check Data","All Count"+allArraylist.size()+"Total :"+(arrayList_l.size()+arrayList_lu.size()+arrayList_s.size()+arrayList_sc.size()));
    }
}