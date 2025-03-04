package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.User;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

public class UserCommentController {
    private UserDao userDao;

    public UserCommentController() {
        this.userDao = new UserDaoImpl();
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }
}