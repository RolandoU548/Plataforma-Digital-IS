package com.plataforma_digital.models.database;

import java.util.List;

import com.plataforma_digital.models.Event;

public interface EventDao {
    public void createEvent(Event event);

    public Event getEventById(int id);

    public List<Event> getAllEvents();

    public List<Event> getAllEventsByState(String state);

    public List<Event> getAllEventsByUserId(int userId);

    public void updateEvent(Event event);

    public void deleteEventById(int id);
}
