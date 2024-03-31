package com.que.quevent.repositories;

import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT a FROM Attendee a WHERE a.event = :eventId")
    List<Attendee> findAttendeesByEventId(long eventId);
}
