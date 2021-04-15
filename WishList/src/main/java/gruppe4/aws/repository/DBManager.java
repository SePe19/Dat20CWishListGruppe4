package gruppe4.aws.repository;


import gruppe4.aws.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBManager {


    public static Connection getConnection() {
        String url = null;
        String user = null;
        String password = null;
        Connection connection  = null;
        if (connection != null) return connection;
        try (InputStream input = new FileInputStream("WishList/src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException error) {
            error.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return connection;
    }


}


