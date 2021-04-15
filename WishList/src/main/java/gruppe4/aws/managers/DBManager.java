package gruppe4.aws.managers;

import gruppe4.aws.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBManager {
    private static String user;
    private static String password;
    private static String url;
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;
        try (InputStream input = new FileInputStream("WishList/src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();

        try {
            Connection userConnection = DriverManager.getConnection(url,user,password);
            PreparedStatement userStatement = userConnection.prepareStatement("SELECT * FROM betaUsers");
            ResultSet userRS = userStatement.executeQuery();

            while (userRS.next()) {
                User tmp = new User(userRS.getString(1), userRS.getString(2), userRS.getString(3));
                allUsers.add(tmp);
            }

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        } return allUsers;
    }
}
