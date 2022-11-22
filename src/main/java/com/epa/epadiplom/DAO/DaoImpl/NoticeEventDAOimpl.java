package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.NoticeEventDAO;
import com.epa.epadiplom.entities.NoticeEvent;
import com.epa.epadiplom.entities.Event;
import com.epa.epadiplom.mapper.EventMapper;
import com.epa.epadiplom.mapper.NoticeEventMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeEventDAOimpl implements NoticeEventDAO {

    public final JdbcTemplate jdbcTemplate;
    private static final String GET_ALL = "SELECT * FROM notice_event";
    private static final String GET_ONE = "SELECT id_recipient, id_event, id_employee " +
            " FROM notice_event WHERE id_recipient = ?";
    private static final String DELETE = "DELETE FROM notice_event WHERE id_recipient = ?";
    private static final String UPDATE = "UPDATE notice_event SET id_event = ?, id_employee = ?" +
            " WHERE id_recipient = ?";
    private static final String INSERT = "INSERT INTO notice_event (id_recipient, id_event, id_employee) " +
            "VALUES (?, ?, ?)";
    private static final String GET_COMPLICATED_FE = "SELECT ne.id_recipient, ne.id_employee," +
            " ne.id_event, e.type_of_event, e.date_of_event, e.comment_fe FROM" +
            " public.notice_event ne JOIN public.event e ON ne.id_event =" +
            " e.id WHERE id_recipient = ? ";

    public NoticeEventDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<NoticeEvent> findByIdList(long id){
        return jdbcTemplate.query(GET_ONE, new NoticeEventMapper(), id);
    }
    public NoticeEvent findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new NoticeEventMapper(), id);
    }
    public List<NoticeEvent> findAll() {
        return jdbcTemplate.query(GET_ALL, new NoticeEventMapper());
    }
    public void update(NoticeEvent noticeEvent) {
       jdbcTemplate.update(UPDATE, noticeEvent.getIdEvent(),
               noticeEvent.getIdEmployee(), noticeEvent.getId());
    }
    public void create(NoticeEvent noticeEvent) {
        jdbcTemplate.update(INSERT, noticeEvent.getId(), noticeEvent.getIdEvent(),
                noticeEvent.getIdEmployee());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
    public List<NoticeEvent> findComplicatedReqFE(long id) {
        NoticeEvent noticeEvent = new NoticeEvent();
        Event event = new Event();
        return jdbcTemplate.query(GET_COMPLICATED_FE, new NoticeEventMapper(), new EventMapper(),
                noticeEvent.getId(), noticeEvent.getIdEmployee(), noticeEvent.getIdEvent(),
                event.getTypeOfEvent(), event.getDateOfEvent(), event.getCommentFE(), id);
    }
}
