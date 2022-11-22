package com.epa.epadiplom.DAO.Dao;

import com.epa.epadiplom.entities.NoticeEvent;

import java.util.List;

public interface NoticeEventDAO {
    List<NoticeEvent> findComplicatedReqFE(long id);
    List<NoticeEvent> findByIdList(long id);
    NoticeEvent findById(long id);
    List<NoticeEvent> findAll();
    void update(NoticeEvent noticeEvent);
    void create(NoticeEvent noticeEvent);
    void delete(long id);
}
