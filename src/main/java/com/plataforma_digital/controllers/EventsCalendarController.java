package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsCalendarController {
    private EventDao eventDao;

    public EventsCalendarController() {
        this.eventDao = new EventDaoImpl();
    }

    public List<Date> getHighlightedDates() {
        List<Date> highlightedDates = new ArrayList<>();
        List<Event> events = eventDao.getAllEventsByState("approved");
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (Event event : events) {
                Date date = originalFormat.parse(event.getStartDate());
                String formattedDate = targetFormat.format(date);
                highlightedDates.add(targetFormat.parse(formattedDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return highlightedDates;
    }
}