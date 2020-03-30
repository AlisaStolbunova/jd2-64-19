package by.it.academy.dao.impl;

import by.it.academy.dao.DictionaryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryDaoImpl extends AbstractDao implements DictionaryDao {
    private static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM department";
    private static final String SELECT_ALL_SECTIONS = "SELECT * FROM section";
    private static final DictionaryDao INSTANCE = new DictionaryDaoImpl(LoggerFactory.getLogger(DictionaryDaoImpl.class));

    private DictionaryDaoImpl(Logger logger) {
        super(logger);
    }

    public static DictionaryDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Map<Integer, String> getAllDepartments() throws SQLException {
        Map<Integer, String> departments = new HashMap<>();
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_DEPARTMENTS);
            rs = statement.executeQuery();
            while (rs.next()) {
                departments.put(rs.getInt("id"), rs.getString("department_name"));
            }
        } finally {
            closeQuietly(rs);
        }
        return departments;
    }

    @Override
    public Map<Integer, String> getAllSections() throws SQLException {
        Map<Integer, String> sections = new HashMap<>();
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_SECTIONS);
            rs = statement.executeQuery();
            while (rs.next()) {
                sections.put(rs.getInt("id"), rs.getString("street"));
            }
        } finally {
            closeQuietly(rs);
        }
        return sections;
    }
}
