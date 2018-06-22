package com.example.siddharthm.instagramclone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.siddharthm.instagramclone.Utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity {
    private Context mContext = HomeActivity.this;
    private static int ACTIVITY_NUM = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpBottomNavigationView();
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
