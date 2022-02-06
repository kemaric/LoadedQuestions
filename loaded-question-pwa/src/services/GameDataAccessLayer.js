export function GameDataAccessLayer (init = {}) {
  /**
   * Store's the general Game data with the key as the game's hash.
   */
  const { GameStore = DEFAULT_GAME_STORE(), gameId } = init;

  const { apiKey = '', apiSecret = '' } = init;
  this.apiKey = apiKey;
  this.apiSecret = apiSecret;
  this.gameId = gameId;
  this.gameStore = GameStore;

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

const DEFAULT_GAME_STORE = () => ({
  'demo-game-hash': {
    gameId: 'demo-game',
    players: [],
    hostPlayer: '',
    judgePlayer: '',
    loadedQuestions: [],
    unloadedQuestions: []
  }
});
