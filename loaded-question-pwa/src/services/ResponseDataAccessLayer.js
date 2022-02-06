export function ResponseDataAccessLayer (init = {}) {
  /**
     * Store for the responses players made in games.
     * The key is of the following format:
     * {gamehash}:{questionhash}:{responseId} with the value of
     *
     */
  const { ResponseStore = DEFAULT_RESPONSE_STORE() } = init;

  this.get = (gameId, questionId, responseId) => {
    const key = `${gameId}:${questionId}:${responseId}`;
    return ResponseStore[key];
  };

  this.add = (gameId, questionId, response) => {
    throw new Error('Method not implemented');
  };

  this.update = (partialResponse) => {
    throw new Error('Method not implemented');
  };

  return this;
}

const DEFAULT_RESPONSE_STORE = () => ({
  'demo-game-hash:demo-question-hash:demo-response-id': {
    creatorId: 'demo1',
    guessedPlayerId: '',
    responseText: 'Demo Response'
  }
});
