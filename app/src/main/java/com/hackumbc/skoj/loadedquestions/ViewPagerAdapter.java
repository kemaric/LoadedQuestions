package com.hackumbc.skoj.loadedquestions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;

/**
 * Created by Owner on 9/22/2014.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    // Tab Titles
    private String tabtitles[] = new String[] { "Profile", "Requests", "Current Games" ,"Questions",
    "Create Game"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open FragmentTab1.java
            case 0:
                ProfileTab profileTab = new ProfileTab();
                return profileTab;
            case 1:
                GameRequestsFragment gameRequestTab = new GameRequestsFragment();
                return gameRequestTab;
            case 2:
                CurrentGamesFragment currGameTab = new CurrentGamesFragment();
                return currGameTab;

            case 3:
                QuestionsFrag questionTab = new QuestionsFrag();
                return questionTab;
            case 4:
                CreateGameFragment createTab = new CreateGameFragment();
                return  createTab;
            default:
                profileTab = new ProfileTab();
                return profileTab;

        }
    }
    @Override
    public String getPageTitle(int position) {
        return tabtitles[position];
    }
}

