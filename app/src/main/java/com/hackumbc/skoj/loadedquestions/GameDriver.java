package com.hackumbc.skoj.loadedquestions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class GameDriver extends FragmentActivity {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.game, container,false);
        EditText user_input = (EditText)findViewById(R.id.questionEditText);
        GameDriver gameDriver = new GameDriver();
        gameDriver.runGameDriver();
        return view;
    }



    Game game;
    User startingPlayer;
    User player1, player2, player3;
    Question currQuestion;

    public void runGameDriver() {
        // one player creates the game by asking a question
        // this sends request notifications to other players to accept and then send responses
        startingPlayer = new User("Justin", 12, "aaa@aol.com");
        // players that accept are added to the current game's playerList
        int numPlayers = 4;
        game = new Game(startingPlayer, numPlayers);
        game.addPlayer(startingPlayer);
        player1 = new User("John", 13, "aaa@aol.com");
        player2 = new User("Sarah", 14, "aaa@aol.com");
        player3 = new User("Bob", 15, "aaa@aol.com");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        while (!(game.gameStatus())) {
            while(game.isItTimeForPlayerToAsk()) {
                currQuestion = new Question("What do you like with Chocolate?", game.getCurrAsker());
                // send notification to asker to enter question here
                while (!(game.askQuestion(currQuestion))) {
                    // print "You did not enter a question!"
                    // Question newQuestion = new Question(user_input);
                }
            }

            // question is sent to other players and they must now respond
            while (game.isItTimeForPlayersToRespond()) {
                try {
                    Thread.sleep(6000);   // 600000              //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                for (User x : game.getPlayerList()) {
                    if (!((game.getCurrAsker()).equals(x)) && x.isMoveNeeded()) {
                        int indexOfPlayer = game.getIndexOfUser(x);
                        // will take their input
                        Response playerAnswer = new Response(x, "peanuts");
                        game.logPlayerResponse(playerAnswer);
                    }
                }
            }

            while (game.isItTimeForPlayerToMatch()) {
                // Drag and drop chooses the input
                Response guess1 = new Response(game.getUserWithId(13), "peanuts");
                Response guess2 = new Response(game.getUserWithId(14), "peanuts");
                Response guess3 = new Response(game.getUserWithId(15), "peanuts");
                game.matchUserInputforFour(guess1, guess2, guess3);
            }

            if (game.isGameFinished()) {
                // Congratulations!
            }
            game.changeTurn();

/*
//      This code was for asynchronous threads...
//            ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//            executorService.execute(new Runnable() {
//                public void run() {
//                   // Response player1 = new Response(player, user_input);
//                    System.out.println("Asynchronous task");
//                }
//            });
//
//            executorService.shutdown();
*/
        }
    }
}
