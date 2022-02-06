import { createStore } from 'vuex'
import { DataRepositories } from './DataRepositories'

const initialState = () => ({
  repo: new DataRepositories(),
  playerId: null
});
/**
 * Funtions that directly mutate the state. These should only be called either directly outside of async functions or indirectly
 * by dispatching actions that call a mutation.
 */
const mutations = {
  addPlayer (state, player) {
    console.log('Loggin in player', JSON.stringify(state?.repo?.playerRepo), JSON.stringify(player));
    state.repo.playerRepo.add(state)
  },
  login (state, player) {
    console.log('Loggin in player', JSON.stringify(state?.repo?.playerRepo), JSON.stringify(player));
    state.repo.playerRepo.add(player);
  },
  logout (state) {
    console.log('Logout player', JSON.stringify(state?.repo?.playerRepo));
    state.repo.playerRepo.remove(state.playerId);
  }
}

/**
 * Actions are used to trigger mutations. If any work needs to be done async, make an
 * action with that async call, and then dispatch an action.
 */
const actions = {
  /**
   * Requests to login the user
   * @param {*} param0
   * @param {*} user
   */
  login ({ commit, state }, user) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        commit('login', user, JSON.stringify(state?.repo?.playerRepo));
        resolve();
      }, 1000)
    });
  },
  /**
   * Requests to logout the user
   * @param {*} param0
   */
  logout ({ commit, state }) {
    commit('logout');
  }
};
/**
 * Store service used to hold the application state and Data access Layer object.
 */
export const store = createStore({
  state: initialState,
  mutations,
  actions
});
