package com.studio69.namajsikkha.Kalima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.studio69.namajsikkha.Adapter.ViewPagerAdapter;
import com.studio69.namajsikkha.Model.Kalima;
import com.studio69.namajsikkha.R;
import com.studio69.namajsikkha.Resources.KalimaRes;

import java.util.ArrayList;

public class KalimaActivity extends AppCompatActivity {
private ViewPager mViewPager;
private TabLayout mTablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalima);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mViewPager=findViewById(R.id.viewpager_id);
        mTablayout=findViewById(R.id.tabLayout);
        
        init();
    }

    private void init() {

        ArrayList<Fragment> fragments=new ArrayList<>();
        Kalima[] kalimas= KalimaRes.getKalimas();
        for (Kalima kalima:kalimas){
            ViewPagerItemFragment fragment=ViewPagerItemFragment.getInstance(kalima);
            fragments.add(fragment);
        }
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(pagerAdapter);
        mTablayout.setupWithViewPager(mViewPager,true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}