package org.listobjects.ws;

/**
 * scratch class to understand websocket
 *
 *
 * */
public class ChatMessage {
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    private String sender;
    private String destinationUser;
    private String content;
    private MessageType messageType;
}
