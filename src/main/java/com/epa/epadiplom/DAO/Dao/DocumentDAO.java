package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Document;

import java.util.List;

public interface DocumentDAO {

    Document findById(long id);
    List<Document> findAll();
    void update(Document dto);
    void create(Document dto);
    void delete(long id);
}
