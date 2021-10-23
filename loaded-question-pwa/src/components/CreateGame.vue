<template>
  <div>
    <h2>Create New Game</h2>
    <label for="gameName">Username</label>
    <input :disabled="lobbyIsOpen" type="text" v-model="gameDTO.startingPlayer">
    <button v-if="!lobbyIsOpen" @click="openLobby()">Open Game Lobby</button>
    <button v-if="lobbyIsOpen" @click="cancelLobby()">Cancel</button>
    <button @click="startGame()">Start Game</button>
    <div v-if="lobbyIsOpen">
      <h3>Game Lobby</h3>
      <div v-for="player in gameDTO.players" :key="player.id">
        {{ player.userName }}
      </div>

    </div>
  </div>
</template>

<script>
import { Game } from '../data/game';
import { User } from '../data/user';
import { generateID } from '../utils';
export default {
  props: {
    minPlayers: Number
  },
  data: function () {
    return {
      gameTitle: '',
      lobbyIsOpen: false,
      numberOfPlayers: this.minPlayers,
      maxPlayers: 10,
      gameDTO: {
        players: [],
        id: null,
        gameTitle: '',
        startingPlayer: null
      }
    };
  },
  methods: {
    openLobby () {
      if (!this.validateUserName(this.gameDTO.startingPlayer)) {
        return alert('Username is already taken or invalid. Enter a new one');
      }
      const id = generateID()
      const creator = new User({ userName: this.gameDTO.startingPlayer, id });
      this.gameDTO.players.push(creator);
      this.lobbyIsOpen = true;
    },
    startGame () {
      if (this.gameDTO.players.length < this.minPlayers) {
        return alert(`Cannot start game until at least ${this.minPlayers} players are in the lobby.`);
      }
      this.currentGame = new Game();
    },
    cancelLobby () {
      this.lobbyIsOpen = false;
      this.gameDTO.players.length = 0;
    },
    validateUserName (userName) {
      if (!!userName && userName?.trim() !== '') {
        if (!this.gameDTO.players.filter(user => user.userName === userName).length) {
          return true;
        }
      }
      return false;
    }

  }
};
</script>

<style>
</style>
