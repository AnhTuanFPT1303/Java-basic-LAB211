/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.ArrayList;
import model.Worker;

/**
 *
 * @author HELLO
 */

public class Validation {
    private Library common = new Library();
 
    public Validation(){}
    
    public boolean checkInputYN(String promt) {
        while (true) {
            String result = common.getString(promt);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkValidAge(int age) {
        if (age < 18 || age > 50) {
            System.out.println("Age must be in range 18 to 50");
            return false;
        }
        return true;
    }
    
    public boolean checkUniqueID (int id, ArrayList<Worker> workerList) {
        for (Worker worker : workerList) {
            if (worker.getId() == id) {
                System.out.println("Duplicate Code");
                return false;
            }
        }
        return true;
    }
    
}
