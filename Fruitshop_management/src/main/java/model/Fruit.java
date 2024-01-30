/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
import Common.Library;

public class Fruit {
    private Library common = new Library();
    private int fruitId;
    private String fruitName;
    private double fruitPrice;
    private int fruitQuantity;
    private String fruitOrigin;
    
    public Fruit(){}

    public Fruit(int fruitId, String fruitName, double fruitPrice, int fruitQuantity, String fruitOrigin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }
    
    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitOrigin() {
        return fruitOrigin;
    }

    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }

    public Fruit createFruit(int id) {
        String name = common.getString("Enter name of fruit");
        int quantity = common.getInt("Enter quantity of fruit", 1, 999);
        String origin = common.getString("Enter origin of the fruit");
        double price = common.getDouble("Enter price", 0, Integer.MAX_VALUE);
        Fruit fruit = new Fruit(id, name, price, quantity, origin);
        return fruit;
    }

    @Override
    public String toString() {
        return "   " + fruitId + "   " + fruitName + "   " + fruitPrice + "   " + fruitQuantity + "   " + fruitOrigin;
    }
}
