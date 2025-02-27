package com.plataforma_digital.database;

import java.util.List;

import com.plataforma_digital.entities.Publication;

public interface PublicationDao {

    public void createPublication(Publication publication);

    public Publication getPublicationById(int id);

    public List<Publication> getAllPublications();

    public List<Publication> getAllPublicationsByState(String state);

    public List<Publication> getAllPublicationsByUserId(int userId);

    public void updatePublication(Publication publication);

    public void deletePublicationById(int id);

}
