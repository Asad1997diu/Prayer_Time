package com.studio69.namajsikkha.Wallpaper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class SaveImageHelper implements Target {
    private Context context;
    private WeakReference<ContentResolver> contentResolverWeakReference;
    private  String name;
    private String description;

    public SaveImageHelper(Context context, ContentResolver contentResolver, String name, String description) {
        this.context = context;
        this.contentResolverWeakReference = new WeakReference<ContentResolver> (contentResolver);
        this.name = name;
        this.description = description;
    }


    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        ContentResolver r = contentResolverWeakReference.get();
        if (r != null)
        {
            MediaStore.Images.Media.insertImage(r,bitmap,name,description);
            Toast.makeText(context, "Successfully Download", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
