package com.studio69.namajsikkha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.studio69.namajsikkha.Adapter.AllahNameAdapter;

public class AllahNameActivity extends AppCompatActivity {
    private ListView listView;
    private String[] nameList;
    private String[] meaningList;
    private String[] arbiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_allah_name);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nameList=getResources().getStringArray(R.array.names_spelling);
        meaningList=getResources().getStringArray(R.array.names_meaning);
        arbiList=getResources().getStringArray(R.array.names_arabic_word);

        listView=findViewById(R.id.listviewid);
        AllahNameAdapter adapter=new AllahNameAdapter(this, nameList, meaningList,arbiList);
        listView.setAdapter(adapter);


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
