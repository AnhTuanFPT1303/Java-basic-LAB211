/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Fraction;
import model.FractionList;

/**
 *
 * @author HELLO
 */
public class InputForm {

    Scanner scan = new Scanner(System.in);

    public int initList() {
        int quantity = 0;
        while (true) {
            try {
                System.out.println("Input quantity of fraction");
                quantity = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scan.nextLine();
            }
        }
        return quantity;
    }
    
    public void numeratorAndDenominatorInput(int n, FractionList fractionList) {
        for (int i = 0; i < n; i++) {
            boolean validFractionEntered = false;
            while (!validFractionEntered) {
                try {
                    System.out.println("Enter a numerator");
                    int numerator = scan.nextInt();
                    System.out.println("Enter a denominator");
                    int denominator = scan.nextInt();
                    scan.nextLine();
                    fractionList.addElement(new Fraction(numerator, denominator));
                    validFractionEntered = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numerator and denominator as integers.");
                }
            }
        }
    }

    public void outputConsole(Fraction f) {
        System.out.println(f);
    }

}

