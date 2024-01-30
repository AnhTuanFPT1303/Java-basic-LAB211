/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

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
}
