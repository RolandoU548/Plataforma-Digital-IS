package com.plataforma_digital.controllers;

import com.plataforma_digital.models.User;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

public class ViewPublicationController {
    private UserDao userDao;

    public ViewPublicationController() {
        this.userDao = new UserDaoImpl();
    }

    public User getPublicationAuthor(int userId) {
        return userDao.getUserById(userId);
    }
}