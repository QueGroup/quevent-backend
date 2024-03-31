package com.que.quevent.services;

import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import com.que.quevent.model.User;
import com.que.quevent.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    public void deleteEventById(long eventId) {
        eventRepository.deleteById(eventId);
    }

    public Event getEventById(long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Attendee> findAttendeesByEventId(long eventId) {
        return eventRepository.findAttendeesByEventId(eventId);
    }
}
