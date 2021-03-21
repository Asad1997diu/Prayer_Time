package com.studio69.namajsikkha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TosbihActivity extends AppCompatActivity {
private TextView tosbhiCountTxt;
private TextView tosbhiTotalTxt;
private Button countBtn;
private Button resetBtn;
int count=0;
int countTotal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_tosbih);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tosbhiCountTxt=findViewById(R.id.tosbihStart);
        tosbhiTotalTxt=findViewById(R.id.totalId);
        countBtn=findViewById(R.id.countId);
        resetBtn=findViewById(R.id.resetId);

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countTotal++;
                if (count==34){
                    count=0;
                    tosbhiCountTxt.setText(String.valueOf(count));
                }
                else {
                    tosbhiCountTxt.setText(String.valueOf(count));
                }
                tosbhiTotalTxt.setText(String.valueOf(countTotal));
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                countTotal=0;
                tosbhiCountTxt.setText(String.valueOf(count));
                tosbhiTotalTxt.setText(String.valueOf(countTotal));
            }
        });

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
