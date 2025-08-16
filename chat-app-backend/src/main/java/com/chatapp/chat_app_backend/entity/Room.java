package com.chatapp.chat_app_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "rooms")
public class Room {

    @Id
    private String id; // MongoDB unique ID
    private String roomId;
    private List<Message> messages = new ArrayList<>();

}
