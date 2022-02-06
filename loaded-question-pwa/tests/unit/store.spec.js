// import { createStore } from 'vuex';
import { User } from '../../src/data/user';
import { store } from '../../src/services/store';

/**
 * Testing the store and manipulations
 */
test('login player', () => {
  const testStore = store;
  console.log(testStore.state.repo.gameRepo,
    testStore.state.repo.playerRepo);
  testStore.commit('login', new User({ userName: 'test', id: 1 }));

  expect(testStore.state.repo.playerRepo.get(1)).toBeTruthy();
});
