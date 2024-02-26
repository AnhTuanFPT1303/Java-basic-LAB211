/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;
import Dataaccess.*;
import model.File;
import Common.Library;

/**
 *
 * @author HELLO
 */
public class FileController extends Menu<String>{
    private PersonDAO personDAO = new PersonDAO();
    private Library common = new Library();
    private File file = new File();
    static String[] mchon = new String[] {"Find Person Info", "Copy Text To New File", "Exit"};
            
    public FileController() {
        super("========== File Processing ==========", mchon);
    }
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                personDAO.getPerson(common.getString("Enter Path"), common.getDouble("Enter money", 0, Integer.MAX_VALUE));
                break;
            case 2: 
            {
                try {
                    file.copyWordOneTimes(common.getString("Enter Path"), common.getString("Enter New File Name"));
                } catch (Exception ex) {
                    System.out.println("Error");
                }
            }

            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid Option");
        }
    }
}
