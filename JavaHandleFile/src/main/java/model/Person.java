/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author HELLO
 */
public class Person {

    private String name;
    private String address;
    private double salary;

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Person() {
    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void readPerson(ArrayList<Person> personList, String source) {
        ReadFileWithBufferedReader(personList, source);
    }

    public void ReadFileWithBufferedReader(ArrayList<Person> personList, String source) {
        try {
            FileInputStream fileInputStream = new FileInputStream(source);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] tokens = line.split(";");
                String personName = tokens[0];
                String personAddress = tokens[1];
                String personMoney = tokens[2];
                personList.add(new Person(personName, personAddress, Double.parseDouble(personMoney)));
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException i) {
            System.out.println("File not found");
        }
    }

    @Override
    public String toString() {
        return String.format("%-19s %-19s %-18.2f", name, address, salary);
    }
}
