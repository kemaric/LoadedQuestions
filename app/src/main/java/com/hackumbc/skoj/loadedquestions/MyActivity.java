package com.hackumbc.skoj.loadedquestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.List;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.PagerTabStrip;
import android.widget.Toast;


public class MyActivity extends FragmentActivity {
    private List<android.support.v4.app.Fragment> fragments;
    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    /**
     * This is the ViewPager that will hold the app's content.
     */
    ViewPager mainViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        //getting the viewpage in the main_view.xml
        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        //setting the ViewPagerAdapter into ViewPager
        Toast.makeText(getApplicationContext(),"Starting the app!",Toast.LENGTH_SHORT);

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        //Creating the adapter that will return a fragment for each of the selections
        //of the app.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
