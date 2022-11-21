package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.Login;

import java.util.List;
public interface LoginDAO {

    public Login findById(long id);
    public Login checkPassLog(String loginUser, String passwordUser);
    public Login checkLogin(String loginUser);
    public List<Login> findAll();
    public Login update(Login dto);
    public Login create(Login dto);
    public void delete(long id);
}
