/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.CandidateModel;

/**
 *
 * @author HELLO
 */
public class Validation {
    private final static Scanner scan = new Scanner(System.in);
    
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scan.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = scan.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.out.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        while (true) {
            String result = checkInputString();
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.out.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<CandidateModel> candidates, String id) {
        for (CandidateModel candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.out.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.out.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
}
