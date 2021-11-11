export function PlayerDataAccessLayer(options = {}) {
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
    this.add = (player = {}) => {
        throw "Method not implemented";
    };

    this.get = (playerId) => {
        throw "Method not implemented";
    };

    this.update = (partialPlayer) => {
        throw "Method not implemented";
    };

    return this;
}
