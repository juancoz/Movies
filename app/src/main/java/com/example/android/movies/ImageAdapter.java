package com.example.android.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Juan Carlos on 16/03/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mImageString;
    private String[] mResults;
    private boolean mFlag;

    public ImageAdapter(Context c) {
        mContext = c;
        mFlag = false;
    }

    public ImageAdapter(Context c, String[] images, String[] results) {
        mContext = c;
        mImageString = images;
        mResults = results;
        mFlag = true;
    }

    public int getCount() {
        if (mFlag) {
            return mImageString.length;
        } else {
            return mThumbIds.length;
        }
    }

    public String getItem(int position) {
        String resultItem;

        if (mResults != null) {
            resultItem = mResults[position];
            return resultItem;
        } else {
            return null;
        }
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item_forecast, parent, false);
        }

        imageView = (ImageView) convertView.findViewById(R.id.grid_item_forecast_imageview);
        // imageView.setImageResource(mThumbIds[position]);
        if (mFlag) {
            Glide.with(imageView.getContext()).load(mImageString[position]).into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(mThumbIds[position]).into(imageView);
        }
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.alvin, R.drawable.beauty,
            R.drawable.contraband, R.drawable.grey,
            R.drawable.hungry, R.drawable.journey,
            R.drawable.man, R.drawable.mission,
            R.drawable.underworld
    };
}
