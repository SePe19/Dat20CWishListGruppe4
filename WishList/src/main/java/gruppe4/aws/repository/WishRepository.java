package gruppe4.aws.repository;

import gruppe4.aws.models.Wish;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishRepository {


    public ArrayList<Wish> showAllWishesFromUser(String accountName) {
        ArrayList<Wish> allWishes = new ArrayList<>();

        try {
            Connection userConnection = DBManager.getConnection();
            PreparedStatement userStatement = userConnection.prepareStatement("SELECT * FROM betaWishes Where USERACCOUNTNAME=?");
            userStatement.setString(1,accountName);
            ResultSet userRS = userStatement.executeQuery();

            while (userRS.next()) {
                Wish tmp = new Wish(userRS.getInt(1),userRS.getString(2), userRS.getString(3), userRS.getString(4), userRS.getInt(5), userRS.getDouble(6), userRS.getString(7));
                allWishes.add(tmp);
            }

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }
        return allWishes;
    }

    public void makeWish(String wishName, String wishComment, String wishLink, int wishRank, double wishPrice, String accountName) {

        try {
            Connection makeUserConnection = DBManager.getConnection();
            PreparedStatement makeUserStatement = makeUserConnection.prepareStatement("INSERT INTO betaWishes(wishName, wishComment, wishLink, wishRank, wishPrice, USERACCOUNTNAME)" + "VALUES ('" + wishName + "', '" + wishComment + "', '" + wishLink + "', '" + wishRank + "', '" + wishPrice + "', '" + accountName +"')");
            makeUserStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.printf(error.getMessage());
        }
    }

    public ArrayList<Wish> getAccountWishList(String accountName){
        ArrayList<Wish> allWishes;
        ArrayList<Wish> userWishList = new ArrayList<>();
        allWishes = showAllWishesFromUser(accountName);
        for (int i = 0; i < allWishes.size(); i++){
            userWishList.add(allWishes.get(i));
        }
        return userWishList;
    }
}