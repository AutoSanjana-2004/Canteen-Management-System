package CanteenManagement;

public class OrderDTO {

    private int orderId;
    private String foodName;
    private int quantity;
    private double totalPrice;
    private String orderTime;

    public OrderDTO() {}

    public OrderDTO(String foodName, int quantity, double totalPrice) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

