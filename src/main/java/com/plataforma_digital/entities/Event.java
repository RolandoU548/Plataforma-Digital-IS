package com.plataforma_digital.entities;

public class Event extends Publication {
    private String startDate;
    private String endDate;
    private String location;

    public Event(int id, int userId, String title, String description, String state, String createdAt, String startDate,
            String endDate,
            String location) {
        super(id, userId, title, description, state, createdAt);
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    // Getters
    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    // Setters
    public void setsStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
