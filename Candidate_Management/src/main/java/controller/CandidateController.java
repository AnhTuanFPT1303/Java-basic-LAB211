/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.CandidateList;
import model.CandidateModel;
import view.Menu;
import view.Validation;

/**
 *
 * @author HELLO
 */
public class CandidateController extends Menu<String>{
    static String[] mchon = new String[] {"Input", "Display", "Search", "Exit"};
    public ArrayList<CandidateModel> candidates = new ArrayList();
    private CandidateList list = new CandidateList();
    public CandidateController() {
        super("\nManage Candidate:", mchon);
    }
    
    @Override
    public void execute(int ch) {
        candidates = list.getCandidateList();
        switch (ch) {
            case 1 -> {
                System.out.println("Enter type of cadidate (0-2)");
                int type = Validation.checkInputIntLimit(0, 2);
                list.createNewCandidate(candidates, type);
            }
            case 2 -> list.printList();
            case 3 -> list.searchCandidate(candidates);
            default -> System.exit(0);
        }
    }
    
}
