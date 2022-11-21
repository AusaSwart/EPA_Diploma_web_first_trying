package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Document;

import java.util.List;

public interface DocumentDAO {

    public Document findById(long id);
    public List<Document> findAll();
    public Document update(Document dto);
    public Document create(Document dto);
    public void delete(long id);
}
