package com.studio69.namajsikkha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;
import com.studio69.namajsikkha.Kalima.KalimaActivity;
import com.studio69.namajsikkha.RamadanTime.RamadanTimeActivity;
import com.studio69.namajsikkha.Wallpaper.GalleryActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private AdView mAdView;
    AdRequest adRequest;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    AlertDialog.Builder alertDialogBuilder;
    Intent intent;
    Button tosbhiBtn;
    Button ramdanTimeBtn;
    Button kalimaBtn;
    Button alAsmaBtn;
    Button compassBtn;
    Button wallpaperbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);


        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //loadInterstitialAd();


        drawerLayout = findViewById(R.id.main_activity);
        navigationView = findViewById(R.id.navigation_id);

        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ramdanTimeBtn = findViewById(R.id.ramadanTimeid);
        kalimaBtn = findViewById(R.id.kalimaId);
        alAsmaBtn = findViewById(R.id.alasmaId);
        compassBtn = findViewById(R.id.compassBtnId);
        wallpaperbtn = findViewById(R.id.wallpaperBtnId);
        tosbhiBtn = findViewById(R.id.toshbihBtn);

        ramdanTimeBtn.setOnClickListener(this);
        kalimaBtn.setOnClickListener(this);
        alAsmaBtn.setOnClickListener(this);
        compassBtn.setOnClickListener(this);
        wallpaperbtn.setOnClickListener(this);
        tosbhiBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toshbihBtn) {
            startActivity(new Intent(MainActivity.this, TosbihActivity.class));
        }
        if (v.getId() == R.id.compassBtnId) {
            startActivity(new Intent(MainActivity.this, CompasActivity.class));
        }
        if (v.getId() == R.id.alasmaId) {
            startActivity(new Intent(MainActivity.this, AllahNameActivity.class));
        }
        if (v.getId() == R.id.kalimaId) {
            startActivity(new Intent(MainActivity.this, KalimaActivity.class));
        }
        if (v.getId() == R.id.ramadanTimeid) {
            startActivity(new Intent(MainActivity.this, RamadanTimeActivity.class));
        }
        if (v.getId() == R.id.wallpaperBtnId) {
            startActivity(new Intent(MainActivity.this, GalleryActivity.class));
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.rate_id) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
        }

        if (item.getItemId() == R.id.share_id) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Share";
            String body = "Best Romantic Wallpaper Wallpaper....\n http://play.google.com/store/apps/details?id=" + getPackageName();
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "Share with "));
        }

        if (item.getItemId() == R.id.feedback_id) {
            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("mailto:?subject=" + "Feedback about Romantic Wallpaper" + "&body=" + "body text " + "&to=" + "studio69.develop@gmail.com");
            mailIntent.setData(data);
            startActivity(Intent.createChooser(mailIntent, "Send mail..."));
        }

        if (item.getItemId() == R.id.support_id) {
            alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage(R.string.support_developer);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialogBuilder.setCancelable(true);
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        if (item.getItemId() == R.id.privacy_id) {
            Uri uri = Uri.parse("https://studio69itsolution.blogspot.com/2021/02/romantic-wallpaper-2021.html"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.about_id) {
            alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("About");
            alertDialogBuilder.setMessage(R.string.about);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialogBuilder.setCancelable(true);
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*  private void loadInterstitialAd()
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
  */
    @Override
    public void onBackPressed() {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Alert!");
        alertDialogBuilder.setMessage("Are You Want To Exit?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }


}