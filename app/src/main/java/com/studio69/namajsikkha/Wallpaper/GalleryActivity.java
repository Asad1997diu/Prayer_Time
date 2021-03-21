package com.studio69.namajsikkha.Wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.studio69.namajsikkha.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GalleryActivity extends AppCompatActivity {
    List<CustomsItem> islamicItemList;
    RecyclerView recyclerView;
    RecyclerViewadapter romanticViewAdapter;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    AdRequest adRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        loadInterstitialAd();
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        islamicItemList=new ArrayList<>();
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-WdLSvpQaxNA/YFZMXsqu1oI/AAAAAAAABis/4-2vdOCYG6cjBIrMGoShMlZYDx9rIGJzwCLcBGAsYHQ/s1280/ramadan-ramadhan-night-religious.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-zoXTJSyBMHs/YFZMXoNe-PI/AAAAAAAABio/hp7BUWkmMakiJMIqXOFh_mIi8KwnPijaACLcBGAsYHQ/s1280/quran-ramadhan-ramadan-muslim-islamic-community.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-EqzBR5gFR7Q/YFZMXEP5d2I/AAAAAAAABik/wK8QfI91xYMwcvhar3gIrPtL6hDjsukmACLcBGAsYHQ/s1280/quran-faith-islamic-muslim.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-RrGctW3PN4k/YFZMWw2iHII/AAAAAAAABig/WGqxCdDgQ6YgHTggrVhezGPm7IezY85AACLcBGAsYHQ/s1280/mosques-great-mosque-of-mecca-building-city-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-3Yg7-Nv3StE/YFZMWpj4YEI/AAAAAAAABic/6OPebedk29AXm-B2lqb89tbqaaxgAUnKQCLcBGAsYHQ/s1280/mecca-mosque-muslim-kaaba.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-4EzeTQVQhJA/YFZMWFr2_9I/AAAAAAAABiY/rImjywhSAMwuLt8eRIL3sXbydls_8bz5wCLcBGAsYHQ/s1280/makkah-islam-allah.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-g2d2Cl5JlGs/YFZMVwDNz3I/AAAAAAAABiU/mUITp5JKzz8bHq33QZoh3WVnzB3-ebtVwCLcBGAsYHQ/s1280/islam-muslim-religion-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-tRHUBhBqCCs/YFZMVk7ZiaI/AAAAAAAABiQ/ICsqtLPmtAgLUpZZB8hqOfl7RN0TCV3qgCLcBGAsYHQ/s1280/islam-muslim-religion-wallpaper-preview%2B%25281%2529.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-WmWm3DI-LM4/YFZMVY48VaI/AAAAAAAABiM/ZjIZ0tE0EgEGKX5po4ExerexdsFzkt9qgCLcBGAsYHQ/s1280/house-of-allah-mecca-mosque-muslim-thumbnail.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-buFKQyfVTW8/YFZMVCN2xeI/AAAAAAAABiI/U70rJ9Ms-gQ9DNBCxVETnyhmqXr_crKzQCLcBGAsYHQ/s1280/holy-quran-ramadan-ramadhan-religious.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-BRj0iMneHXY/YFZMU8Xk8fI/AAAAAAAABiE/98jwxYGXR7I72o9wNY4_opTOYBuuuIK2wCLcBGAsYHQ/s1280/gold-black-corbon-allah-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-KuCwbGPlI50/YFZMUVj6BMI/AAAAAAAABiA/-XO56QP1c58Ad_ADl1yJXetCvvdfBbeRwCLcBGAsYHQ/s1280/god-lord-allah-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-rZMJUmYUUE8/YFZMT0X8f8I/AAAAAAAABh8/5q6WYHqZPnIstBijJhXxxwX9a028lvFkwCLcBGAsYHQ/s1280/god-lord-allah-wallpaper-preview%2B%25282%2529.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-S_5_4S7dSD0/YFZMTQUsobI/AAAAAAAABh0/8azM6kOY3_kfTAeiHkH3OZh-lEuEeNuAgCLcBGAsYHQ/s1280/allah-keep-calm-allah-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-AWkTmzKfWcY/YFZMReRqHWI/AAAAAAAABhc/aYhMyJE65kQ_v447K1Q_a2ds7FHEQUxvACLcBGAsYHQ/s1280/99-names-of-allah-white-and-black-allah-illustration-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-kitlynOY7Uc/YFZMRcfQtWI/AAAAAAAABhg/l0Ipm2k3sNYl6t5IsqFqXWXaictGBnYnwCLcBGAsYHQ/s1280/allah-arab-arabian-arabic-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-DI3srWd_x2E/YFZMRk3dOyI/AAAAAAAABhk/chgXHy0PM3QIohPYoF88UzdfRb-FmUFxACLcBGAsYHQ/s1280/allah-arabia-arabic-blessing-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-qVc08bVKsQ8/YFZMSVNHfHI/AAAAAAAABho/8oah9MQDzJMPgVDEN457dcImY4omHQAOgCLcBGAsYHQ/s1280/allah-c-c-god-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-269i-GHGX08/YFZMS72PFLI/AAAAAAAABhs/00urThg0Xy8JE_nH4krBAFIdiacUP8tDQCLcBGAsYHQ/s1280/allah-god-islam-entertainment-other-hd-art-wallpaper-preview.jpg"));
        islamicItemList.add(new CustomsItem("https://1.bp.blogspot.com/-z6wS-0nU1sk/YFZMTCkhh_I/AAAAAAAABhw/XYxvcxWsLH0h67tUhl005RbLZLSjbpZaACLcBGAsYHQ/s1280/allah-islamic-font-islam-wallpaper-preview.jpg"));



        Collections.shuffle(islamicItemList, new Random(3));

        romanticViewAdapter=new RecyclerViewadapter( islamicItemList,this);
        recyclerView.setAdapter(romanticViewAdapter);
    }
    private void loadInterstitialAd()
    {
        InterstitialAd.load(this,"ca-app-pub-6736964088321278/7236415433", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i("TAG", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i("TAG", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            if (mInterstitialAd!=null)
            {
                mInterstitialAd.show(GalleryActivity.this);
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.

                        finish();

                        Log.d("TAG", "The ad was dismissed.");
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }
            else
            {
                this.finish();

            }

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (mInterstitialAd!=null)
        {
            mInterstitialAd.show(GalleryActivity.this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when fullscreen content is dismissed.

                    finish();

                    Log.d("TAG", "The ad was dismissed.");
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when fullscreen content failed to show.
                    Log.d("TAG", "The ad failed to show.");
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when fullscreen content is shown.
                    // Make sure to set your reference to null so you don't
                    // show it a second time.
                    mInterstitialAd = null;
                    Log.d("TAG", "The ad was shown.");
                }
            });
        }
        else
        {
            this.finish();

        }

    }
}