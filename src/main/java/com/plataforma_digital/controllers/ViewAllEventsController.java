package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;

import java.util.List;

public class ViewAllEventsController {
    private EventDao eventDao;

    public ViewAllEventsController() {
        this.eventDao = new EventDaoImpl();
    }

    public List<Event> getApprovedEvents() {
        return eventDao.getAllEventsByState("approved");
    }
}