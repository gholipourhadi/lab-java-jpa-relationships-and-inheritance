package com.example.week8lab.controller;

import com.example.week8lab.dto.EventDTO;
import com.example.week8lab.model.Event;
import com.example.week8lab.model.Guest;
import com.example.week8lab.model.GuestStatus;
import com.example.week8lab.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(eventDTO));
    }

    @GetMapping("/guests/status/{status}")
    public ResponseEntity<List<Guest>> findGuestsByStatus(@PathVariable GuestStatus status) {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findGuestsByStatus(status));
    }
}
