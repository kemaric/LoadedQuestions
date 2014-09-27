package com.hackumbc.skoj.loadedquestions;

/**
 * Created by Justin12 on 9/27/2014.
 */
public class Response {

    private User responder;
    private String response;

    public Response (User player, String response) {
        responder = new User(player);
        this.response = response;
    }

    public User getUser() {
        return new User(this.responder);
    }

    public String getResponse() {
        return response;
    }

}
