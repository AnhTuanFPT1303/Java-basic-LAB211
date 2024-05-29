/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Fraction;
import model.FractionList;
import view.InputForm;
import view.Menu;

/**
 *
 * @author HELLO
 */
public class Operation {

    InputForm inputForm = new InputForm();
    FractionList fractionList = new FractionList();
    Menu menu = new Menu();

    public void run() {
        int quantity = inputForm.initList();
        inputForm.numeratorAndDenominatorInput(quantity, fractionList);
        do {
            switch (menu.menuPrint()) {
                case 1:
                    inputForm.outputConsole(addition(fractionList));
                    break;
                case 2:
                    inputForm.outputConsole(substraction(fractionList));
                    break;
                case 3:
                    inputForm.outputConsole(multiply(fractionList));
                    break;
                case 4:
                    inputForm.outputConsole(divide(fractionList));
                    break;
                case 5:
                    System.out.println(inverse(fractionList));
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        } while (true);
    }

    public Fraction addition(FractionList fractionList) {
        int numeratorSum = 0;
        int denominator = 1;
        for (Fraction fraction : fractionList.getFractions()) {
            int factor = denominator / gcd(denominator, fraction.getDenominator());
            int numerator = fraction.getNumerator() * factor;
            int fractionDenominator = fraction.getDenominator() * factor;
            numeratorSum += numerator;
            denominator = fractionDenominator;
        }
        int gcd = gcd(numeratorSum, denominator);
        numeratorSum /= gcd;
        denominator /= gcd;
        Fraction result = new Fraction(numeratorSum, denominator);
        return simplifyFraction(result);
    }

    public static Fraction substraction(FractionList fractionList) {

        Fraction result = fractionList.getFractions().get(0);

        for (int i = 1; i < fractionList.getFractions().size(); i++) {
            Fraction fraction = fractionList.getFractions().get(i);
            result = substract(result, fraction);
        }

        return result;
    }

    private static Fraction substract(Fraction fraction1, Fraction fraction2) {
        int numerator1 = fraction1.getNumerator();
        int denominator1 = fraction1.getDenominator();
        int numerator2 = fraction2.getNumerator();
        int denominator2 = fraction2.getDenominator();
        int commonDenominator = denominator1 * denominator2;
        int numeratorDifference = (numerator1 * denominator2) - (numerator2 * denominator1);
        Fraction result = new Fraction(numeratorDifference, commonDenominator);
        return simplifyFraction(result);
    }

    public Fraction multiply(FractionList fractionList) {
        int numeratorProduct = 1;
        int denominatorProduct = 1;

        for (Fraction fraction : fractionList.getFractions()) {
            numeratorProduct *= fraction.getNumerator();
            denominatorProduct *= fraction.getDenominator();
        }

        Fraction result = new Fraction(numeratorProduct, denominatorProduct);
        return simplifyFraction(result);
    }

    public Fraction divide(FractionList fractionList) {
        Fraction result = fractionList.getFractions().get(0);
        for (int i = 1; i < fractionList.getFractions().size(); i++) {
            Fraction fraction = fractionList.getFractions().get(i);
            result = new Fraction(result.getNumerator() * fraction.getDenominator(),
                    result.getDenominator() * fraction.getNumerator());
        }

        return simplifyFraction(result);
    }

    public ArrayList<Fraction> inverse(FractionList fractionList) {
        ArrayList<Fraction> inverseFractions = new ArrayList<>();
        int numerator;
        int denominator;
        for (Fraction fractionGet : fractionList.getFractions()) {
            numerator = fractionGet.getNumerator();
            denominator = fractionGet.getDenominator();
            inverseFractions.add(new Fraction(denominator, numerator));
        }
        return inverseFractions;
    }

    private static Fraction simplifyFraction(Fraction fraction) {
        int gcd = gcd(fraction.getNumerator(), fraction.getDenominator());
        int numerator = fraction.getNumerator() / gcd;
        int denominator = fraction.getDenominator() / gcd;
        return new Fraction(numerator, denominator);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
