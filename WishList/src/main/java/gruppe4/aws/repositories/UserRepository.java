package gruppe4.aws.repositories;
/*
import gruppe4.aws.models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();

        try {
            Connection userConnection = DriverManager.getConnection("jdbc:mysql://52.29.72.18:3306/WishListDatabase", "Grunt", "123");
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

}*/
