package com.que.quevent.controllers;

import com.que.quevent.model.Attendee;
import com.que.quevent.services.AttendeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendeeContoller {

    private final AttendeeService attendeeService;

    public AttendeeContoller(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping("/attendee")
    public void addAttendee(@RequestBody Attendee attendee) {
        attendeeService.addNewAttendee(attendee);
    }

    @DeleteMapping("/attendee")
    public void deleteAttendee(@RequestBody Attendee attendee) {
        attendeeService.deleteAttendee(attendee);
    }

    @PutMapping("/attendee")
    public void updateAttendee(@RequestBody Attendee attendee) {
        attendeeService.updateAttendee(attendee);
    }

    @DeleteMapping("/attendee/delete-by-id")
    public void deleteAttendeeById(@RequestParam long id) {
        attendeeService.deleteAttendeeById(id);
    }
}
