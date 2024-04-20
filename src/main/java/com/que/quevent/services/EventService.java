package com.que.quevent.services;

import com.que.quevent.exeptions.EventAlreadyExistsException;
import com.que.quevent.exeptions.EventNotExistsException;
import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import com.que.quevent.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(Event event) {
        if (eventRepository.existsById(event.getId())) {
            throw new EventAlreadyExistsException("Такое мероприятие уже существует");
        }
        eventRepository.save(event);
    }

    public void deleteEvent(Event event) {
        if (eventRepository.existsById(event.getId())) {
            eventRepository.delete(event);
        }
        throw new EventNotExistsException("Такого мероприятия не существует");
    }

    public void deleteEventById(long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
        }
        throw new EventNotExistsException("Такого мероприятия не существует");

    }

    public Event getEventById(long eventId) {
        var event = eventRepository.findById(eventId);
        if (event.isEmpty()) {
            throw new EventNotExistsException("Такого мероприятия не существует");
        }
        return event.get();
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Attendee> findAttendeesByEventId(long eventId) {
        return eventRepository.findAttendeesByEventId(eventId);
    }

    public List<Event> getEventsByFilters(int startAgeLimit, int endAgeLimit, String[] locations, String[] categories) {
        var filteredEvents = new ArrayList<Event>();

        if (locations.length != 0) {
            filteredEvents.addAll(getEventsByLocations(locations));
        }
        if (categories.length != 0) {
            filteredEvents.addAll(getEventsByCategory(categories));
        }
        if (startAgeLimit != 0 && endAgeLimit != 0) {
            filteredEvents.addAll(getEventsByAgeLimit(startAgeLimit, endAgeLimit));
        }


        return new ArrayList<>(new HashSet<>(filteredEvents));
    }

    private List<Event> getEventsByAgeLimit(int startAgeLimit, int endAgeLimit) {
        return eventRepository.findEventByAgeLimit(startAgeLimit, endAgeLimit);
    }

    private List<Event> getEventsByLocations(String[] locations) {
        var EventsForLocations = new ArrayList<Event>();
        Arrays.stream(locations).forEach(x -> EventsForLocations.addAll(eventRepository.findEventByLocation(x)));

        return EventsForLocations;
    }

    private List<Event> getEventsByCategory(String[] categories) {
        var EventsForCategories = new ArrayList<Event>();
        Arrays.stream(categories).forEach(x -> EventsForCategories.addAll(eventRepository.findEventByCategory(x)));

        return EventsForCategories;
    }
}
