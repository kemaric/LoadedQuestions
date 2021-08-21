export class Game {

    // Constructor for creating a new game
    constructor(init = {}) {
        const {startingPlayer, numPlayers, 
            currQuestion, currAsker = startingPlayer, players = [], currAskerIndex, 
            isGameDone, turnChange, askPeriod = true,
            askPeriod, responsePeriod, matchPeriod} = init;
        const props = { startingPlayer, numPlayers, 
            currQuestion, currAsker, players, currAskerIndex, 
            isGameDone, turnChange, askPeriod,
            askPeriod, responsePeriod, matchPeriod};
        
        Object.assign(this,...props);

        this.boardLength = (this.numPlayers - 1) * 3;
    }

    askQuestion(question) {
        if (question != null) {
            currQuestion = question;
            askPeriod = false;
            responsePeriod = true;
            (question.getAsker()).noActionNeeded();
            return true;
        }
        return false;
    }

    getCurrAsker() {
        return currAsker;
    }

    getUserWithId(userId) {
        for (x of players) {
            if (x.equalsOtherPlayerById(userId)) {
                return x;
            }
        }
        return null; // this case should never happen however
    }

    getPlayerList() {
        return players;
    }

    gameStatus() {
        return isGameDone;
    }

    addPlayer(newPlayer) {
        players.add(newPlayer);
    }

    logPlayerResponse(response) {
        currQuestion.addAnswer(response);
        index = this.getIndexOfUser((response.getUser()));
        (players.get(index)).noActionNeeded();
        (players.get(index)).addQuestionToHist(response.getResponse());
    }


    getIndexOfUser(player) {
        for (let x = 0; x < players.size(); x++) {
            if (((players.get(x))).equals(player)) {
                return x;
            }
        }
        return -1;
    }

    // Returns true if the question asker is waiting for other players to respond
    isItTimeForPlayersToRespond() {
        if (currQuestion.responseSize() != (numPlayers - 1)) {
            responsePeriod = true;
        } else {
            askPeriod = false;
            matchPeriod = true;
            responsePeriod = false;
        }
        return responsePeriod;
    }

    isItTimeForPlayerToMatch() {
        if (matchPeriod) {
            matchPeriod = false;
            turnChange = true;
            return true;
        } else {
            return false;
        }
    }

    changeTurn() {
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

    isItTimeForPlayerToAsk() {
        if (askPeriod) {
            askPeriod = true;
            for (const x of players) {
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

    isGameFinished() {
        for (const x of players) {
            if (x.getCurrSpace() == boardLength) {
                isGameDone = true;
                return true;
            }
        }
        return false;
    }


    // Below are the scoring mechanisms for matching user guesses with the correct player guesses
    matchUserInputforN(guesses) {
        const score = guesses.reduce((_score,guess) => {
            if (currQuestion.isGuessCorrect((guess))) {
                _score++;
            }
            return _score;
        }, 0);

        const index = this.getIndexOfUser(this.currAsker);
        (players.get(index)).movePlayer(score);
    }

    matchUserInputforFour(guess1, guess2, guess3) {
        matchUserInputforN([guess1, guess2, guess3]);
    }

    matchUserInputforFive(guess1, guess2, guess3,guess4) {
        matchUserInputforN([guess1, guess2, guess3,  guess4]);
    }

    matchUserInputforSix(guess1, guess2, guess3, guess4, guess5) {
        matchUserInputforN([guess1, guess2, guess3,  guess4, guess5]);
    }
}
