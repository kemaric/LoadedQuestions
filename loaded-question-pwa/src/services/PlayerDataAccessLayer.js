import { User } from '../data/user';

export function PlayerDataAccessLayer (init = {}) {
  /***
     * Store for the registered players by their usernames. All player info are
     * kept here.
     */
  const { PlayerStore = DEFAULT_PLAYER_STATE() } = init;

  this.add = (player = {}) => {
    if (!player?.id) {
      throw new Error('Player Id was not provided');
    } else if (PlayerStore[player?.id]) {
      throw new Error(`Player ${player?.id} is already logged in...`);
    } else {
      PlayerStore[player.id] = new User(player);
    }
    return PlayerStore[player.id];
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
  this.remove = (playerId) => {
    return delete PlayerStore[playerId];
  }

  return this;
}

const DEFAULT_PLAYER_STATE = () => ({
  'demo-player-hash': {
    playerId: 'demo',
    playerUserName: 'DemoPlayer',
    metaData: {}
  }
});
