package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.DocumentDAO;
import com.epa.epadiplom.entities.Document;
import com.epa.epadiplom.mapper.DocumentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DocumentDAOimpl implements DocumentDAO {

    public final JdbcTemplate jdbcTemplate;

    private static final String GET_ALL = "SELECT * FROM document";
    private static final String GET_ONE = "SELECT id, id_ls, body_doc FROM document WHERE id = ?";
    private static final String DELETE = "DELETE FROM document WHERE id = ?";
    private static final String UPDATE = "UPDATE document SET id_ls = ?, body_doc = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO document (id_ls, body_doc) VALUES (?, ?)";

    public DocumentDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Document findById(long id){
        return jdbcTemplate.queryForObject(GET_ONE, new DocumentMapper(), id);
    }
    public List<Document> findAll() {
        return jdbcTemplate.query(GET_ALL, new DocumentMapper());
    }
    public void update(Document document) {
        jdbcTemplate.update(UPDATE, document.getId_LS(), document.getBodyDoc(), document.getId());
    }
    public void create(Document document) {
        jdbcTemplate.update(INSERT, document.getId_LS(), document.getBodyDoc());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
