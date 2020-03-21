package by.it.academy.dao;

import java.sql.SQLException;
import java.util.Map;

public interface DictionaryDao {

    Map<Integer, String> getAllDepartments() throws SQLException;
    Map<Integer, String> getAllSections() throws SQLException;
}
