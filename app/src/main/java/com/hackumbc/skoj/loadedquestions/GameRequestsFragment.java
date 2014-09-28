package com.hackumbc.skoj.loadedquestions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Owner on 9/27/2014.
 */
public class GameRequestsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstance){
        View view = inflater.inflate(R.layout.request_game, container,false);
        return view;
    }
}
