/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author HELLO
 */
public class FractionList {
    private ArrayList<Fraction> fractions = new ArrayList<>();
    
    public FractionList(){}
    
    public FractionList(ArrayList<Fraction> fractions) { 
       this.fractions = fractions;
    }
    
    public ArrayList<Fraction> getFractions() {
        return this.fractions;
    }

     public void addElement(Fraction f) {
         this.fractions.add(f);
     }
}
