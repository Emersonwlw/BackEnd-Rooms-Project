package com.dio.crud.salareuniao.salaDeReuniao.controller;

import com.dio.crud.salareuniao.salaDeReuniao.exception.ResourceNotFoundException;
import com.dio.crud.salareuniao.salaDeReuniao.model.Room;
import com.dio.crud.salareuniao.salaDeReuniao.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }


    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId) throws ResourceNotFoundException {
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(()-> new ResourceNotFoundException("Room not found:: "+ roomId));

            return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom( @Valid @RequestBody Room room){
        return roomRepository.save(room);
    }


    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id")Long roomId, @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found with id::"+ roomId));

        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setEndHour(roomDetails.getEndHour());
        room.setStarHour(roomDetails.getStarHour());

        final Room updateRoom = roomRepository.save(room);

        return ResponseEntity.ok(updateRoom);

    }


     @DeleteMapping("rooms/{id}")
     public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found with id::"+ roomId));


        roomRepository.delete(room);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }


}
