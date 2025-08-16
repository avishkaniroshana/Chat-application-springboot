package com.chatapp.chat_app_backend.controller;

import com.chatapp.chat_app_backend.entity.Message;
import com.chatapp.chat_app_backend.entity.Room;
import com.chatapp.chat_app_backend.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //Create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestParam String roomId) {
        if (roomRepository.findByRoomId(roomId) != null) {
            return ResponseEntity.badRequest().body("Room already exists!");
        }

        //Create a new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    //Join an existing room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest().body("Room does not found!");
        }
        return ResponseEntity.ok(room);
    }

    //Get messages of a room with pagination
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "20", required = false) int size
    ) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        List<Message> paginatedMessages = messages.subList(start, end);

        return ResponseEntity.ok(paginatedMessages);
    }



    // Send message to a room
    @PostMapping("/{roomId}/messages")
    public ResponseEntity<?> sendMessage(
            @PathVariable String roomId,
            @RequestBody Message message
    ) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest().body("Room does not exist!");
        }

        // Add new message object (not string)
        room.getMessages().add(message);
        roomRepository.save(room);

        return ResponseEntity.ok("Message sent successfully!");
    }

}




















//1


//package com.chatapp.chat_app_backend.controller;
//import com.chatapp.chat_app_backend.entity.Message;
//
//import com.chatapp.chat_app_backend.entity.Room;
//import com.chatapp.chat_app_backend.repository.RoomRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/rooms")
//public class RoomController {
//
//    private RoomRepository roomRepository;
//
//    public RoomController(RoomRepository roomRepository) {
//        this.roomRepository = roomRepository;
//    }
//
//    //create room
//    @PostMapping
//    public Room createRoom(String roomId) {
//        if(roomRepository.findRoomId(roomId) != null) {
//            //room already exists
//            ResponseEntity.badRequest().body("Room already exists!");
//        }
//
//        Room room = new Room();
//        room.setRoomId(roomId);
//        Room savedRoom = roomRepository.save(room);
//        ResponseEntity.status(HttpStatus.CREATED).body(room);
//        return savedRoom;
//    }
//
//    //get room to join room
//    public ResponseEntity<?> joinRoom(
//            @PathVariable String roomId
//    ){
//        Room room = roomRepository.findRoomId(roomId);
//        if(room == null) {
//            return ResponseEntity.badRequest()
//                    .body("Room does not exist!");
//        }
//        return ResponseEntity.ok(room);
//    }
//
//    //get messages of room
//
//    @GetMapping("/{roomId}/messages")
//    public ResponseEntity<List<Message>> getMessages(
//            @PathVariable String roomId,
//            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
//            @RequestParam(value = "size", defaultValue = "20", required = false) int size
//    ) {
//        Room room = roomRepository.findRoomId(roomId);
//        if(room != null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        //get messages
//        //pagination
//        List <Message> messages = room.getMessages();
//        int start = Math.max(0,messages.size()-(page+1)*size);
//        int end = Math.min(messages.size(),start+size);
//        List<Message>paginatedMessages = messages.subList(start,end);
//        return ResponseEntity.ok(paginatedMessages);
//
//    }
//
//
//
//
//
//}
