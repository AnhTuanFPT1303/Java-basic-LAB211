/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author HELLO
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    public int menuPrint() {
        Scanner scan = new Scanner(System.in);
        int choice=0;
        System.out.println("FRACTION OPERATIONS");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Inverse");
        System.out.println("6. Exit");
       while (true) {
            try {
                choice = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scan.nextLine();
            }
        }
    return choice;
    }
}

