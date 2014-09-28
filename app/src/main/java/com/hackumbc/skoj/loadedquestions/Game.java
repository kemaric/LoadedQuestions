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

    public boolean askQuestion (Question question) {
        if (question != null) {
            currQuestion = question;
            askPeriod = false;
            responsePeriod = true;
            (question.getAsker()).noActionNeeded();
            return true;
        }
        return false;
    }

    public Question getCurrQuestion() {
        return currQuestion;
    }

    public User getCurrAsker() {
        return currAsker;
    }

    public ArrayList<User> getPlayerList() {
        return players;
    }

    public boolean gameStatus() {
        return isGameDone;
    }

    public void addPlayer(User newPlayer) {
        players.add(newPlayer);
    }

    public void logPlayerResponse(Response response) {
        currQuestion.addAnswer(response);
        int index = this.getIndexOfUser((response.getUser()));
        (players.get(index)).noActionNeeded();
        (players.get(index)).addQuestionToHist(response.getResponse());
    }


    public int getIndexOfUser(User player) {
        for (int x = 0; x < players.size(); x++) {
            if (((players.get(x))).equals(player)) {
                return x;
            }
        }
        return -1;
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

    public boolean isItTimeForPlayerToAsk() {
        if (askPeriod) {
            askPeriod = false;
            responsePeriod = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameFinished() {
        for (User x : players) {
            if (x.getCurrSpace() == boardLength) {
                isGameDone = true;
            }
        }
        return false;
    }
}
