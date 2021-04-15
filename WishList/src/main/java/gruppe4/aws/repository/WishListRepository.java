package gruppe4.aws.repository;

import gruppe4.aws.models.User;
import gruppe4.aws.models.Wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishListRepository {

    public ArrayList<Wish> showAllWishes() {
        ArrayList<Wish> allWishes = new ArrayList<>();

        try {
            Connection userConnection = DBManager.getConnection();
            PreparedStatement userStatement = userConnection.prepareStatement("SELECT * FROM betaWishes");
            ResultSet userRS = userStatement.executeQuery();

            while (userRS.next()) {
                Wish tmp = new Wish(userRS.getString(1), userRS.getString(2), userRS.getString(3),userRS.getInt(4), userRS.getDouble(5));
                allWishes.add(tmp);
            }

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }
        return allWishes;
    }

    public void makeWish(String wishName, String wishComment, String wishLink, int wishRank, double wishPrice) {

        try {
            Connection makeUserConnection = DBManager.getConnection();
            PreparedStatement makeUserStatement = makeUserConnection.prepareStatement("INSERT INTO betaWishes(wishName, wishComment, wishLink, wishRank, wishPrice)" + "VALUES ('" + wishName + "', '" + wishComment + "', '" + wishLink + "',''" + wishRank +"', '" + wishPrice + "')");
            makeUserStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }
    }
}
