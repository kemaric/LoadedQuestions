package com.hackumbc.skoj.loadedquestions;

import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class GameDriver extends FragmentActivity {

    public void runGameDriver() {
        // one player creates the game by asking a question
        // this sends request notifications to other players to accept and then send responses
        User startingPlayer = new User("Justin", 12, "aaa@aol.com");
        // players that accept are added to the current game's playerList
        int numPlayers = 4;
        Game game = new Game(startingPlayer, numPlayers);
        game.addPlayer(startingPlayer);
        User player1 = new User("John", 13, "aaa@aol.com");
        User player2 = new User("Sarah", 14, "aaa@aol.com");
        User player3 = new User("Bob", 15, "aaa@aol.com");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        while (!(game.gameStatus())) {
            Question currQuestion = new Question("What do you like with Chocolate?", game.getCurrAsker());
            // send notification to asker to enter question here
            while (!(game.askQuestion(currQuestion))) {
                // print "You did not enter a question!"
                // Question newQuestion = new Question(user_input);
            }

            // question is sent to other players and they must now respond
            while (game.isItTimeForPlayersToRespond()) {
                // wait(1o min);
                for (User x : game.getPlayerList()) {
                    if (!((game.getCurrAsker()).equals(x)) && x.isMoveNeeded()) {
                        int indexOfPlayer = game.getIndexOfUser(x);
                        Response playerAnswer = new Response(x, "peanuts");
                        game.logPlayerResponse(playerAnswer);
                    }
                }
            }


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
            game.changeTurn();
        }
    }
}
