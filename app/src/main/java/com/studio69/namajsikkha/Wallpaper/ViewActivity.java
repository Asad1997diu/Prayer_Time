package com.studio69.namajsikkha.Wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.squareup.picasso.Picasso;
import com.studio69.namajsikkha.BuildConfig;
import com.studio69.namajsikkha.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    AdRequest adRequest;
    ImageView full_imageview;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton btn_set, btn_share, btn_download, fabFavorite;
    private static final int PERMISSION_REQUEST_CODE = 1000;

    private final String TAG = ViewActivity.class.getSimpleName();



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)

                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();

                else

                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

                break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        loadInterstitialAd();//interstitial ad loading method


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]
                        {
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        }, PERMISSION_REQUEST_CODE);
            }

        full_imageview = findViewById(R.id.full_image_id);
        floatingActionMenu = findViewById(R.id.floating_action_menu);
        btn_set = findViewById(R.id.floating_button_set);
        btn_share = findViewById(R.id.floating_button_share);
        btn_download = findViewById(R.id.floating_button_download);

        btn_download.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_set.setOnClickListener(this);


        Glide.with(this).load(getIntent().getStringExtra("images")).diskCacheStrategy(DiskCacheStrategy.ALL).into(full_imageview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floating_button_set:
                setBackground();
                floatingActionMenu.close(true);
                break;
            case R.id.floating_button_share:
                shareImage();
                //Toast.makeText(this, "Share Wallpaper", Toast.LENGTH_SHORT).show();
                floatingActionMenu.close(true);
                break;
            case R.id.floating_button_download:
                saveImage();
                //Toast.makeText(this, "Download Wallpaper", Toast.LENGTH_SHORT).show();
                floatingActionMenu.close(true);
                break;

        }

    }

    private void shareImage() {

        Bitmap bitmap = getBitmapFromView(full_imageview);

        try {
            File file = new File(this.getExternalCacheDir(), "opwallpaper.png");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            file.setReadable(true, false);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(ViewActivity.this, BuildConfig.APPLICATION_ID + ".provider", file));
            intent.setType("image/*");
            startActivity(Intent.createChooser(intent, "Share Image Via"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private Bitmap getBitmapFromView(View view) {
        Bitmap returnBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnBitmap);
        Drawable bgDrawable = view.getBackground();

        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnBitmap;

    }

    private void setBackground() {

        Bitmap bitmap = ((BitmapDrawable) full_imageview.getDrawable()).getBitmap();
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "Successfully Wallpaper Set", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveImage() {

        if (ActivityCompat.checkSelfPermission(ViewActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "You should grant permission", Toast.LENGTH_SHORT).show();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

            }


        } else {

            String fileName = UUID.randomUUID().toString() + ".jpg";
            Picasso.get().load(getIntent().getStringExtra("images")).into(new SaveImageHelper(getBaseContext(),
                    getApplicationContext().getContentResolver(), fileName, "Image Description"));


        }
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

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            if (mInterstitialAd!=null)
            {
                mInterstitialAd.show(ViewActivity.this);
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
            mInterstitialAd.show(ViewActivity.this);
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
