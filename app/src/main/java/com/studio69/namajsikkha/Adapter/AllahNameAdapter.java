package com.studio69.namajsikkha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studio69.namajsikkha.R;

public class AllahNameAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String[] nameList;
    String[] meaningList;
    String[] arbiList;

    public AllahNameAdapter(Context context, String[] nameList, String[] meaningList, String[] arbiList) {
        this.context = context;
        this.nameList = nameList;
        this.meaningList = meaningList;
        this.arbiList = arbiList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.allah_name_item, null);
            holder = new Holder();

            holder.txtViewName = view.findViewById(R.id.banglaNameId);
            holder.txtViewMeaning = view.findViewById(R.id.meaningNameId);
            holder.txtViewArbi = view.findViewById(R.id.arbiNameId);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

            holder.txtViewName.setText(nameList[position]);
            holder.txtViewMeaning.setText(meaningList[position]);
            holder.txtViewArbi.setText(arbiList[position]);


        return view;
    }
    public class Holder {
        TextView txtViewName;
        TextView txtViewMeaning;
        TextView txtViewArbi;
    }
}