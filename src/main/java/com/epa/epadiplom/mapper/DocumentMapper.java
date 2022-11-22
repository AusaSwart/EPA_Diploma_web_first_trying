package com.epa.epadiplom.mapper;

import com.epa.epadiplom.entities.Document;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentMapper implements RowMapper<Document> {
    public Document mapRow(ResultSet resultSet, int i) throws SQLException {
        Document document = new Document();
        document.setId(resultSet.getLong("id"));
        document.setId_LS(resultSet.getLong("id_ls"));
        document.setBodyDoc(resultSet.getString("body_doc"));
        return document;
    }
}
