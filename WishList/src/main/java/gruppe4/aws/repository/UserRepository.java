package gruppe4.aws.repository;

import gruppe4.aws.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository {

    public ArrayList<User> showAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();

        try {
            Connection userConnection = DBManager.getConnection();
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

    public void makeUser(String accountName, String name, String email) {

        try {
            Connection makeUserConnection = DBManager.getConnection();
            PreparedStatement makeUserStatement = makeUserConnection.prepareStatement("INSERT INTO betaUsers(USERACCOUNTNAME, USERNAME, USERMAIL)" + "VALUES ('" + accountName + "', '" + name + "', '" + email + "')");
            makeUserStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }

    }
}