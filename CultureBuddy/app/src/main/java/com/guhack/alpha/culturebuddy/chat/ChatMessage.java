package com.guhack.alpha.culturebuddy.chat;

/**
 * Created by Raitis on 15.11.2014..
 */
public class ChatMessage {

    private String message;
    private boolean sentByYou;

    public ChatMessage(String message, boolean sentByYou) {
        this.message = message;
        this.sentByYou = sentByYou;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSentByYou() {
        return sentByYou;
    }

    public void setSentByYou(boolean sentByYou) {
        this.sentByYou = sentByYou;
    }
}
