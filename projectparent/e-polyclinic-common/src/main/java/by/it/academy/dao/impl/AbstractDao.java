package by.it.academy.dao.impl;

import by.it.academy.db.connection.pool.ClinicDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {

    protected final Logger logger;

    protected AbstractDao(Logger logger) {
        this.logger = logger;
    }


    protected Connection getConnection() throws SQLException {
        return ClinicDataSource.getConnection();
    }

    protected void closeQuietly(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }


}
