package com.hackumbc.skoj.loadedquestions;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class Question {

    private String message;
    private User asker;
    private ArrayList<Response> responses;

    public Question (String question, User asker) {
        message = question;
        this.asker = asker;
    }

    public ArrayList<Response> getResponses() {
        return this.responses;
    }

    public User getAsker() {
        return this.asker;
    }

    public int responseSize() {
        return responses.size();
    }

    public String getQuestion() {
        return message;
    }

    // This method adds another player's response to the current question
    public boolean addAnswer(Response playerAnswer) {
        if (playerAnswer == null) {
            return false;
        }
        else {
            this.responses.add(playerAnswer);
            return true;
        }
    }

    // This checks to see if the player who asked the question correctly guessed another player's
    // response with their name.
    public boolean isGuessCorrect(Response guess) {
        if (guess == null) {
            // show toast: "You did not select a valid guess"
            return false;
        }
        for (Response i : responses) {
            if (((i.getUser()).equalsOtherPlayer(guess.getUser()))) {
                // Toast "You guessed correctly!"
                return true;
            }
        }
        return false;
    }
}
