package com.plataforma_digital.entities;

public class Comment {
    private int id;
    private int userId;
    private int publicationId;
    private int eventId;
    private String text;
    private String createdAt;

    public Comment(int id, int userId, int publicationId, int eventId, String text, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.publicationId = publicationId;
        this.eventId = eventId;
        this.text = text;
        this.createdAt = createdAt;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public int getEventId() {
        return eventId;
    }

    public String getText() {
        return text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}