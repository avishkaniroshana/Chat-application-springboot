package com.chatapp.chat_app_backend.repository;

import com.chatapp.chat_app_backend.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository  extends MongoRepository<Room, String> {
    //Get room using room id
    Room findByRoomId(String roomId);


}
