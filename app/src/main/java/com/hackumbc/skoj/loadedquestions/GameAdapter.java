package com.hackumbc.skoj.loadedquestions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Owner on 9/27/2014.
 */
public class GameAdapter extends FragmentActivity {
    EditText user_input;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.game, container,false);
        EditText user_input = (EditText)findViewById(R.id.questionEditText);
        GameDriver gameDriver = new GameDriver();
        gameDriver.runGameDriver();
        return view;
    }

}
