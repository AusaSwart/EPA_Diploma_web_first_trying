package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.MainInfo;

import java.util.List;

public interface MainInfoDAO {
    MainInfo findById(long id);
    List<MainInfo> findAll();
    void update(MainInfo mainInfo);
    void create(MainInfo mainInfo);
    void delete(long id);
}
