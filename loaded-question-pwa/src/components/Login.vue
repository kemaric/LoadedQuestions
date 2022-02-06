<template>
  <div>
    <h2>Welcome to Loaded Questions</h2>
    <button v-if="!isLoggedIn" @click="signIn()">Sign In</button>
    <button v-if="isLoggedIn" @click="signOut()">Sign Out</button>
    <div v-if="isLoggedIn">
      <h3>Lets Play  {{ player?.userName }}</h3>
    </div>
  </div>
</template>

<script>
import { User } from '../data/user';
import { mapGetters } from 'vuex';
import { generateID } from '../utils';
export default {
  props: {
    minPlayers: Number
  },
  data: function () {
    return {
      isLoggedIn: false
    };
  },
  computed: {
    ...mapGetters({ player: 'getCurrentUser' })
  },
  methods: {
    signIn () {
      const id = generateID();
      const creator = new User({ userName: `User${id}`, id });
      this.$store.dispatch('login', creator).then(res => { this.isLoggedIn = true; });
    },
    signOut () {
      this.$store.dispatch('logout').then(res => { this.isLoggedIn = false; });
    }

  }
};
</script>

<style>
</style>
