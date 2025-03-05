package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;

public class EditEventController {
    private EventDao eventDao;

    public EditEventController() {
        this.eventDao = new EventDaoImpl();
    }
    
    public void updateEvent(int id, int userId, String title, String description, String state, String createdAt, String startDate, String endDate, String location) {
        Event updatedEvent = new Event(id, userId, title, description, state, createdAt, startDate, endDate, location);
        eventDao.updateEvent(updatedEvent);
    }
}
