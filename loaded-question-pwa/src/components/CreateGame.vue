<template>
  <div>
    <h2>Create New Game</h2>
    <label for="playerCount"> Enter Number of Players</label>
    <input
      id="playerCount"
      v-model="numberOfPlayers"
      :min="minPlayers"
      type="number"
    />
  </div>
</template>

<script>
export default {
  props: {
    minPlayers: Number
  },
  data: function () {
    return {
      numberOfPlayers: this.minPlayers,
      players: []
    };
  },
  methods: {
  }
};
</script>

<style>
</style>
