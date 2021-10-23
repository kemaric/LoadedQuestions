<template>
    <div>
        <h3> {{ question?.getQuestion() }}</h3>
        <label for="userResponse">Answer</label>
        <input type="text" v-model="response">
        <button @click="skip()">Skip</button>
        <button @click="submit()">Submit</button>
        <button @click="clear()">Clear</button>
    </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api';
import { Question } from '../data/question';
import { User } from '../data/user';

export default defineComponent({
  props: {
    question: Question,
    player: User
  },
  data () {
    return {
      response: ''
    }
  },
  methods: {
    submit: () => {
      console.log(`${this.player} responsed with ${this.response}`);
    }
  }
})
</script>
