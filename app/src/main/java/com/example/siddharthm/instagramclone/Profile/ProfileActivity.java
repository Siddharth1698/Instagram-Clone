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
import android.widget.ImageView;


import com.example.siddharthm.instagramclone.R;
import com.example.siddharthm.instagramclone.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {
    private Context mContext = ProfileActivity.this;
    private static int ACTIVITY_NUM = 4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setUpBottomNavigationView();
        setUpToolBar();
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
    private void setUpBottomNavigationView(){
        com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx bottomnavigationviewex = (com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomnavigationviewex);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomnavigationviewex);
        Menu menu = bottomnavigationviewex.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
}
