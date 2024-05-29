/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    } 
    public int getDenominator() {
        return denominator;
    }
    public double getResult() {
        return (double)numerator/denominator;
    }
    public String toString() {
        return numerator + "/" + denominator;
    }
}
