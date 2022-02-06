<template>
  <div class="home">
    <div class="logo">
      <img alt="Vue logo" src="../assets/logo.png">
    </div>
    <Login></Login>
    <CreateGame v-if="player" :minPlayers="4"></CreateGame>
  </div>
</template>

<script>
// @ is an alias to /src
import Login from '@/components/Login.vue';
import CreateGame from '@/components/CreateGame.vue'
import { mapGetters } from 'vuex';
export default {
  name: 'Home',
  components: {
    Login,
    CreateGame
  },
  computed: {
    ...mapGetters({ player: 'getCurrentUser' })
  }
}
</script>
