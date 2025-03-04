package com.plataforma_digital.controllers;

import javax.swing.JOptionPane;

import com.plataforma_digital.models.CurrentUser;
import com.plataforma_digital.models.User;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;

public class EditProfileController {
    private UserDao userDao;

    public EditProfileController() {
        this.userDao = new UserDaoImpl();
    }

    public void updateProfileInfo(String email, String firstName, String lastName, String password) {
        User updatedUser = new User(CurrentUser.getCurrentUser().getId(), email, firstName, lastName,
                CurrentUser.getCurrentUser().getRole(), password);
        userDao.updateUser(updatedUser);
        CurrentUser.setCurrentUser(updatedUser);
        System.out.println("User info has been updated");
        JOptionPane.showMessageDialog(null, "Los datos del usuario se han actualizado!", "Datos actualizados",
                JOptionPane.INFORMATION_MESSAGE);
    }
}