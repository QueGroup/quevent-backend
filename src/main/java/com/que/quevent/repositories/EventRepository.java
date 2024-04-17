package com.que.quevent.repositories;

import com.que.quevent.model.Attendee;
import com.que.quevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT a FROM Attendee a WHERE a.event = :eventId")
    List<Attendee> findAttendeesByEventId(@Param("eventId") long eventId);

    @Query("SELECT e FROM Event e WHERE e.startAgeLimit >= :startAgeLimit AND e.endAgeLimit <= :endAgeLimit")
    List<Event> findEventByAgeLimit(@Param("startAgeLimit") int startAgeLimit, @Param("endAgeLimit") int endAgeLimit);

    @Query("SELECT e FROM Event e WHERE e.location = :location")
    List<Event> findEventByLocation(String location);

    @Query("SELECT e FROM Event e WHERE e.type = :category")
    List<Event> findEventByCategory(@Param("category") String category);
}
