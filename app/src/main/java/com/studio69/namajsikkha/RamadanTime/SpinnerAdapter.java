package com.studio69.namajsikkha.RamadanTime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio69.namajsikkha.R;

public class SpinnerAdapter extends BaseAdapter {

    private String[] cityName;
    Context context;
    LayoutInflater layoutInflater;

    public SpinnerAdapter(String[] cityName, Context context) {
        this.cityName = cityName;
        this.context = context;
    }

    public SpinnerAdapter() {
    }
    @Override
    public int getCount() {

        return cityName.length;
    }

    @Override
    public Object getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.spiner_item,null,false);
        }

        TextView city=view.findViewById(R.id.spinerTxtId);
        city.setText(cityName[i]);


        return view;
    }
}
