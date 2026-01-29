package CanteenManagement;

import java.util.List;

public interface OrderDAO {

    void placeOrder(OrderDTO order);

    List<OrderDTO> getAllOrders();
}

