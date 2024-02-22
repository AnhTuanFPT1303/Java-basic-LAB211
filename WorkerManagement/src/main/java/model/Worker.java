/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
import Common.Library;
import Common.Validation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
    private Library common = new Library();
    private Validation validation = new Validation();
    private int id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    
    public Worker() {}

    public Worker(int id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    public Worker createWorker(ArrayList<Worker> workerList) {
        System.out.println("--------- Add Worker ---------");
        int id1;
        do {
            id1 = common.getInt("Enter Code", 0, Integer.MAX_VALUE);
        } while (!validation.checkUniqueID(id1, workerList));
        String name1 = common.getString("Enter Name");
        int age1;
        do {
            age1 = Year.now().getValue() - common.getInt("Enter Birthday", 1930, Year.now().getValue());
        } while (!validation.checkValidAge(age1));
        double salary1 = common.getDouble("Enter Salary", 0, Integer.MAX_VALUE);
        String workLocation1 = common.getString("Enter Work Location");
        Worker worker = new Worker(id1, name1, age1, salary1, workLocation1);
        return worker;
    }
    
    public void changeSalary(int flag, ArrayList<Worker> workerList, ArrayList<salaryHistory> history) {
        int tempID = common.getInt("Enter ID", 0, Integer.MAX_VALUE);
        if (flag == 2) {
            for (Worker tempWorker : workerList) {
                if (tempWorker.getId() == tempID) {
                    double salaryChange = common.getDouble("Enter ammount of money to raise", 0, Integer.MAX_VALUE);
                    tempWorker.setSalary(tempWorker.getSalary() + salaryChange);
                    history.add(new salaryHistory("UP", getCurrentDate(), tempWorker.getId(), tempWorker.getName(), tempWorker.getAge(), tempWorker.getSalary(), tempWorker.getWorkLocation()));
                }
                System.out.println("Invalid ID");
            }
        }
        if (flag == 3) {
           for (Worker tempWorker : workerList) {
                if (tempWorker.getId() == tempID) {
                    double salaryChange = common.getDouble("Enter ammount of money to decrease", 0, Integer.MAX_VALUE);
                    tempWorker.setSalary(tempWorker.getSalary() - salaryChange);
                    history.add(new salaryHistory("DOWN", getCurrentDate(), tempWorker.getId(), tempWorker.getName(), tempWorker.getAge(), tempWorker.getSalary(), tempWorker.getWorkLocation()));
                }
                System.out.println("Invalid ID");
            } 
        }
        
    } 
    
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
