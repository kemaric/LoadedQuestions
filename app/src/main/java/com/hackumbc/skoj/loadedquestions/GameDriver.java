package com.hackumbc.skoj.loadedquestions;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;


/**
 * Created by Justin12 on 9/27/2014.
 */
public class GameDriver extends FragmentActivity {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.game, container,false);
        GameDriver gameDriver = new GameDriver();
        gameDriver.runGameDriver();
        return view;
    }

    Spinner spinner;
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;
    String nextQuestion;
    EditText user_input;
    Game game;
    User startingPlayer;
    User player1, player2, player3;
    Question currQuestion;
    int gameId;
    boolean questionAsked;
    boolean allAnswered;

    public void sendResponseNotification() {
        // Sets up notifications
        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Loaded Questions!")
                        .setContentText("Your turn to respond!");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, GameDriver.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(GameDriver.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        int mId = 1;
        mNotificationManager.notify(mId, mBuilder.build());
    }
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
                spinner = (Spinner) findViewById(R.id.questionOption_spinner);
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.questionOptions_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
                spinner.setAdapter(adapter);
            // Respond to user input
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Random random = new Random();
                            int maxSize = ((game.getCurrAsker()).getQuestionHist()).size();
                            int randomPos = random.nextInt(maxSize);
                            nextQuestion = ((game.getCurrAsker()).getQuestionHist()).get(randomPos);
                        } else {
                            nextQuestion = ((EditText) findViewById(R.id.chooseQuestionToAsk)).toString();
                        }
                    }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent){

                        }
                });
                currQuestion = new Question(nextQuestion, game.getCurrAsker());
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
