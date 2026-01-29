package CanteenManagement;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CanteenService service = new CanteenService();

        while (true) {
            System.out.println("\n--- CANTEEN MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Food Item");
            System.out.println("2. View Food Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Delete Food Item");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Food Name: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    service.addFood(new FoodDTO(0, name, price));
                    break;

                case 2:
                    service.getMenu().forEach(f ->
                            System.out.println(f.getFoodId() + " " +
                                    f.getFoodName() + " ₹" + f.getPrice()));
                    break;

                case 3:
                    System.out.print("Food Name: ");
                    String fname = sc.next();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price per item: ");
                    double p = sc.nextDouble();
                    service.placeOrder(new OrderDTO(fname, qty, qty * p));
                    break;

                case 4:
                    service.getOrders().forEach(o ->
                            System.out.println(o.getFoodName() + " " +
                                    o.getQuantity() + " ₹" +
                                    o.getTotalPrice()));
                    break;

                case 5:
                    System.out.print("Food ID: ");
                    service.deleteFood(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank you! Visit again 😊");
                    System.exit(0);
            }
        }
    }
}
