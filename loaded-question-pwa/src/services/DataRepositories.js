import { GameDataAccessLayer } from "./GameDataAccessLayer";
import { PlayerDataAccessLayer } from "./PlayerDataAccessLayer";
import { QuestionDataAccessLayer } from "./QuestionDataAccessLayer";
import { ResponseDataAccessLayer } from "./ResponseDataAccessLayer";

export function DataRepositories(config) {

    this.gameRepo = new GameDataAccessLayer(config),
    this.playerRepo = new PlayerDataAccessLayer(config),
    this.questionRepo = new QuestionDataAccessLayer(config),
    this.responseRepo = new ResponseDataAccessLayer(config);
}
