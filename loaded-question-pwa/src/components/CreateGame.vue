<template>
  <div v-if="lobbyIsOpen">
      <h3>{{ gameDTO?.gameTitle }} Lobby</h3>
      <div v-for="player in gameDTO.players" :key="player.id">
        <span>{{ player.userName }} <span v-if="player.id !== currentPlayer.id" @click="removePlayer(player.id)">X</span></span>
      </div>
      <button @click="addComputerPlayer()">Add CPU</button>
  </div>

  <div v-if="isOnCreateOrJoin">
    <button @click="toggleGameCreateMode('JOIN')">Join a Game</button>
    <button @click="toggleGameCreateMode('CREATE')">Create a Game</button>
  </div>
  <div v-if="gameCreateMode === gameStateMode['CREATE']">
    <div v-if="!lobbyIsOpen">
      <h2>Create New Game</h2>
      <input :disabled="lobbyIsOpen" type="text"
      placeholder="Enter a lobby name"
      aria-placeholder="Enter lobby name"
      v-model="gameDTO.gameTitle">
    </div>
    <button v-if="!lobbyIsOpen" @click="openLobby()">Open Game Lobby</button>
    <button @click="startGame()">Start Game</button>
    <button v-if="!isOnCreateOrJoin" @click="cancel()">Cancel</button>
  </div>
  <div v-if="gameCreateMode === gameStateMode['JOIN']">
    <input :disabled="lobbyIsOpen" type="text" v-model="gameCode"
    placeholder="Enter game code"
    aria-placeholder="Enter game code">
    <button>Join Game</button>
    <button v-if="!isOnCreateOrJoin" @click="cancel()">Cancel</button>
  </div>
</template>

<script>
import { Game } from '../data/game';
import { User } from '../data/user';
import { gameStateMode } from '../constants';
export default {
  props: {
    minPlayers: Number,
    currentPlayer: User
  },
  data: function () {
    return {
      gameCode: '',
      lobbyIsOpen: false,
      lobbyIsLocked: false,
      numberOfPlayers: this.minPlayers,
      maxPlayers: 10,
      gameCreateMode: null,
      isOnCreateOrJoin: true,
      gameStateMode,
      numCPU: 0,
      gameDTO: {
        players: [],
        id: null,
        gameTitle: '',
        startingPlayer: null
      }
    };
  },
  computed: {
    totalPlayers () {
      return this.gameDTO.players.length - 1;
    }
  },
  methods: {
    toggleGameCreateMode (mode) {
      this.gameCreateMode = gameStateMode[mode];
      this.isOnCreateOrJoin = false;
    },
    cancel () {
      this.isOnCreateOrJoin = true;
      this.gameCreateMode = null;
      if (this.lobbyIsOpen) {
        this.lobbyIsOpen = false;
        this.gameDTO.players.length = 0;
      }
    },
    openLobby () {
      this.gameDTO.players.push(this.currentPlayer);
      this.lobbyIsOpen = true;
    },
    startGame () {
      if (this.gameDTO.players.length < this.minPlayers) {
        return alert(`Cannot start game until at least ${this.minPlayers} players are in the lobby.`);
      }
      this.lobbyIsLocked = true;
      this.currentGame = new Game();
    },
    addComputerPlayer () {
      if (this.totalPlayers < this.maxPlayers) {
        const id = `CPU-${++this.numCPU}`;
        this.gameDTO.players.push(new User({ id, userName: id }));
      }
    },
    removePlayer (id) {
      // TODO: Change this to dispatch an event to the store
      if (id !== this.currentPlayer.id) {
        this.gameDTO.players.splice(this.gameDTO.players.findIndex(elm => elm.id === id), 1);
      }
    }
    //,
    // validateLobbyName (userName) {
    //   if (!!userName && userName?.trim() !== '') {
    //     if (!this.gameDTO.players.filter(user => user.userName === userName).length) {
    //       return true;
    //     }
    //   }
    //   return false;
    // }

  }
};
</script>

<style>
</style>
