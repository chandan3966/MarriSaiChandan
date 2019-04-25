package com.example.marrisaichandan;

public class ChatBubble {
    private String content;
    private int type;

    public ChatBubble(String content,int type) {
        this.content = content;
        this.type=type;
    }

    public String getContent() {
        return content;
    }

    public int getType(){return type;}

}
