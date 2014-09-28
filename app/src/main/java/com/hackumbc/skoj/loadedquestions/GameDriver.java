package com.hackumbc.skoj.loadedquestions;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class GameDriver {

    public void startGame() {

    }


    public static void main (String[] args) {
        // one player creates the game by asking a question
        // this sends request notifications to other players to accept and then send responses
        int[] x = {1, 2, 3};
        User startingPlayer = new User("Justin", 12, "aaa@aol.com", x);
        Question firstQuestion = new Question("What do you like with Chocolate?", startingPlayer);
        // players that accept are added to the current game's playerList
        ArrayList<User> playerList = new ArrayList<User>();
        playerList.add(startingPlayer);
        playerList.add(new User("John", 13, "aaa@aol.com", x));
        playerList.add(new User("Sarah", 14, "aaa@aol.com", x));
        playerList.add(new User("Bob", 15, "aaa@aol.com", x));
        Game game = new Game(playerList, firstQuestion);
        while (!(game.gameStatus())) {
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
}