package com.que.quevent.controllers;

import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import com.que.quevent.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @PostMapping("/events")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable long eventId) {
        return eventService.getEventById(eventId);
    }

    @DeleteMapping("/events")
    public void deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEventById(@PathVariable long eventId) {
        eventService.deleteEventById(eventId);
    }

    @PutMapping("/events")
    public void uodateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
    }

    @GetMapping("/events/{id}/attendees")
    public List<Attendee> getEttendeesByEventId(@RequestParam long eventId) {
        return eventService.findAttendeesByEventId(eventId);
    }

    @GetMapping("/events")
    public List<Event> getFilteredEvents(String[] locations, String[] categories, int startAgeLimit, int endAgeLimit) {
        return eventService.getEventsByFilters(startAgeLimit, endAgeLimit, locations, categories);
    }
}
