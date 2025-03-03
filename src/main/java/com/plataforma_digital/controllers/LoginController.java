package com.plataforma_digital.controllers;

import com.plataforma_digital.models.User;
import com.plataforma_digital.models.CurrentUser;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

import javax.swing.JOptionPane;

public class LoginController {
    private UserDao userDao;

    public LoginController() {
        this.userDao = new UserDaoImpl();
    }

    public boolean authenticateUser(String email, String password) {
        User user = userDao.authenticateUser(email, password);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "Contraseña o correo incorrectos", "Datos incorrectos",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        CurrentUser.setCurrentUser(user);
        JOptionPane.showMessageDialog(null, "Bienvenido, " + email + "!", "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}