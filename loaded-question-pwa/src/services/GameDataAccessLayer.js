export function GameDataAccessLayer(options = {}) {
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

    let { apiKey, apiSecret } = options;
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;


    this.updateConfig = (config) => {
        let { apiKey, apiSecret, gameId } = config;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.gameId = gameId;
    };

    this.add = (game = {}) => {
        throw "Method not implemented";
    };

    this.get = (gameId) => {
        throw "Method not implemented";
    };

    this.update = (partialGame) => {
        throw "Method not implemented";
    };

    return this;
}
