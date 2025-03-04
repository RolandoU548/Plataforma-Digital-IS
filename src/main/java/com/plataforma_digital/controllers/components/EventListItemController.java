package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;

public class EventListItemController {
    private EventDao eventDao;

    public EventListItemController() {
        this.eventDao = new EventDaoImpl();
    }

    public void deleteEvent(Event event) {
        eventDao.deleteEventById(event.getId());
    }
}