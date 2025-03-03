package com.plataforma_digital.models.database;

import com.plataforma_digital.models.User;

public interface UserDao {
    void createUser(User user);

    User getUserById(int id);

    User getUserByEmail(String email);

    void updateUser(User user);

    void deleteUserById(int id);

    User authenticateUser(String email, String password);
}
