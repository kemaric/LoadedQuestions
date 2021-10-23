/**
 * Created by Justin12 on 9/27/2014.
 */
import { User } from './user'
export class Response {
  constructor ({ player, response }) {
    this.responder = new User(player);
    this.response = response;
  }

  getUser () {
    return new User(this.responder);
  }

  getResponse () {
    return this.response;
  }

  equalsResponse (other) {
    return (this.response.equals(other.response)) && (this.responder.equalsOtherPlayer(
      other.responder));
  }
}
