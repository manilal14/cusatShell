package com.example.mani.shell;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {


    ArrayList<Fragment> mFragmentList;
    boolean mSearchVisiblity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        mFragmentList = new ArrayList<>();
        //Getting rid of shadow
        getSupportActionBar().setElevation(0);

        //mFragmentList.add(new FragmentRooms());
        mFragmentList.add(new FragmentOlx());
        mFragmentList.add(new FragmentOpportunities());
        mFragmentList.add(new FragmentFeeds());

        ViewPager viewPager = findViewById(R.id.viewpager_homepage);
        HomePageFragmentPagerAdapter adapter = new HomePageFragmentPagerAdapter(
                getSupportFragmentManager(),mFragmentList);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Set icon for room
        //tabLayout.getTabAt(0).setIcon(R.drawable.ic_bed);

        ImageView back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().show();
                findViewById(R.id.tab_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.search_layout_home_page).setVisibility(View.GONE);
                EditText et = findViewById(R.id.search_et_home_page);
                et.setText("");
                mSearchVisiblity = false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.menu_refresh :

                break;

            case R.id.menu_search :
                getSupportActionBar().hide();
                findViewById(R.id.tab_layout).setVisibility(View.GONE);
                findViewById(R.id.search_layout_home_page).setVisibility(View.VISIBLE);
                mSearchVisiblity = true;
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mSearchVisiblity){
            getSupportActionBar().show();
            findViewById(R.id.tab_layout).setVisibility(View.VISIBLE);
            findViewById(R.id.search_layout_home_page).setVisibility(View.GONE);
            EditText et = findViewById(R.id.search_et_home_page);
            et.setText("");
            mSearchVisiblity = false;
        }
        else {
            finish();
        }
    }
}
