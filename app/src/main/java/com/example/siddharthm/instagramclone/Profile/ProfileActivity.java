package com.example.siddharthm.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.example.siddharthm.instagramclone.R;
import com.example.siddharthm.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.siddharthm.instagramclone.Utils.GridImageAdapter;
import com.example.siddharthm.instagramclone.Utils.UniversalImageLoader;

import java.security.PrivateKey;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private Context mContext = ProfileActivity.this;
    private static int ACTIVITY_NUM = 4;
    private ImageView profilePhoto;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setUpBottomNavigationView();
        setUpToolBar();
        setUpActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://cdn-images-1.medium.com/max/1920/1*t5T-_2LFfq4lz-GJ4bSoMg.jpeg");
        imgURLs.add("https://blogs-images.forbes.com/erikkain/files/2017/10/ACO_CurseofPharaoh_Thebes_ScorpionFight_1507597412.jpg");
        imgURLs.add("https://humblebundle.imgix.net/misc/files/hashed/7ddda6d50427793a211315615ce16a825efa99aa.jpg");
        imgURLs.add("http://cdn-static.denofgeek.com/sites/denofgeek/files/styles/main_wide/public/2016/12/201652010120_1.jpg");
        imgURLs.add("https://is5-ssl.mzstatic.com/image/thumb/Purple71/v4/e4/f6/5c/e4f65c0d-6d2c-df96-fc18-9fdbf081a06b/screenshot_en-US_5_iOS-5.5-in.jpeg/643x0w.jpg");
        imgURLs.add("http://media.comicbook.com/2018/03/asscreed-1094295.jpeg");
        imgURLs.add("https://blogs-images.forbes.com/erikkain/files/2017/10/ACO_CurseofPharaoh_Thebes_ScorpionFight_1507597412.jpg");
        imgURLs.add("http://www.godisageek.com/wp-content/uploads/AC-Origins-Pharoahs.jpg");
        imgURLs.add("https://media.wired.com/photos/59327646a3126458449951be/master/w_860,c_limit/acr_1.jpg");
        setImageGrid(imgURLs);

    }

    private void setUpToolBar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView)findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView)findViewById(R.id.gridView);
        GridImageAdapter adapter = new GridImageAdapter(mContext,R.layout.layout_grid_image_view,"",imgURLs);
        gridView.setAdapter(adapter);

    }

    private void setProfileImage(){

        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "https://");

    }

    private void setUpActivityWidgets(){
        mProgressBar = (ProgressBar)findViewById(R.id.profile_progress_bar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView)findViewById(R.id.profile_photo);

    }
    private void setUpBottomNavigationView(){
        com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx bottomnavigationviewex = (com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomnavigationviewex);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomnavigationviewex);
        Menu menu = bottomnavigationviewex.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
}
