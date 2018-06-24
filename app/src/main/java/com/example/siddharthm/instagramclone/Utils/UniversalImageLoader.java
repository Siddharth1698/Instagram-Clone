package com.example.siddharthm.instagramclone.Utils;

import android.content.Context;

import com.example.siddharthm.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.ic_android;
    private Context mContext;

    public UniversalImageLoader(Context Context) {
        mContext = Context;
    }
    public ImageLoaderConfiguration getConfig(){
        
    }
}
