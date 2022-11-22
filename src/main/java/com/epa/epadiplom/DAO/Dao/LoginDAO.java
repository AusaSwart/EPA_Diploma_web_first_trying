package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Login;

import java.util.List;
public interface LoginDAO {
    Login findById(long id);
    Login checkPassLog(String loginUser, String passwordUser);
    Login checkLogin(String loginUser);
    List<Login> findAll();
    void update(Login login);
    void create(Login login);
    void delete(long id);
}
