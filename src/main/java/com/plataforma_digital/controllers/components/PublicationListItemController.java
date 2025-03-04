package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

public class PublicationListItemController {
    private PublicationDao publicationDao;

    public PublicationListItemController() {
        this.publicationDao = new PublicationDaoImpl();
    }

    public void deletePublication(Publication publication) {
        publicationDao.deletePublicationById(publication.getId());
    }
}