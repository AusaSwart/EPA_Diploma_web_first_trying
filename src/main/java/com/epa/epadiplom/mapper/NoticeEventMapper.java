package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.NoticeEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeEventMapper implements RowMapper<NoticeEvent> {
    public NoticeEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        NoticeEvent noticeEvent = new NoticeEvent();
        noticeEvent.setId(resultSet.getLong("id_recipient"));
        noticeEvent.setIdEvent(resultSet.getLong("id_event"));
        noticeEvent.setIdEmployee(resultSet.getLong("id_employee"));
        return noticeEvent;
    }
}
