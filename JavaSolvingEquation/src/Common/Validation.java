/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Validation {
    protected Scanner sc = new Scanner(System.in);

    // check input option menu
//    public int validateMenuOption(int firstOption, int lastOption) {
//        // declare
//        int option;
//
//        while (true) {
//            try {
//                option = Integer.parseInt(sc.nextLine().trim());
//                if (option < firstOption || option > lastOption) {
//                    throw new NumberFormatException();
//                }
//                return option;
//            } catch (NumberFormatException e) {
//                System.out.println("Option must between " + firstOption + " and " + lastOption);
//                System.out.print("Your choice: ");
//            }
//        }
//    }

    public double validateDouble() {
        // declare
        double inputDouble;

        while (true) {
            try {
                inputDouble = Double.parseDouble(sc.nextLine());
                return inputDouble;
            } catch (NumberFormatException e) {
                System.out.println("Please input Double number!!!");
                System.out.print("Enter Double number: ");
            }
        }
    }

    public boolean isOdd(double inputNumber) {
        return inputNumber % 2 != 0;
    }

    public boolean isEven(double inputNumber) {
        return inputNumber % 2 == 0;
    }

    public boolean isSquare(double inputNumber) {
        if (inputNumber == 0) {
        } else {
            return ((int) Math.sqrt(inputNumber) * (int) Math.sqrt(inputNumber) == inputNumber);
        }
        return false;
    }
}
