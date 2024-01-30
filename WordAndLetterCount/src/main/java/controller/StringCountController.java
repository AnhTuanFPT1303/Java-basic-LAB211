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
import model.StringTokenizerTest;
public class StringCountController extends Menu<String> {
    private StringTokenizerTest stringModel = new StringTokenizerTest();
    private String string;
    public StringCountController(String str) {
        super("Words and Letter count", new String[]{"Count Words", "Count Letter", "Press others button to exit"});
        this.string = str;
        stringModel.start(string);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println(stringModel.getStrList());
                break;
            case 2:
                System.out.println(stringModel.getLetterList());
                break;
            default:
                System.exit(0);
        }

    }

}