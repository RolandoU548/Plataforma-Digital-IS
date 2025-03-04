package com.plataforma_digital.controllers;

import com.plataforma_digital.views.*;

public class NavigationController {
    private Home home;

    public NavigationController(Home home) {
        this.home = home;
    }

    public void showViewAllPublications() {
        ViewAllPublications viewAllPublications = new ViewAllPublications(home);
        home.viewAllPublications = viewAllPublications;
        home.addAndShowPanel(viewAllPublications, "viewAllPublications");
    }

    public void showEventsCalendar() {
        EventsCalendar eventsCalendar = new EventsCalendar(home);
        home.eventsCalendar = eventsCalendar;
        home.addAndShowPanel(eventsCalendar, "eventsCalendar");
    }

    public void showModeration() {
        Moderation moderation = new Moderation(home);
        home.moderation = moderation;
        home.addAndShowPanel(moderation, "moderation");
    }

    public void showCreateEvent() {
        CreateEvent createEvent = new CreateEvent(home);
        home.createEvent = createEvent;
        home.addAndShowPanel(createEvent, "createEvent");
    }

    public void showCreatePublication() {
        CreatePublication createPublication = new CreatePublication(home);
        home.createPublication = createPublication;
        home.addAndShowPanel(createPublication, "createPublication");
    }
}