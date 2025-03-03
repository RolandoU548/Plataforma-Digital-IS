package com.plataforma_digital.controllers;

import javax.swing.JOptionPane;

import com.plataforma_digital.models.CurrentUser;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;

public class CreateEventController {
    private EventDao eventDao;

    public CreateEventController() {
        this.eventDao = new EventDaoImpl();
    }

    public boolean createEvent(String title, String description, String startDate, String endDate, String location) {
        Event newEvent = new Event(0, CurrentUser.getCurrentUser().getId(), title, description, "in moderation", null,
                startDate, endDate, location);
        eventDao.createEvent(newEvent);
        JOptionPane.showMessageDialog(null,
                "Tu evento está pendiente de moderación, será publicado en cuanto sea aprobado",
                "Evento creado",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}