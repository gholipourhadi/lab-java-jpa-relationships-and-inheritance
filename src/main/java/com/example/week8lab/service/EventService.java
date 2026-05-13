package com.example.week8lab.service;

import com.example.week8lab.dto.EventDTO;
import com.example.week8lab.dto.GuestDTO;
import com.example.week8lab.dto.SpeakerDTO;
import com.example.week8lab.model.Conference;
import com.example.week8lab.model.Event;
import com.example.week8lab.model.Exhibition;
import com.example.week8lab.model.Guest;
import com.example.week8lab.model.GuestStatus;
import com.example.week8lab.model.Speaker;
import com.example.week8lab.repository.EventRepository;
import com.example.week8lab.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestRepository guestRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(EventDTO eventDTO) {
        Event event;

        if ("conference".equalsIgnoreCase(eventDTO.getType())) {
            Conference conference = new Conference();

            for (SpeakerDTO speakerDTO : eventDTO.getSpeakers()) {
                Speaker speaker = new Speaker();
                speaker.setName(speakerDTO.getName());
                speaker.setPresentationDuration(speakerDTO.getPresentationDuration());
                conference.getSpeakers().add(speaker);
            }

            event = conference;
        } else {
            event = new Exhibition();
        }

        event.setTitle(eventDTO.getTitle());
        event.setDate(eventDTO.getDate());
        event.setDuration(eventDTO.getDuration());
        event.setLocation(eventDTO.getLocation());

        for (GuestDTO guestDTO : eventDTO.getGuests()) {
            Guest guest = new Guest();
            guest.setName(guestDTO.getName());
            guest.setStatus(guestDTO.getStatus());
            event.getGuests().add(guest);
        }

        return eventRepository.save(event);
    }

    public List<Guest> findGuestsByStatus(GuestStatus status) {
        return guestRepository.findByStatus(status);
    }
}
