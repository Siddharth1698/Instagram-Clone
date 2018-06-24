package com.example.siddharthm.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.siddharthm.instagramclone.R;

import java.util.ArrayList;

public class AccountSettingActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        mContext = AccountSettingActivity.this;
        setupSettingList();
        ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
     }

     private void setupSettingList(){
         ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

         ArrayList<String> options = new ArrayList<>();
         options.add(getString(R.string.edit_profile));
         options.add(getString(R.string.sign_out));

         ArrayAdapter adapter = new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,options);
         listView.setAdapter(adapter);
     }
}
