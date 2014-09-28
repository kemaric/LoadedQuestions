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

    public boolean askQuestion(Question question) {
        if (question != null) {
            currQuestion = question;
            askPeriod = false;
            responsePeriod = true;
            (question.getAsker()).noActionNeeded();
            return true;
        }
        return false;
    }

    public User getCurrAsker() {
        return currAsker;
    }

    public User getUserWithId(int userId) {
        for (User x : players) {
            if (x.equalsOtherPlayerById(userId)) {
                return x;
            }
        }
        return null; // this case should never happen however
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
            askPeriod = false;
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
        } else {
            return false;
        }
    }

    public boolean isItTimeForPlayerToAsk() {
        if (askPeriod) {
            askPeriod = true;
            for (User x : players) {
                if (!(x.equalsOtherPlayer(currAsker))) {
                    x.requireAction();
                }
            }
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
                return true;
            }
        }
        return false;
    }

    // Below are the scoring mechanisms for matching user guesses with the correct player guesses
    public void matchUserInputforFour(Response guess1, Response guess2, Response guess3) {
        int score = 0;
        if (currQuestion.isGuessCorrect((guess1))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess2))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess3))) {
            score++;
        }
        int index = this.getIndexOfUser(this.currAsker);
        (players.get(index)).movePlayer(score);
    }

    public void matchUserInputforFive(Response guess1, Response guess2, Response guess3, Response
            guess4) {
        int score = 0;
        if (currQuestion.isGuessCorrect((guess1))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess2))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess3))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess4))) {
            score++;
        }
        int index = this.getIndexOfUser(this.currAsker);
        (players.get(index)).movePlayer(score);
    }

    public void matchUserInputforSix(Response guess1, Response guess2, Response guess3, Response
            guess4, Response guess5) {
        int score = 0;
        if (currQuestion.isGuessCorrect((guess1))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess2))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess3))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess4))) {
            score++;
        }
        if (currQuestion.isGuessCorrect((guess5))) {
            score++;
        }
        int index = this.getIndexOfUser(this.currAsker);
        (players.get(index)).movePlayer(score);
    }
}
