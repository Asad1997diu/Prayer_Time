package com.studio69.namajsikkha.RamadanTime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.studio69.namajsikkha.Adapter.AllahNameAdapter;
import com.studio69.namajsikkha.Adapter.RamadanAdapter;
import com.studio69.namajsikkha.R;

public class RamadanTimeActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner spinner;
    private String[] cityName;
    private String[] date;
    private String[] number;
    private String[] barishalIftar;
    private String[] barishalSahari;
    private String[] dhakaIftar;
    private String[] dhakaSahari;
    private String[] chittagongIftar;
    private String[] chittaGongSahari;
    private String[] khulnaIftar;
    private String[] khulnaSahari;
    private String[] rajshahiIftar;
    private String[] rajshahiSahari;
    private String[] sylhetIftar;
    private String[] sylhetSahari;
    private String[] mymensinghIftar;
    private String[] mymensinghSahari;
    private String[] rangpurIftar;
    private String[] rangpurSahari;
    private String[] bar;
    private boolean firstclick = true;
    RamadanAdapter ramadanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan_time);

        cityName = getResources().getStringArray(R.array.city_name);
        date = getResources().getStringArray(R.array.date_bangla);
        number = getResources().getStringArray(R.array.number);
        barishalIftar = getResources().getStringArray(R.array.barishalIftar);
        barishalSahari = getResources().getStringArray(R.array.barishalSahari);
        dhakaIftar = getResources().getStringArray(R.array.dhakaIftar);
        dhakaSahari = getResources().getStringArray(R.array.dhakaSahari);
        chittagongIftar = getResources().getStringArray(R.array.chittagongIftar);
        chittaGongSahari = getResources().getStringArray(R.array.chittagongSahari);
        khulnaIftar = getResources().getStringArray(R.array.khulnaIftar);
        khulnaSahari = getResources().getStringArray(R.array.khulnaSahari);
        rajshahiIftar = getResources().getStringArray(R.array.rajshahiIftar);
        rajshahiSahari = getResources().getStringArray(R.array.rajshahiSahari);
        sylhetIftar = getResources().getStringArray(R.array.sylhetIftar);
        sylhetSahari = getResources().getStringArray(R.array.sylhetSahari);
        mymensinghIftar = getResources().getStringArray(R.array.mymensignIftar);
        mymensinghSahari = getResources().getStringArray(R.array.mymensinghSahari);
        rangpurIftar = getResources().getStringArray(R.array.rangpurIftar);
        rangpurSahari = getResources().getStringArray(R.array.rangpurSahari);
        bar = getResources().getStringArray(R.array.bar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        spinner = findViewById(R.id.spinnerid);
        SpinnerAdapter adapter = new SpinnerAdapter(cityName, this);
        spinner.setAdapter(adapter);


        listView = findViewById(R.id.ramdanListviewId);
        ramadanAdapter = new RamadanAdapter(this, number, bar, date, dhakaIftar, dhakaSahari);
        listView.setAdapter(ramadanAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (firstclick == true) {
                    firstclick = false;
                } else {

                    if (adapterView.getSelectedItemPosition() == 0) {
                        Toast.makeText(RamadanTimeActivity.this, "0", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, dhakaIftar, dhakaSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 1) {
                        Toast.makeText(RamadanTimeActivity.this, "1", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, chittagongIftar, chittaGongSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 2) {
                        Toast.makeText(RamadanTimeActivity.this, "2", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, khulnaIftar, khulnaSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 3) {
                        Toast.makeText(RamadanTimeActivity.this, "3", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, rajshahiIftar, rajshahiSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 4) {
                        Toast.makeText(RamadanTimeActivity.this, "4", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, sylhetIftar, sylhetSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 5) {
                        Toast.makeText(RamadanTimeActivity.this, "5", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, barishalIftar, barishalSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 6) {
                        Toast.makeText(RamadanTimeActivity.this, "6", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, mymensinghIftar, mymensinghSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                    if (adapterView.getSelectedItemPosition() == 7) {
                        Toast.makeText(RamadanTimeActivity.this, "7", Toast.LENGTH_SHORT).show();
                        ramadanAdapter = new RamadanAdapter(getApplicationContext(), number, bar, date, rangpurIftar, rangpurSahari);
                        listView.setAdapter(ramadanAdapter);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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