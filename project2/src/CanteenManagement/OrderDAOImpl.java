package CanteenManagement;

import java.sql.*;
import java.util.*;

public class OrderDAOImpl implements OrderDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/canteendb";
    private static final String USER = "root";
    private static final String PASS = "password";

    @Override
    public void placeOrder(OrderDTO order) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String sql = "INSERT INTO orders(food_name, quantity, total_price) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, order.getFoodName());
            pst.setInt(2, order.getQuantity());
            pst.setDouble(3, order.getTotalPrice());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            ResultSet rs = con.prepareStatement("SELECT * FROM orders").executeQuery();

            while (rs.next()) {
                OrderDTO order = new OrderDTO(
                        rs.getString("food_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("total_price")
                );
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
