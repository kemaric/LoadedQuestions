import { GameDataAccessLayer } from "./GameDataAccessLayer";
import { PlayerDataAccessLayer } from "./PlayerDataAccessLayer";
import { QuestionDataAccessLayer } from "./QuestionDataAccessLayer";
import { ResponseDataAccessLayer } from "./ResponseDataAccessLayer";

export const 
    gameRepo = new GameDataAccessLayer(),
    playerRepo = new PlayerDataAccessLayer(),
    questionRepo = new QuestionDataAccessLayer(),
    responseRepo = new ResponseDataAccessLayer();
