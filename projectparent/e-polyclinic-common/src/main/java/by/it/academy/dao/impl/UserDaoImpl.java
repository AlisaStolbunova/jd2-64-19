package by.it.academy.dao.impl;

import by.it.academy.clinic.User;
import by.it.academy.dao.UserDao;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    private static final String SELECT_BY_USER_NAME = "SELECT  * FROM user u JOIN user_role r ON u.role_id = r.id WHERE u.userName = ?";
    private static final String SELECT_ALL_USERS = "SELECT  * FROM user";

    private static final String INSERT_USER = "Insert user(userName, password, salt, role_id) values (?,?,?,?)";

    private UserDaoImpl() {
        super(LoggerFactory.getLogger(UserDaoImpl.class));
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long create(User user) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(INSERT_USER);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getSalt());
        statement.setInt(4, user.getRole());
        return (long) statement.executeUpdate();

    }

    @Override
    public Optional<User> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_USERS);
            rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("salt"),
                        rs.getInt("role_id")
                );
                users.add(user);
            }
        } finally {
            closeQuietly(rs);
        }
        return users;
    }

    @Override
    public Optional<User> getByUserName(String userName) throws SQLException {
        ResultSet rs = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_BY_USER_NAME);
            statement.setString(1, userName);

            rs = statement.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("salt"),
                        rs.getInt("role_id")
                );
                return Optional.of(user);
            }
        } finally {
            closeQuietly(rs);
        }
        return Optional.empty();
    }
}
