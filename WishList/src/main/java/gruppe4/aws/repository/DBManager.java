package gruppe4.aws.repository;


import gruppe4.aws.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBManager {
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;
    ArrayList<User> allUsers = new ArrayList<>();


    public static Connection getConnection() {
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

    public ArrayList<User> showAllUsers() {

        try {
            Connection userConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement userStatement = userConnection.prepareStatement("SELECT * FROM betaUsers");
            ResultSet userRS = userStatement.executeQuery();

            while (userRS.next()) {
                User tmp = new User(userRS.getString(1), userRS.getString(2), userRS.getString(3));
                allUsers.add(tmp);
            }

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }
        return allUsers;
    }


    public void makeUser() {

        try {
            Connection makeUserConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement makeUserStatement = makeUserConnection.prepareStatement("INSERT INTO betaUsers(USERACCOUNTNAME, USERNAME, USERMAIL)" + "VALUES ('accountName', 'name', 'email')");
            makeUserStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }

    }

}


