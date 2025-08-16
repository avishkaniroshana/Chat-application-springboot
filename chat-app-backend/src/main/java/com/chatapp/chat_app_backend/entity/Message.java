package com.chatapp.chat_app_backend.entity;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public Message(String sender, String content){
        this.sender = sender;
        this.content = content;
        this.timeStamp = LocalDateTime.now();

    }

}
