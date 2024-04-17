package com.que.quevent.services;

import com.que.quevent.model.Attendee;
import com.que.quevent.repositories.AttendeeRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public void addNewAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void updateAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Attendee attendee) {
        attendeeRepository.delete(attendee);
    }

    public void deleteAttendeeById(long id) {
        attendeeRepository.deleteById(id);
    }
}
