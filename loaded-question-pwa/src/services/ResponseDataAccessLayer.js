export function ResponseDataAccessLayer(options = {}) {
    /**
     * Store for the responses players made in games.
     * The key is of the following format:
     * {gamehash}:{questionhash}:{responseId} with the value of
     *
     */
    const ResponseStore = {
        "demo-game-hash:demo-question-hash:demo-response-id": {
            creatorId: "demo1",
            guessedPlayerId: "",
            responseText: "Demo Response"
        }
    };

    this.get = (gameId, questionId) => {
        throw "Method not implemented";
    };

    this.add = (gameId, questionId, response) => {
        throw "Method not implemented";
    };

    this.update = (partialResponse) => {
        throw "Method not implemented";
    };

    return this;
}
