package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.EventDao;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.database.impl.EventDaoImpl;
import com.plataforma_digital.models.database.impl.PublicationDaoImpl;

public class ModerationItemController {
    private EventDao eventDao;
    private PublicationDao publicationDao;

    public ModerationItemController() {
        this.eventDao = new EventDaoImpl();
        this.publicationDao = new PublicationDaoImpl();
    }

    public void approvePublication(Publication publication) {
        publication.setState("approved");
        if (publication instanceof Event) {
            eventDao.updateEvent((Event) publication);
        } else {
            publicationDao.updatePublication(publication);
        }
    }

    public void rejectPublication(Publication publication) {
        publication.setState("rejected");
        if (publication instanceof Event) {
            eventDao.updateEvent((Event) publication);
        } else {
            publicationDao.updatePublication(publication);
        }
    }
}