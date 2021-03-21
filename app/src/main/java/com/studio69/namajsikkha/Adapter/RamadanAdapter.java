package com.studio69.namajsikkha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.studio69.namajsikkha.R;
import com.studio69.namajsikkha.RamadanTime.RamadanTimeActivity;

public class RamadanAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    private String[] number;
    private String[] bar;
    private String[] date;
    private String[] iftar;
    private String[] sahari;

    public RamadanAdapter(Context context, String[] number, String[] bar, String[] date, String[] iftar, String[] sahari) {
        this.context = context;
        this.number = number;
        this.bar = bar;
        this.date = date;
        this.iftar = iftar;
        this.sahari = sahari;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public RamadanAdapter() {
    }

    @Override
    public int getCount() {
        return number.length;
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
            view = layoutInflater.inflate(R.layout.ramdan_time_item, null);
            holder = new Holder();

            holder.txtViewNumber = view.findViewById(R.id.numberTxtId);
            holder.txtViewBar = view.findViewById(R.id.barId);
            holder.txtViewDate = view.findViewById(R.id.dateId);
            holder.txtViewIftar = view.findViewById(R.id.iftarId);
            holder.txtViewSahari = view.findViewById(R.id.sahariId);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.txtViewNumber.setText(number[position]);
        holder.txtViewBar.setText(bar[position]);
        holder.txtViewDate.setText(date[position]);
        holder.txtViewIftar.setText(iftar[position]);
        holder.txtViewSahari.setText(sahari[position]);


        return view;
    }
    public class Holder {
        TextView txtViewNumber;
        TextView txtViewBar;
        TextView txtViewDate;
        TextView txtViewIftar;
        TextView txtViewSahari;
    }
}
