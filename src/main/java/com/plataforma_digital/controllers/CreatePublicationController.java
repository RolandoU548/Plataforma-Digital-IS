package com.plataforma_digital.controllers;

import javax.swing.JOptionPane;

import com.plataforma_digital.models.CurrentUser;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

public class CreatePublicationController {
    private PublicationDao publicationDao;

    public CreatePublicationController() {
        this.publicationDao = new PublicationDaoImpl();
    }

    public boolean createPublication(String title, String description) {
        Publication newPublication = new Publication(0, CurrentUser.getCurrentUser().getId(), title, description,
                "in moderation", null);
        publicationDao.createPublication(newPublication);
        JOptionPane.showMessageDialog(null,
                "Tu publicación está pendiente de moderación, será publicada en cuanto sea aprobada",
                "Publicación creada",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}