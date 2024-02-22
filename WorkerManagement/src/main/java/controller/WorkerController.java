/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author HELLO
 */
import view.Menu;
import dataaccess.WorkerDAO;

public class WorkerController extends Menu<String> {
    private WorkerDAO workerDAO = new WorkerDAO();
    static String[] mchon = new String[] {"Add a worker", "Increase salary for worker", "Decrease for worker" , "Show adjusted salary worker information."};
    
    public WorkerController() {
        super("Worker Management", mchon);
    }
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                workerDAO.addWorker();
                break;
            case 2:
                workerDAO.modifySalary(ch);
                break;
            case 3:
                workerDAO.modifySalary(ch);
                break;
            case 4:
                workerDAO.printHistory();
                break;
            default:
                System.exit(0);
        }
    }
    
}
