package by.it.academy.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ResourceBundle;

public class DbConnection {

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        Class.forName(bundle.getString("db.driver"));
        return DriverManager.getConnection(
                bundle.getString("db.url"),
                bundle.getString("db.user"),
                bundle.getString("db.password")
        );
    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("getAll:");
        getAll();
        System.out.println("Insert:");
        insert();
        System.out.println("getAll:");
        getAll();


        }

        public static void getAll()throws ClassNotFoundException, SQLException{
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                connection = new DbConnection().getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("Select * from empl;");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("Id = " + id + " name = " + name);
                }
            }finally{
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
        }


    public static void insert()throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new DbConnection().getConnection();
            statement = connection.createStatement();
            int i = statement.executeUpdate("Insert into empl(name, dep_id) values ('BBB',1);"
                    ,Statement.RETURN_GENERATED_KEYS);

            System.out.println("Affected rows = " + i);

            resultSet = statement.getGeneratedKeys();

           // System.out.println(resultSet.next());

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println("New Id = " + id);
            }
        }finally{
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}

