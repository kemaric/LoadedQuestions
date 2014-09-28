package com.hackumbc.skoj.loadedquestions;

import java.util.ArrayList;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class Game {

    private int[] board;
    private Question currQuestion;
    private ArrayList<User> players;
    private int numPlayers;
    private boolean isGameDone;

    public Game(ArrayList<User> playerList, Question firstQuestion) {
        numPlayers = playerList.size();
        currQuestion = firstQuestion;

    }



}
