package CanteenManagement;

import java.sql.*;
import java.util.*;

public class FoodDAOImpl implements FoodDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/canteendb";
    private static final String USER = "root";
    private static final String PASS = "anusql28";

    @Override
    public void addFood(FoodDTO food) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String sql = "INSERT INTO food_items(food_name, price) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, food.getFoodName());
            pst.setDouble(2, food.getPrice());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FoodDTO> getAllFood() {
        List<FoodDTO> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            PreparedStatement pst = con.prepareStatement("SELECT * FROM food_items");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new FoodDTO(
                        rs.getInt("food_id"),
                        rs.getString("food_name"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteFood(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            PreparedStatement pst =
                    con.prepareStatement("DELETE FROM food_items WHERE food_id=?");
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

