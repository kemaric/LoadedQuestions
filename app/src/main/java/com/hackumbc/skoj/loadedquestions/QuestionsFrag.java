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
public class QuestionsFrag extends Fragment {
    ListView lv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.my_questions, container,false);

        //Declaration part
//        ArrayAdapter<String> adapter;
//        //TODO Pull list of requests from db
//        ArrayList<String> listItems=new ArrayList<String>();
//        lv = (ListView) getView().findViewById(R.id.request_games_list);
//
//        //arraylist Append
//        adapter=new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1,
//                listItems);
//        lv.setAdapter(adapter);
        return view;
    }
}
