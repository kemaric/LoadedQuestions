package com.hackumbc.skoj.loadedquestions;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class GameDriver {

    public static void runGameDriver() {
        // one player creates the game by asking a question
        // this sends request notifications to other players to accept and then send responses
        User startingPlayer = new User("Justin", 12, "aaa@aol.com");
        // players that accept are added to the current game's playerList
        int numPlayers = 4;
        Game game = new Game(startingPlayer, numPlayers);
        game.addPlayer(startingPlayer);
        game.addPlayer(new User("John", 13, "aaa@aol.com"));
        game.addPlayer(new User("Sarah", 14, "aaa@aol.com"));
        game.addPlayer(new User("Bob", 15, "aaa@aol.com"));
        while (!(game.gameStatus())) {
            Question currQuestion = new Question("What do you like with Chocolate?", startingPlayer);
            // send notification to asker to enter question here
            //Question currQuestion = new Question(user_input, game.getCurrAsker());
           // game.updateQuestion(currQuestion);
            // question is sent to other players and they must now respond
            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.execute(new Runnable() {
                public void run() {
                   // Response player1 = new Response(player, user_input);
                    System.out.println("Asynchronous task");
                }
            });
//            currQuestion.addAnswer()
//
//            executorService.shutdown();
//
//            game.isItTimeForPlayersToRespond()
//            if (game.)
//            if (game.isItTimeForPlayersToRespond();


            game.changeTurn();
        }
    }
}
