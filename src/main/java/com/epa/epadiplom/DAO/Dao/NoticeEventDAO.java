package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.NoticeEvent;

import java.util.List;

public interface NoticeEventDAO {
    public NoticeEvent findComplicatedReqFE(long id);
    public List<NoticeEvent> findByIdList(long id);
    public NoticeEvent findById(long id);
    public List<NoticeEvent> findAll();
    public NoticeEvent update(NoticeEvent dto);
    public NoticeEvent create(NoticeEvent dto);
    public void delete(long id);
}
