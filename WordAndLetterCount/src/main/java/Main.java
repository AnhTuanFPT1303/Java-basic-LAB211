
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HELLO
 */
import controller.StringCountController;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
        System.out.println("Enter the String");
        String string = scan.nextLine();
        StringCountController controller = new StringCountController(string);
        controller.run();
    }
}
