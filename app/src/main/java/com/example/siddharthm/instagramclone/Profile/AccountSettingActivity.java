package com.example.siddharthm.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.siddharthm.instagramclone.R;
import com.example.siddharthm.instagramclone.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingActivity extends AppCompatActivity {

    private Context mContext;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLaoyout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        mContext = AccountSettingActivity.this;
        setupSettingList();
        setupFragments();
        mViewPager = (ViewPager)findViewById(R.id.container);
        mRelativeLaoyout = (RelativeLayout)findViewById(R.id.relLayout1);
        ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
     }
     private void setViewPager(int fragmentNumber){
        mRelativeLaoyout.setVisibility(View.GONE);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
     }


     private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile_fragment));
         pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out_fragment));



     }
     private void setupSettingList(){
         ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

         ArrayList<String> options = new ArrayList<>();
         options.add(getString(R.string.edit_profile_fragment));
         options.add(getString(R.string.sign_out_fragment));

         ArrayAdapter adapter = new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,options);
         listView.setAdapter(adapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 setViewPager(position);
             }
         });
     }
}
