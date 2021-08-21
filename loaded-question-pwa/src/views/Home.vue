<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <CreateGame minPlayers=4></CreateGame>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue';
import CreateGame from '@/components/CreateGame.vue'

export default {
  name: 'Home',
  components: {
    // HelloWorld,
    CreateGame
  }
}
</script>
