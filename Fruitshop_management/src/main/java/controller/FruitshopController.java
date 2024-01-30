/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;
import dataaccess.FruitDAO;
/**
 *
 * @author HELLO
 */
public class FruitshopController extends Menu<String>{
    static String[] mchon = new String[] {"Create Fruit", "View orders", "Shopping(for buyer)", "Exit"};
    private FruitDAO fruitDAO = new FruitDAO();
    public FruitshopController() {
        super("FRUIT SHOP SYSTEM", mchon);
    }
        
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                fruitDAO.addFruit();
                break;
            case 2:
                fruitDAO.viewOrderList();
                break;
            case 3:
                fruitDAO.buyFruit();
                break;
            default:
                System.exit(0);
        }
    }
}
