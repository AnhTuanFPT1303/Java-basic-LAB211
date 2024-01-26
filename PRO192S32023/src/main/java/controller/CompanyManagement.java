/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.Menu;

/**
 *
 * @author HELLO
 */
public class CompanyManagement extends Menu<String>{
    int check = 0;
    Company customerList = new Company();
    
    public CompanyManagement() {
        super("Customer Management System", new String[]{"List all customers", "Customer search", "Sort customer by name", "Statistical homenetwork", "Exit"});
    }
        
    @Override
    public void execute(int ch) {
        if (check==0) {
            try {
                customerList.readCustomerFromFile();
            } catch (ParseException ex) {
                Logger.getLogger(CompanyManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            ch++;
        }
        switch (ch) {
            case 1:
            {
                try {
                    System.out.println(" ");
                    customerList.displayCustomerList();
                    break;
                } catch (IOException ex) {
                    System.out.println("Read file failed");
                } catch (ParseException ex) {
                
            }
            }
                break;
            case 2: 
                customerList.customerSearch();
                break;
            case 3:
                customerList.sortCustomerList();
                break;
            case 4:
                customerList.statisticalHomenetwork();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public static void main(String[] args) {
        CompanyManagement test = new CompanyManagement();
        test.run();
    }
}
