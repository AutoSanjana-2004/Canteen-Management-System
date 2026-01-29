package CanteenManagement;
public class FoodDTO {

    private int foodId;
    private String foodName;
    private double price;

    public FoodDTO() {}

    public FoodDTO(int foodId, String foodName, double price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }
}

