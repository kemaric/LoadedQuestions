import { DataRepositories } from './DataRepositories'
export function GameController (config = defaultConfig) {
  const repos = new DataRepositories(config);

  this.createGame = (partialGame) => {
    throw new Error('Method not implemented');
  }

  this.endGame = (partialGame) => {
    const game = repos.getGameRepo().get(partialGame.id);
    if (!game) {
      throw new Error("Cannot end a game that doens't exist");
    }
  }

  return this;
}

const defaultConfig = ({
  apiKey: '',
  apiSecret: ''
});
