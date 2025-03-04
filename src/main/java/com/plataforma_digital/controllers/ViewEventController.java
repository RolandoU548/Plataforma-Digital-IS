package com.plataforma_digital.controllers;

import com.plataforma_digital.models.User;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

public class ViewEventController {
    private UserDao userDao;

    public ViewEventController() {
        this.userDao = new UserDaoImpl();
    }

    public User getEventAuthor(int userId) {
        return userDao.getUserById(userId);
    }
}