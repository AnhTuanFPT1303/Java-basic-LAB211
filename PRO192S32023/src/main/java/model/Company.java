/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;
/**
 *
 * @author HELLO
 */
public class Company {
    Scanner scan = new Scanner(System.in);
    private ArrayList<Customer> customerList = new ArrayList<>();
    
    public Company() {}
    
    public Company(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public void customerListAdd(Customer c) {
        this.customerList.add(c);       
    }
    
    public void readCustomerFromFile() throws ParseException {
        String path = "customer.txt";
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] details = line.split(",");
                String id = details[0];
                String name = details[1];
                String phone = details[2];
                String dob = details[3];
                if (details[0].startsWith("KH")) {
                    char[] digit = id.toCharArray();
                    if (Character.isDigit(digit[2]) && Character.isDigit(digit[3])) {
                    Customer c = new Customer(id, name, phone, dob);
                    customerListAdd(c);
                    }
                }   
                line = bufferedReader.readLine();
            }
        } catch (IOException i) {
            System.out.println("File not found");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger("Cannot close file");
            }
        }
    }
    
     public void customerSearch() {
        System.out.println("Search Patient Option");
        System.out.println("-------------------");
        System.out.println("1. Search By ID");
        System.out.println("2. Search By DOB");
        System.out.println("-------------------");
        System.out.println("Enter your choice");
        int choice = scan.nextInt();
        scan.nextLine();
        boolean found = false;
        switch (choice) {
            case 1:
                System.out.println("Enter ID");
                String id = scan.nextLine();
                for (Customer c : customerList) {
                    if (c.getCustomerID().equals(id))
                        System.out.println(c.toString());
                        found = true;
                }
                if (!found) System.out.println("Patient not found");
                break;
             case 2:
                System.out.println("Enter DOB");
                String DOB = scan.nextLine();
                for (Customer c : customerList) {   
                    if (c.getDateOfBirth().equals(DOB))
                        System.out.println(c.toString());
                        found = true;
                }
                if (!found) System.out.println("Patient not found");
                break;    
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
     
    public void sortCustomerList() {
        Collections.sort(customerList);
        for (Customer c: customerList) {
            System.out.println(c.toString());
        }   
    }
    
    public void displayCustomerList() throws IOException, ParseException {
        for (Customer c: customerList) {
            System.out.println(c.toString());
        }   
    }
    
    public void statisticalHomenetwork() {
        int count = 0;
        for (Customer c: customerList) {
            if (c.getPhone().startsWith("098")) {
                c.homenetworkCheck(1);
                count++;
            }
        }
        System.out.println("Total: " + count);
        count =0;
        for (Customer c: customerList) {
            if (c.getPhone().startsWith("090")) {
                c.homenetworkCheck(2);
                count++;
            }
        }
        System.out.println("Total: " + count);
        count =0;
        for (Customer c: customerList) {
            if (c.getPhone().startsWith("093")) {
                c.homenetworkCheck(3);
                count++;
            }
        }
        System.out.println("Total: " + count);
        count =0;
    }
    
}
