/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

/**
 *
 * @author HELLO
 */
import java.util.ArrayList;
import model.Worker;
import Common.Validation;
import model.salaryHistory;

public class WorkerDAO {
    private ArrayList<Worker> workerList = new ArrayList<>();
    private ArrayList<salaryHistory> history = new ArrayList<>();
    private Validation validation = new Validation();
    private Worker model = new Worker();

    public WorkerDAO (){};
    
    public void addWorker() {
        while (true) {            
            workerList.add(model.createWorker(workerList));
            if (!validation.checkInputYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }
    
    public void modifySalary(int flag) {
        model.changeSalary(flag, workerList, history);
    }   
    
    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }
    
    public void printHistory() {
        for (salaryHistory temp: history) 
            System.out.printf("%-10d%-12s%-10d%-10.2f%-10s%-20s\n", temp.getId(), temp.getName(), temp.getAge(), temp.getSalary(), temp.getStatus(), temp.getDate());
    }
    
}
