package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.MainInfo;

import java.util.List;

public interface MainInfoDAO {
    public MainInfo findById(long id);
    public List<MainInfo> findAllInList();
    public List<MainInfo> findAll();
    public MainInfo update(MainInfo dto);
    public MainInfo create(MainInfo dto);
    public void delete(long id);
}
