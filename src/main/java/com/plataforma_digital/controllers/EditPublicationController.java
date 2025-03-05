package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

public class EditPublicationController {
    private PublicationDao publicationDao;

    public EditPublicationController() {
        this.publicationDao = new PublicationDaoImpl();
    }

    public void updatePublication(int id, int userId, String title, String description, String state, String createdAt) {
        Publication updatedPublication = new Publication(id, userId, title, description, state, createdAt);
        publicationDao.updatePublication(updatedPublication);
    }
}
