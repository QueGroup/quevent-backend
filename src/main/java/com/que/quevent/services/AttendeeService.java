package com.que.quevent.services;

import com.que.quevent.exeptions.AttendeeAlreadyExistsException;
import com.que.quevent.exeptions.AttendeeNotExistsException;
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
        if (attendeeRepository.existsById(attendee.getId())) {
            throw new AttendeeAlreadyExistsException("Такой участник уже существует");
        }
        attendeeRepository.save(attendee);
    }

    public void updateAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Attendee attendee) {
        if (attendeeRepository.existsById(attendee.getId())) {
            attendeeRepository.delete(attendee);
        }
        throw new AttendeeNotExistsException("Такого участника не существует");
    }

    public void deleteAttendeeById(long id) {
        if (attendeeRepository.existsById(id)) {
            attendeeRepository.deleteById(id);
        }
        throw new AttendeeNotExistsException("Такого участника не существует");

    }
}
