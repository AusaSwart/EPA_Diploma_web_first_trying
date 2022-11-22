package com.epa.epadiplom.DAO.DaoImpl;

import com.epa.epadiplom.DAO.Dao.MainInfoDAO;
import com.epa.epadiplom.entities.MainInfo;
import com.epa.epadiplom.mapper.MainInfoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainInfoDAOimpl implements MainInfoDAO {

    public final JdbcTemplate jdbcTemplate;
    private static final String GET_ONE = "SELECT id_main_info, first_name, middle_name, last_name, " +
            "cabinet_office, birth_d, entry_d FROM main_info WHERE id_main_info = ?";
    private static final String DELETE = "DELETE FROM main_info WHERE id_main_info = ?";
    private static final String UPDATE = "UPDATE main_info SET first_name = ?, middle_name = ?," +
            " last_name = ?, cabinet_office = ?, birth_d = ?, entry_d = ?  WHERE id_main_info = ?";
    private static final String INSERT = "INSERT INTO main_info (first_name, middle_name, last_name, " +
            "cabinet_office, birth_d, entry_d, id_main_info ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ONE_BY_ONE = "SELECT * FROM main_info ORDER BY id_main_info";

    public MainInfoDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public MainInfo findById(long id) {
        return jdbcTemplate.queryForObject(GET_ONE, new MainInfoMapper(), id);
    }
    public List<MainInfo> findAll() {
        return jdbcTemplate.query(GET_ONE_BY_ONE, new MainInfoMapper());
    }
    public void update(MainInfo mainInfo) {
        jdbcTemplate.update(UPDATE, mainInfo.getFirstName(), mainInfo.getMiddleName(),
                mainInfo.getLastName(), mainInfo.getCabinetOffice(), mainInfo.getBirthD(),
                mainInfo.getEntryD(), mainInfo.getId());
    }
    public void create(MainInfo mainInfo) {
        jdbcTemplate.update(INSERT, mainInfo.getFirstName(), mainInfo.getMiddleName(),
                mainInfo.getLastName(),mainInfo.getCabinetOffice(), mainInfo.getBirthD(),
                mainInfo.getEntryD(), mainInfo.getId());
    }
    public void delete(long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
