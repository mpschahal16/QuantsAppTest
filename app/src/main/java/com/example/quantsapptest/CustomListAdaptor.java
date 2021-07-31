package com.example.quantsapptest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListAdaptor extends ArrayAdapter<Symbol> {

    public CustomListAdaptor(@NonNull Context context, ArrayList<Symbol> display_list) {
        super(context,0,display_list);
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Symbol symbol= getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_box,parent,false);
        }

        TextView symname_tv = (TextView) convertView.findViewById(R.id.name_tv);
        TextView price_change_tv = (TextView) convertView.findViewById(R.id.price_chage_tv);

        symname_tv.setText(symbol.getSymbolName());
        price_change_tv.setText(String.valueOf(symbol.getPrice_change()));

        return convertView;
    }
}
