package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Contact;

import java.util.List;

public interface ContactDAO {
    public Contact checkMail(String mail);
    public List<Contact> findAllInList();
    public Contact findById(long id);
    public List<Contact> findAll();
    public Contact update(Contact dto);
    public Contact create(Contact dto);
    public void delete(long id);
}
