package com.plataforma_digital.database.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plataforma_digital.database.DatabaseConnection;
import com.plataforma_digital.database.EventDao;
import com.plataforma_digital.entities.Event;

public class EventDaoImpl implements EventDao {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public void createEvent(Event event) {
        String sql = "INSERT INTO events (user_id, title, description, state, start_date, end_date, location) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int generatedId = db.executePreparedStatementWithGeneratedKeys(sql, String.valueOf(event.getUserId()),
                event.getTitle(),
                event.getDescription(), event.getState(), event.getStartDate(), event.getEndDate(),
                event.getLocation());
        if (generatedId != -1) {
            event.setId(generatedId);
        }
    }

    public Event getEventById(int id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        Event event = null;
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(id))) {
            if (rs != null && rs.next()) {
                event = new Event(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"),
                        rs.getString("start_date"),
                        rs.getString("end_date"), rs.getString("location"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return event;
    }

    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM events";
        List<Event> events = new ArrayList<>();
        try (ResultSet rs = db.executeSelectStatement(sql)) {
            while (rs != null && rs.next()) {
                Event event = new Event(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"),
                        rs.getString("start_date"),
                        rs.getString("end_date"), rs.getString("location"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return events;
    }

    public List<Event> getAllEventsByState(String state) {
        String sql = "SELECT * FROM events WHERE state = ?";
        List<Event> events = new ArrayList<>();
        try (ResultSet rs = db.executePreparedSelectStatement(sql, state)) {
            while (rs != null && rs.next()) {
                Event event = new Event(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"),
                        rs.getString("start_date"),
                        rs.getString("end_date"), rs.getString("location"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return events;
    }

    public List<Event> getAllEventsByUserId(int userId) {
        String sql = "SELECT * FROM events WHERE user_id = ?";
        List<Event> events = new ArrayList<>();
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(userId))) {
            while (rs != null && rs.next()) {
                Event event = new Event(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"),
                        rs.getString("start_date"),
                        rs.getString("end_date"), rs.getString("location"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return events;
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE events SET title = ?, description = ?, state = ?, start_date = ?, end_date = ?, location = ? WHERE id = ?";
        db.executePreparedStatement(sql, event.getTitle(), event.getDescription(), event.getState(),
                event.getStartDate(),
                event.getEndDate(), event.getLocation(),
                String.valueOf(event.getId()));
    }

    public void deleteEventById(int id) {
        String sql = "DELETE FROM events WHERE id = ?";
        db.executePreparedStatement(sql, String.valueOf(id));
    }
}
