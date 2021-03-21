package com.studio69.namajsikkha.Kalima;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.studio69.namajsikkha.Model.Kalima;
import com.studio69.namajsikkha.R;

public class ViewPagerItemFragment extends Fragment {
private TextView title;
private TextView kalimaArbi;
private TextView kalimaSpell;
private TextView kalimaMean;
private Kalima mKalima;

public static  ViewPagerItemFragment getInstance(Kalima kalima){
    ViewPagerItemFragment fragment=new ViewPagerItemFragment();
    if (kalima!=null){
        Bundle bundle=new Bundle();
        bundle.putParcelable("kalima",kalima);
        fragment.setArguments(bundle);
    }
    return fragment;
}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mKalima=getArguments().getParcelable("kalima");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmnt_viewpager_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        title=view.findViewById(R.id.kalimaTitle);
        kalimaArbi=view.findViewById(R.id.kalimaArbi);
        kalimaSpell=view.findViewById(R.id.kalimaSpell);
        kalimaMean=view.findViewById(R.id.kalimaMean);
        init();

    }
    private void init(){
    if (mKalima!=null){

        title.setText(mKalima.getTitle());
        kalimaArbi.setText(mKalima.getKalimaArbi());
        kalimaSpell.setText(mKalima.getKalimaSpell());
        kalimaMean.setText(mKalima.getKalimaMean());
    }

    }
}
