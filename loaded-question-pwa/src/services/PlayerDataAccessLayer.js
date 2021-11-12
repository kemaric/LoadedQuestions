export function PlayerDataAccessLayer (options = {}) {
  /***
     * Store for the registered players by their usernames. All player info are
     * kept here.
     */
  const PlayerStore = {
    'demo-player-hash': {
      playerId: 'demo',
      playerUserName: 'DemoPlayer',
      metaData: {}
    }
  };
  this.add = (player = {}) => {
    throw new Error('Method not implemented');
  };

  this.get = (playerId) => {
    return PlayerStore[playerId];
  };

  this.update = (partialPlayer) => {
    throw new Error('Method not implemented');
  };

  this.isNew = (playerId) => {
    return PlayerStore[playerId] == null;
  }

  return this;
}
