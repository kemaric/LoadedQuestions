/**
 * Created by Justin12 on 9/27/2014.
 */
export class User {
  constructor ({ userName, friendsList, email, id }) {
    this.userName = userName || '';
    this.email = email || '';
    this.friendsList = friendsList || [];
    this.id = id || '';
    this._numGamesWon = 0;
    this._numGamesLost = 0;
    this._currSpace = 1;
    this._questionHist = [];
    this._requireMove = true;
  }

  addFriendsList (friends) {
    this.friendsList = friends;
  }

  getUserName () {
    return this.userName;
  }

  getCurrSpace () {
    return this.currSpace;
  }

  getQuestionHist () {
    return this._questionHist;
  }

  isMoveNeeded () {
    return this._requireMove;
  }

  /**
   * Adds the previously guessed question to the user's question history.
   * @param {string} questionToAdd
   * @returns
   */
  addQuestionToHist (questionToAdd) {
    if (!(this._questionHist.includes(questionToAdd))) {
      this._questionHist.push(questionToAdd);
      return true;
    }
    return false;
  }

  /**
     * Moves the current player on the board
     * @param {number=1} numSpaces
     */
  movePlayer (numSpaces = 0) {
    this.currSpace += numSpaces;
  }

  /**
     * Set the current player's status so that they need to respond to the game
     */
  requireAction () {
    this._requireMove = true;
  }

  /**
     * Set the current player's status so that they do not need to respond to the game
     */
  noActionNeeded () {
    this._requireMove = false;
  }

  /**
     * Check if input user is the same as current.
     * @param {@link User} other
     * @returns
     */
  equalsOtherPlayer (other) {
    if (this === null || this === undefined) {
      return false;
    } else if (this === other) {
      return true;
    } else {
      return this.id === other.id && this.getUserName() === other.getUserName();
    }
  }

  equalsOtherPlayerById (otherId) {
    return this.id === otherId;
  }
}
