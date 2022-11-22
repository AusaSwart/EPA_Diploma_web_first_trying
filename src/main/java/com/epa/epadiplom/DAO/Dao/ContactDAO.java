package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Contact;

import java.util.List;

public interface ContactDAO {
    Contact checkMail(String mail);
    Contact findById(long id);
    List<Contact> findAll();
    void update(Contact contact);
    void create(Contact contact);
    void delete(long id);
}
