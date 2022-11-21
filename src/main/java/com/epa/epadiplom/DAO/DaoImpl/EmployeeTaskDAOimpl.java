//package com.epa.epadiplom.DAO.DaoImpl;
//
//import com.epa.epadiplom.DAO.Dao.EmployeeTaskDAO;
//import com.epa.epadiplom.entities.EmployeeTask;
//import com.epa.epadiplom.entities.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class EmployeeTaskDAOimpl implements EmployeeTaskDAO {
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    public EmployeeTaskDAO(Connection connection) {
//        super(connection);
//    }
//    private static final String GET_ONE = "SELECT id_executor, id_employee, id_task," +
//            " comment_te FROM emp_task WHERE id_executor=?";
//    private static final String CHECK = "SELECT * FROM emp_task WHERE id_executor=? " +
//            "AND id_task = ?";
//    private static final String DELETE = "DELETE FROM emp_task WHERE id_executor = ?";
//    private static final String UPDATE = "UPDATE emp_task SET id_employee = ?, id_task = ?, " +
//            "comment_te = ? WHERE id_executor = ?";
//    private static final String INSERT = "INSERT INTO emp_task (id_executor, id_employee, id_task," +
//            " comment_te) VALUES (?, ?, ?, ?)";
//    private static final String GET_COMPLICATED = "SELECT et.id_executor, et.comment_te," +
//            " et.id_employee, et.id_task, t.date_task FROM public.emp_task et JOIN " +
//            "public.task t ON et.id_task = t.id WHERE id_executor = ? ";
//
//    public EmployeeTask findComplicatedReq(long id) {
//        EmployeeTask employeeTask = new EmployeeTask();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_COMPLICATED);){
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            List<EmployeeTask> employeeTasks = new ArrayList<>();
//            List<Task> tasks = new ArrayList<>();
//            while(rs.next()){
//                employeeTask = new EmployeeTask();
//                Task task = new Task();
//                employeeTask.setId(rs.getLong(1));
//                employeeTask.setCommentTE(rs.getString(2));
//                employeeTask.setIdEmployee(rs.getLong(3));
//                employeeTask.setIdTask(rs.getLong(4));
//                task.setId(rs.getLong("id_task"));
//                task.setDateTask(rs.getDate(5));
//                tasks.add(task);
//                employeeTasks.add(employeeTask);
//            }
//            employeeTask.setTasks(tasks);
//            employeeTask.setEmployeeTasks(employeeTasks);
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return employeeTask;
//    }
//
//    public EmployeeTask findById(long id) {
//        EmployeeTask employeeTask = new EmployeeTask();
//        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);){
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                employeeTask.setId(rs.getLong("id_executor"));
//                employeeTask.setIdEmployee(rs.getLong("id_employee"));
//                employeeTask.setIdTask(rs.getLong("id_task"));
//                employeeTask.setCommentTE(rs.getString("comment_te"));
//
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return employeeTask;
//    }
//
//    public List<EmployeeTask> findAll() {
//        return null;
//    }
//
//    public EmployeeTask update(EmployeeTask dto) {
//        EmployeeTask employeeTask = null;
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
//            statement.setLong(1, dto.getIdEmployee());
//            statement.setLong(2, dto.getIdTask());
//            statement.setString(2, dto.getCommentTE());
//            statement.setLong(2, dto.getId());
//            statement.execute();
//            this.connection.commit();
//            employeeTask = this.findById(dto.getId());
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
//        return employeeTask;
//    }
//
//    public EmployeeTask create(EmployeeTask dto) {
//        EmployeeTask employeeTask = new EmployeeTask();
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
//            statement.setLong(1, dto.getId());
//            statement.setLong(2, dto.getIdEmployee());
//            statement.setLong(3, dto.getIdTask());
//            statement.setString(4, dto.getCommentTE());
//            statement.execute();
//            this.connection.commit();
//        } catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return employeeTask;
//    }
//
//    @Override
//    public void delete(long id) {
//        try{
//            this.connection.setAutoCommit(false);
//        }catch(SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);){
//            statement.setLong(1, id);
//            statement.executeUpdate();
//            this.connection.commit();
//        }catch (SQLException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//}
