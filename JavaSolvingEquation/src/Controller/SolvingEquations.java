/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Algorithm;
import Common.Validation;
import View.Menu;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class SolvingEquations extends Menu<String>{
    static String[] mc = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
    Validation valid;
    Algorithm algorithm;
    double a;
    double b;
    double c;

    public SolvingEquations() {
        super("\nEquation Program", mc);
        valid = new Validation();
        algorithm = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calculateSuperlativeEquation();
                break;
            case 2:
                calculateQuadraticEquation();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void calculateSuperlativeEquation() {
        System.out.print("Enter A: ");
        a = valid.validateDouble();
        System.out.print("Enter B: ");
        b = valid.validateDouble();
        List<Double> list = algorithm.solveSuperlativeEquation(a, b);
        algorithm.findEvenOddSquareNumber(list);
    }

    public void calculateQuadraticEquation() {
        System.out.print("Enter A: ");
        a = valid.validateDouble();
        System.out.print("Enter B: ");
        b = valid.validateDouble();
        System.out.print("Enter C: ");
        c = valid.validateDouble();
        List<Double> list = algorithm.solveQuadraticEquation(a, b, c);
        algorithm.findEvenOddSquareNumber(list);
    }
}
