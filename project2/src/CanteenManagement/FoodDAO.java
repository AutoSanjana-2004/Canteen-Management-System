package CanteenManagement;
import java.util.List;

public interface FoodDAO {

    void addFood(FoodDTO food);

    List<FoodDTO> getAllFood();

    void deleteFood(int id);
}
