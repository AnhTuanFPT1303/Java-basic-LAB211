/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

/**
 *
 * @author HELLO
 */
import Common.Library;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import Common.Validation;

public class FruitDAO {

    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private Library common = new Library();
    private Validation validation = new Validation();
    private Fruit model = new Fruit();
    private Hashtable<String, ArrayList<Fruit>> orderLists = new Hashtable<>();

    public void addFruit() {
        while (true) {            
            fruitList.add(model.createFruit(markIdFruit()));
            if (!validation.checkInputYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }

    public void buyFruit() {
        ArrayList<Fruit> tempOrderList = new ArrayList<>();
        String customerName = common.getString("Enter customer name");
        while (true) {
            printList();
            int order = common.getInt("Enter item", 0, fruitList.size());
            for (Fruit fruit : fruitList) {
                if (order == fruit.getFruitId()) {
                    System.out.println("You selected: " + fruit.getFruitName());
                    int quantity = common.getInt("Enter quantity", 0, fruit.getFruitQuantity());
                    fruit.setFruitQuantity(fruit.getFruitQuantity() - quantity);
                    Fruit tempFruit = new Fruit(fruit.getFruitId(), fruit.getFruitName(), fruit.getFruitPrice(), quantity, fruit.getFruitOrigin());
                    tempOrderList.add(tempFruit);
                    if (!orderLists.containsKey(customerName)) {
                        orderLists.put(customerName, new ArrayList<>());
                    }
                    orderLists.get(customerName).add(tempFruit);
                    if (validation.checkInputYN("Do you want to order now(Y/N)")) {
                        System.out.println("Product | Quantity | Price | Ammount");
                        for (Fruit orderFruit : tempOrderList) {
                            System.out.println(orderFruit.getFruitName() + "  " + orderFruit.getFruitQuantity() + "  " + orderFruit.getFruitPrice() + "  " + orderFruit.getFruitPrice() * quantity);
                        }
                        return;
                    }
                }
            }
        }
    }

    public void viewOrderList() {
        System.out.println("Order Lists:");
        for (String customerName : orderLists.keySet()) {
            System.out.println("Customer: " + customerName);
            ArrayList<Fruit> customerOrderList = orderLists.get(customerName);
            for (Fruit fruit : customerOrderList) {
                System.out.println(fruit.getFruitName() + ", Quantity: " + fruit.getFruitQuantity() + ", Price: " + fruit.getFruitPrice() + ", Ammount: " + fruit.getFruitPrice()*fruit.getFruitQuantity());
            }
            System.out.println("------------------------------------");
        }
    }

    public void printList() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : fruitList) {
            System.out.print("      ");
            System.out.format("%-15s%-18s%-13s%-10s%n", fruit.getFruitId(), fruit.getFruitName(), fruit.getFruitOrigin(), fruit.getFruitPrice());
        }
    }
    
    public int markIdFruit() {
        int id = fruitList.size() + 1;
        return id;
    }
    
}
