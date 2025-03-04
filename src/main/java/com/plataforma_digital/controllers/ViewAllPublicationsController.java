package com.plataforma_digital.controllers;

import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

import java.util.List;

public class ViewAllPublicationsController {
    private PublicationDao publicationDao;

    public ViewAllPublicationsController() {
        this.publicationDao = new PublicationDaoImpl();
    }

    public List<Publication> getApprovedPublications() {
        return publicationDao.getAllPublicationsByState("approved");
    }
}