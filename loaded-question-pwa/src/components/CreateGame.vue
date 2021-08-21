<template>
  <div>
    <h2>Create New Game</h2>
    <label for="playerCount"> Enter Number of Players</label>
    <input
      id="playerCount"
      v-model="numberOfPlayers"
      v-bind:min="DEFAULT_MIN_PLAYERS"
      type="number"
    />
  </div>
</template>

<script>
const DEFAULT_MIN_PLAYERS = 4;
export default {
  props: {
    minPlayers: Number
  },
  data: function () {
    return {
      numberOfPlayers: this.minPlayers || DEFAULT_MIN_PLAYERS,
      players: []
    };
  }
};
</script>

<style>
</style>
