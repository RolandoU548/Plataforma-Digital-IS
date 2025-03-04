package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

import java.util.List;

public class ModerationController {
    private EventDao eventDao;
    private PublicationDao publicationDao;

    public ModerationController() {
        this.eventDao = new EventDaoImpl();
        this.publicationDao = new PublicationDaoImpl();
    }

    public List<Publication> getPublications() {
        return publicationDao.getAllPublicationsByState("in moderation");
    }

    public List<Event> getEvents() {
        return eventDao.getAllEventsByState("in moderation");
    }
}