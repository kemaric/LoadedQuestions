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
    private int currSpace = 1;
    private ArrayList<String> questionHist = new ArrayList<String>();
    private boolean requireMove;

    public User (String name, int id, String email) {
        userName = name;
        userId = id;
        this.email = email;
    }

    public void addFriendsList(ArrayList<User> friends) {
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

    // Moves the current player on the board
    public void movePlayer(int numSpaces) {
        currSpace += numSpaces;
    }

    // Set the current player's status so that they need to respond to the game
    public void requireAction() {
        requireMove = true;
    }

    // Set the current player's status so that they do not need to respond to the game
    public void noActionNeeded() {
        requireMove = false;
    }

}
