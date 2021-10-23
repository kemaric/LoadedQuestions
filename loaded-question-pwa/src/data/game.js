export class Game {
  // Constructor for creating a new game
  constructor (init = {}) {
    const {
      startingPlayer, numPlayers,
      currQuestion, currAsker = startingPlayer, players = [], currAskerIndex,
      isGameDone, turnChange, askPeriod = true,
      responsePeriod, matchPeriod, maxPlayers
    } = init;
    const props = {
      startingPlayer,
      maxPlayers,
      numPlayers,
      currQuestion,
      currAsker,
      players,
      currAskerIndex,
      isGameDone,
      turnChange,
      askPeriod,
      responsePeriod,
      matchPeriod
    };

    Object.assign(this, props);

    this.boardLength = (this.numPlayers - 1) * 3;
  }

  askQuestion (question) {
    if (question != null) {
      this.currQuestion = question;
      this.askPeriod = false;
      this.responsePeriod = true;
      (question.getAsker()).noActionNeeded();
      return true;
    }
    return false;
  }

  getCurrAsker () {
    return this.currAsker;
  }

  getUserWithId (userId) {
    for (const x of this.players) {
      if (x.equalsOtherPlayerById(userId)) {
        return x;
      }
    }
    return null; // this case should never happen however
  }

  getPlayerList () {
    return this.players;
  }

  gameStatus () {
    return this.isGameDone;
  }

  addPlayer (newPlayer) {
    this.players.add(newPlayer);
  }

  logPlayerResponse (response) {
    this.currQuestion.addAnswer(response);
    const index = this.getIndexOfUser((response.getUser()));
    (this.players.get(index)).noActionNeeded();
    (this.players.get(index)).addQuestionToHist(response.getResponse());
  }

  getIndexOfUser (player) {
    for (let x = 0; x < this.players.size(); x++) {
      if (((this.players.get(x))).equals(player)) {
        return x;
      }
    }
    return -1;
  }

  // Returns true if the question asker is waiting for other players to respond
  isItTimeForPlayersToRespond () {
    if (this.currQuestion.responseSize() !== (this.numPlayers - 1)) {
      this.responsePeriod = true;
    } else {
      this.askPeriod = false;
      this.matchPeriod = true;
      this.responsePeriod = false;
    }
    return this.responsePeriod;
  }

  isItTimeForPlayerToMatch () {
    if (this.matchPeriod) {
      this.matchPeriod = true;
      this.turnChange = true;
      return true;
    } else {
      return false;
    }
  }

  changeTurn () {
    if (this.turnChange) {
      if (this.currAskerIndex === (this.numPlayers - 1)) {
        this.currAskerIndex = 0;
      } else {
        this.currAskerIndex++;
      }
      this.currAsker = this.players.get(this.currAskerIndex);
      this.turnChange = false;
      this.askPeriod = true;
      return true;
    } else {
      return false;
    }
  }

  isItTimeForPlayerToAsk () {
    if (this.askPeriod) {
      this.askPeriod = false;
      for (const x of this.players) {
        if (!(x.equalsOtherPlayer(this.currAsker))) {
          x.requireAction();
        }
      }
      this.responsePeriod = true;
      return true;
    } else {
      return false;
    }
  }

  isGameFinished () {
    for (const x of this.players) {
      if (x.getCurrSpace() === this.boardLength) {
        this.isGameDone = true;
        return true;
      }
    }
    return false;
  }

  // Below are the scoring mechanisms for matching user guesses with the correct player guesses
  matchUserInputforN (guesses) {
    const score = guesses.reduce((_score, guess) => {
      if (this.currQuestion.isGuessCorrect((guess))) {
        _score++;
      }
      return _score;
    }, 0);

    const index = this.getIndexOfUser(this.currAsker);
    (this.players.get(index)).movePlayer(score);
  }

  matchUserInputforFour (guess1, guess2, guess3) {
    this.matchUserInputforN([guess1, guess2, guess3]);
  }

  matchUserInputforFive (guess1, guess2, guess3, guess4) {
    this.matchUserInputforN([guess1, guess2, guess3, guess4]);
  }

  matchUserInputforSix (guess1, guess2, guess3, guess4, guess5) {
    this.matchUserInputforN([guess1, guess2, guess3, guess4, guess5]);
  }
}
