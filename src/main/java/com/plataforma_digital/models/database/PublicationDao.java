package com.plataforma_digital.models.database;

import java.util.List;

import com.plataforma_digital.models.Publication;

public interface PublicationDao {

    public void createPublication(Publication publication);

    public Publication getPublicationById(int id);

    public List<Publication> getAllPublications();

    public List<Publication> getAllPublicationsByState(String state);

    public List<Publication> getAllPublicationsByUserId(int userId);

    public void updatePublication(Publication publication);

    public void deletePublicationById(int id);

}
