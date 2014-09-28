package com.hackumbc.skoj.loadedquestions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Owner on 9/27/2014.
 */
public class CurrentGamesFragment extends Fragment {

    ListView lv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.current_games, container,false);
        //Declaration part
//        ArrayAdapter<String> adapter;
//        //TODO Pull list of games from db
//
//        ArrayList<String> listItems=new ArrayList<String>();
//        lv = (ListView)getView().findViewById(R.id.curr_games_list);

        //arraylist Append
       // adapter=new ArrayAdapter<String>(getListAda);
       // lv.setAdapter(adapter);
        return view;
    }

}
