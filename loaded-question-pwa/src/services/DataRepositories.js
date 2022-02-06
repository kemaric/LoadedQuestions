import { GameDataAccessLayer } from './GameDataAccessLayer';
import { PlayerDataAccessLayer } from './PlayerDataAccessLayer';
import { QuestionDataAccessLayer } from './QuestionDataAccessLayer';
import { ResponseDataAccessLayer } from './ResponseDataAccessLayer';

export function DataRepositories (config = {}) {
  const { gameRepo, playerRepo, questionRepo, responseRepo } = config;

  this.gameRepo = new GameDataAccessLayer(gameRepo);
  this.playerRepo = new PlayerDataAccessLayer(playerRepo);
  this.questionRepo = new QuestionDataAccessLayer(questionRepo);
  this.responseRepo = new ResponseDataAccessLayer(responseRepo);

  return this;
}
