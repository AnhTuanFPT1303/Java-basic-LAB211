/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dataaccess;

/**
 *
 * @author HELLO
 */
import java.util.ArrayList;
import model.Person;

public class PersonDAO {

    private ArrayList<Person> personList = new ArrayList<>();
    private Person model = new Person();

    public void getPerson(String source, double money) {
        model.readPerson(personList, source);
        printList(money);
    }

    public void printList(double money) {
        double max = 0;
        double min = Integer.MAX_VALUE;
        Person minPerson = null;
        Person maxPerson = null;
        System.out.println("------------- Result -------------");
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : personList) {
            double salary = person.getSalary();
            if (salary > money) {
                System.out.println(person);
            }
            if (max < salary) {
                max = salary;
                maxPerson = person;
            }
            if (min > salary) {
                min = salary;
                minPerson = person;
            }

        }

        if (maxPerson != null) {
            System.out.println("Max: " + maxPerson.getName());
        }
        if (minPerson != null) {
            System.out.println("Min: " + minPerson.getName());
        }

    }
}
