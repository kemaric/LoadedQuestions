package com.hackumbc.skoj.loadedquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Owner on 9/27/2014.
 */
public class CreateGameFragment extends Fragment {
    EditText numPlayers;
    Bundle newBundle;

    Button startButton;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.create_game, container,false);
        numPlayers = (EditText)view.findViewById(R.id.numPlayers);
        newBundle = new Bundle();
        newBundle.putInt("numPlayers", Integer.parseInt(numPlayers.getText().toString()));
        startButton = (Button)view.findViewById(R.id.startGameButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getActivity().getApplicationContext(),GameDriver.class);
                newIntent.putExtra("userInfo",newBundle);
                startActivity(newIntent);
            }
        });
        return view;
    }
}
