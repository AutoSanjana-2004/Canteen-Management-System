package CanteenManagement;

import java.util.List;

public class CanteenService {

    private FoodDAO foodDAO = new FoodDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();

    public void addFood(FoodDTO food) {
        if (food.getPrice() <= 0) {
            System.out.println("Invalid price!");
            return;
        }
        foodDAO.addFood(food);
    }

    public List<FoodDTO> getMenu() {
        return foodDAO.getAllFood();
    }

    public void deleteFood(int id) {
        foodDAO.deleteFood(id);
    }

    public void placeOrder(OrderDTO order) {
        orderDAO.placeOrder(order);
    }

    public List<OrderDTO> getOrders() {
        return orderDAO.getAllOrders();
    }
}
