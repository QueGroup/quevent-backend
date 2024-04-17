package com.que.quevent.controllers;

import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import com.que.quevent.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/event")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @GetMapping("/event")
    public Event getEventById(@RequestParam long eventId) {
        return eventService.getEventById(eventId);
    }

    @DeleteMapping("/event")
    public void deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }

    @DeleteMapping("/event/delete-by-id")
    public void deleteEventById(@RequestParam long eventId) {
        eventService.deleteEventById(eventId);
    }

    @PutMapping("/event")
    public void uodateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
    }

    @GetMapping("/event/get-attendees")
    public List<Attendee> getEttendeesByEventId(@RequestParam long eventId) {
        return eventService.findAttendeesByEventId(eventId);
    }

    @GetMapping("/event/get-filtered-events")
    public List<Event> getFilteredEvents(String[] locations, String[] categories, int startAgeLimit, int endAgeLimit) {
        return eventService.getEventsByFilters(startAgeLimit, endAgeLimit, locations, categories);
    }
}
