export function GameDataAccessLayer (options = {}) {
  /**
     * Store's the general Game data with the key as the game's hash.
     */
  const GameStore = {
    'demo-game-hash': {
      gameId: 'demo-game',
      players: [],
      hostPlayer: '',
      judgePlayer: '',
      loadedQuestions: [],
      unloadedQuestions: []
    }
  };

  const { apiKey, apiSecret } = options;
  this.apiKey = apiKey;
  this.apiSecret = apiSecret;

  this.updateConfig = (config) => {
    const { apiKey, apiSecret, gameId } = config;
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;
    this.gameId = gameId;
  };

  this.add = (game = {}) => {
    throw new Error('Method not implemented');
  };

  this.get = (gameId) => {
    return GameStore[gameId];
  };

  this.update = (partialGame) => {
    throw new Error('Method not implemented');
  };

  this.isNew = (gameId) => {
    return GameStore[gameId] == null;
  }

  return this;
}
