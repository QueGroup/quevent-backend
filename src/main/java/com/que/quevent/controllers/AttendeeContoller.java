package com.que.quevent.controllers;

import com.que.quevent.model.Attendee;
import com.que.quevent.services.AttendeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendeeContoller {

    private final AttendeeService attendeeService;

    public AttendeeContoller(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping("/attendees")
    public void addAttendee(@RequestBody Attendee attendee) {
        attendeeService.addNewAttendee(attendee);
    }

    @DeleteMapping("/attendees")
    public void deleteAttendee(@RequestBody Attendee attendee) {
        attendeeService.deleteAttendee(attendee);
    }

    @PutMapping("/attendees")
    public void updateAttendee(@RequestBody Attendee attendee) {
        attendeeService.updateAttendee(attendee);
    }

    @DeleteMapping("/attendees/{id}")
    public void deleteAttendeeById(@PathVariable long id) {
        attendeeService.deleteAttendeeById(id);
    }
}
