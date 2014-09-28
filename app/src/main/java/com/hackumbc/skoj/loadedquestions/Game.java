package com.hackumbc.skoj.loadedquestions;

import com.google.android.gms.games.quest.Quest;

import java.util.ArrayList;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class Game {

    private int boardLength;
    private Question currQuestion;
    private User currAsker;
    private ArrayList<User> players;
    private int currAskerIndex;
    private int numPlayers;
    private boolean isGameDone;
    private boolean turnChange;
    private boolean askPeriod;
    private boolean responsePeriod;
    private boolean matchPeriod;

    // Constructor for creating a new game
    public Game(User startingPlayer, int numPlayers) {
        this.numPlayers = numPlayers;
        boardLength = (numPlayers - 1) * 3;
        currAsker = startingPlayer;
        askPeriod = true;
    }

    public void askQuestion (Question question) {
        currQuestion = question;
        askPeriod = false;
        responsePeriod = true;
    }

    public User getCurrAsker() {
        return currAsker;
    }

    public boolean gameStatus() {
        return isGameDone;
    }

    public void addPlayer(User newPlayer) {
        players.add(newPlayer);
    }

    // Returns true if the question asker is waiting for other players to respond
    public boolean isItTimeForPlayersToRespond() {
        if (currQuestion.responseSize() != (numPlayers - 1)) {
            responsePeriod = true;
        } else {
            matchPeriod = true;
            responsePeriod = false;
        }
        return responsePeriod;
    }

    public boolean isItTimeForPlayerToMatch() {
        if (matchPeriod) {
            matchPeriod = false;
            turnChange = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean changeTurn() {
        if (turnChange) {
            if (currAskerIndex == (numPlayers - 1)) {
                currAskerIndex = 0;
            } else {
                currAskerIndex++;
            }
            currAsker = players.get(currAskerIndex);
            turnChange = false;
            askPeriod = true;
            return true;
        }
        else {
            return false;
        }
    }

    public void updateQuestion(Question newQuestion) {
        currQuestion = newQuestion;
    }


    public boolean isItTimeForPlayerToAsk() {
        if (askPeriod) {
            askPeriod = false;
            responsePeriod = true;
            return true;
        } else {
            return false;
        }
    }
}
