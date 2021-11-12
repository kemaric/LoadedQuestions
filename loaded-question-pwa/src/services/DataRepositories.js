import { GameDataAccessLayer } from './GameDataAccessLayer';
import { PlayerDataAccessLayer } from './PlayerDataAccessLayer';
import { QuestionDataAccessLayer } from './QuestionDataAccessLayer';
import { ResponseDataAccessLayer } from './ResponseDataAccessLayer';

export function DataRepositories (config) {
  const gameRepo = new GameDataAccessLayer(config);
  const playerRepo = new PlayerDataAccessLayer(config);
  const questionRepo = new QuestionDataAccessLayer(config);
  const responseRepo = new ResponseDataAccessLayer(config);

  this.getGameRepo = () => gameRepo;
  this.getPlayerRepo = () => playerRepo;
  this.getQuestionRepo = () => questionRepo;
  this.getResponseRepo = () => responseRepo;

  return this;
}
