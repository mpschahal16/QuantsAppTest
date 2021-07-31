package com.example.quantsapptest;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonUtil {

    public String get_fromJson(Context context,String json_file_name){

        String json_string;
        try {
            InputStream inputStream = context.getAssets().open(json_file_name);
            int l =inputStream.available();
            byte[] buff = new byte[l];
            inputStream.read(buff);
            inputStream.close();
            json_string=new String(buff,"UTF-8");

            return json_string;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Symbol> getSymbolList(String st){
        ArrayList<Symbol> return_list = new ArrayList<>();

        String[] arrayList=st.split(";");
        for (String temp:arrayList){
            String[] sec_list= new String[5];
            sec_list=temp.split(",");
            Symbol s = new Symbol();
            s.setSymbolName(sec_list[0]);
            s.setPrice(Double.parseDouble(sec_list[1]));
            s.setOpen_interest(Double.parseDouble(sec_list[2]));
            s.setPrice_change(Double.parseDouble(sec_list[3]));
            s.setOpen_interest_change(Double.parseDouble(sec_list[4]));
            return_list.add(s);


        }
        return  return_list;
    }

}
