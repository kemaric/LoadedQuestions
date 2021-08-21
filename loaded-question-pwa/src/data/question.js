export class Question {

    constructor (question, asker) {
        this._message = question;
        this._asker = asker;
        this._responses = [];
    }

    getResponses() {
        return this._responses;
    }

    getAsker() {
        return this._asker;
    }

    responseSize() {
        return this._responses.length;
    }

    getQuestion() {
        return this._message;
    }

    /**
     * This method adds another player's response to the current question
     * @param {*} playerAnswer 
     * @returns 
     */
    addAnswer(playerAnswer) {
        if (playerAnswer == null) {
            return false;
        }
        else {
            this.responses.add(playerAnswer);
            return true;
        }
    }

   
    /**
     * This checks to see if the player who asked the question correctly guessed another player's
     * response with their name.
     * @param {*} guess 
     * @returns 
     */
    isGuessCorrect(guess) {
        if (guess == null) {
            // show toast: "You did not select a valid guess"
            return false;
        }
        for (const i of responses) {
            if (((i.getUser()).equalsOtherPlayer(guess.getUser()))) {
                // Toast "You guessed correctly!"
                return true;
            }
        }
        return false;
    }
}
