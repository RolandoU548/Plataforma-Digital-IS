package com.plataforma_digital.controllers;

import com.plataforma_digital.models.User;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

import javax.swing.JOptionPane;

public class RegisterController {
    private UserDao userDao;

    public RegisterController() {
        this.userDao = new UserDaoImpl();
    }

    public boolean registerUser(String email, String firstName, String lastName, String password, String role) {
        switch (role) {
            case "Estudiante":
                role = "Student";
                break;
            case "Profesor":
                role = "Professor";
                break;
            case "Personal administrativo":
                role = "Administrative Staff";
                break;
            default:
                System.out.println("Role wasn't recognized");
        }

        if (userDao.getUserByEmail(email) != null) {
            JOptionPane.showMessageDialog(null,
                    "Utiliza otro correo electrónico",
                    "Correo ya registrado",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        User user = new User(0, email, firstName, lastName, role, password);
        userDao.createUser(user);
        JOptionPane.showMessageDialog(null,
                "Usuario '" + email + "' registrado exitosamente. Por favor inicia sesión",
                "Usuario registrado",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}