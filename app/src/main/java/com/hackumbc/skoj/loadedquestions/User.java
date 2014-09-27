package com.hackumbc.skoj.loadedquestions;

import java.util.ArrayList;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class User {

    private int userId;
    private String email;
    private String userName;
    private ArrayList<User> friendsList;
    private int numGamesWon = 0;
    private int numGamesLost = 0;
    private ArrayList<String> questionHist = new ArrayList<String>();

    public User (String name, int id, String email, ArrayList<User> friends) {
        userName = name;
        userId = id;
        this.email = email;
        friendsList = friends;
    }

    // Copy Constructor
    public User (User other) {
        this.userName = other.userName;
        this.userId = other.userId;
        this.email = other.email;
        this.friendsList = other.friendsList;
    }

    public String getUserName() {
        return this.userName;
    }

    // Adds the previously guessed question to the user's question history.
    public boolean addQuestionToHist(String questionToAdd) {
        if (!(questionHist.contains(questionToAdd))) {
            questionHist.add(questionToAdd);
            return true;
        }
        return false;
    }



}
