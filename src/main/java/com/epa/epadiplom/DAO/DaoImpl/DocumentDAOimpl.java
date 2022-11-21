//package com.epa.epadiplom.DAO.DaoImpl;
//
//import com.epa.epadiplom.DAO.Dao.DocumentDAO;
//import com.epa.epadiplom.entities.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class DocumentDAOimpl implements DocumentDAO {
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    public DocumentDAO(Connection connection) {
//        super(connection);
//    }
//    private static final String GET_ONE = "SELECT id, id_ls, body_doc FROM document WHERE id=?";
//    private static final String DELETE = "DELETE FROM document WHERE id = ?";
//    private static final String UPDATE = "UPDATE document SET id_ls = ?, body_doc = ? WHERE id = ?";
//    private static final String INSERT = "INSERT INTO document (id_ls, body_doc) VALUES (?, ?)";
//
//    public Document findById(long id) {
//        Document document = new Document();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                document.setId(rs.getLong("id"));
//                document.setId_LS(rs.getLong("id_ls"));
//                document.setBodyDoc(rs.getString("body_doc"));
//
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return document;
//    }
//
//    public List<Document> findAll() {
//        return null;
//    }
//
//    public Document update(Document dto) {
//        Document document = null;
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
//            statement.setLong(1, dto.getId_LS());
//            statement.setString(2, dto.getBodyDoc());
//            statement.setLong(3, dto.getId());
//            statement.execute();
//            this.connection.commit();
//            document = this.findById(dto.getId());
//        }catch(SQLException e){
//            try{
//                this.connection.rollback();
//            }catch (SQLException sqle){
//                e.printStackTrace();
//                throw new RuntimeException(sqle);
//            }
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return document;
//    }
//
//    public Document create(Document dto) {
//        Document document = null;
//        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
//            statement.setLong(1, dto.getId_LS());
//            statement.setString(2, dto.getBodyDoc());
//            statement.execute();
//            this.connection.commit();
//            document = this.findById(dto.getId());
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return document;
//    }
//
//    public void delete(long id) {
//        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
//            statement.setLong(1, id);
//            statement.execute();
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//}
