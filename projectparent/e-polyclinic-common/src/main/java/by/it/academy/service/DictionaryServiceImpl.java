package by.it.academy.service;

import by.it.academy.dao.DictionaryDao;
import by.it.academy.dao.UserDao;
import by.it.academy.dao.impl.DictionaryDaoImpl;
import by.it.academy.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);
    private static final DictionaryService INSTANCE = new DictionaryServiceImpl();
    private final DictionaryDao dictionaryDao = DictionaryDaoImpl.getInstance();
    public static DictionaryService getInstance() {
        return INSTANCE;
    }

    private DictionaryServiceImpl(){}

    @Override
    public Map<Integer, String> getAllDepartments() {
        try {
            return dictionaryDao.getAllDepartments();
        } catch (SQLException e) {
            logger.error("Error during getting all of the departments", e);
        }
        return Collections.emptyMap();
    }

    @Override
    public Map<Integer, String> getAllSections() {
        try {
            return dictionaryDao.getAllSections();
        } catch (SQLException e) {
            logger.error("Error during getting all of the sections", e);
        }
        return Collections.emptyMap();
    }
}
