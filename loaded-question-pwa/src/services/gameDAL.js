/***
 * Store for the registered players by their usernames. All player info are
 * kept here.
 */
const PlayerStore = {
    "demo-player-hash": {
        playerId: "demo",
        playerUserName: "DemoPlayer",
        metaData: {},
    }
};
/**
 * Store's the general Game data with the key as the game's hash.
 */
const GameStore = {
    "demo-game-hash": {
        gameId: "demo-game",
        players: [],
        hostPlayer: "",
        judgePlayer: "",
        loadedQuestions: [],
        unloadedQuestions: [], 
    }
};
/**
 * Store for the question bank for any and all games.
 */
const QuestionStore = {
    "demo-question-hash": {
        questionId: "demo-question",
        tags: ["demo"],
        text: "Demo",
        // store other meta data about the question
        metaData: {}
    }
};
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

export function GameDataAccessLayer(options = {}) {
    let { apiKey, apiSecret } = options;
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;


    this.updateConfig = (config) => {
        let { apiKey, apiSecret, gameId } = config;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.gameId = gameId;
    };

    return this;
}

export function PlayerDataAccessLayer(options = {}) {
    this.add = (player = {}) => {
        throw "Method not implemented";
    };

    this.get = (playerId) => {
        throw "Method not implemented";
    };

    this.update = (partialPlayer) => {
        throw "Method not implemented";
    }

    return this;
}

export function QuestionDataAccessLayer(options = {}) {
    this.get = (...questionIds) => {
        throw "Method not implemented";
    };

    this.add = (question) => {
        throw "Method not implemented";
    }
    

    return this;
}

export function ResponseDataAccessLayer(options = {}) {
    this.get = (gameId, questionId) => {
        throw "Method not implemented";
    };

    this.add = (gameId, questionId, response) => {
        throw "Method not implemented";
    }
    
    this.update = (partialResponse) => {
        throw "Method not implemented";
    }

    return this;
}


