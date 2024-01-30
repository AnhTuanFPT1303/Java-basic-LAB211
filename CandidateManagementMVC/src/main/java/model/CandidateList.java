/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
import java.util.ArrayList;
import java.util.Calendar;
import view.Validation;

public class CandidateList {
    private ArrayList<CandidateModel> candidateList;

    public CandidateList() {
        candidateList = new ArrayList<>();
    }
    
    
    public ArrayList<CandidateModel> getCandidateList() {
        return candidateList;
    }

    public void setCandidate(CandidateModel candidate) {
        candidateList.add(candidate);
    }
    
    public void createNewCandidate(ArrayList<CandidateModel> candidates, int type) {
        while (true) {
            String id;
            do {
            System.out.print("Enter id: ");
            id = Validation.checkInputString();
            } while (Validation.checkIdExist(candidates, id));
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkInputIntLimit(1950, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkInputEmail();
            CandidateModel candidate = new CandidateModel(id, firstName, lastName, birthDate, address, phone, email, type);

            if (Validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0 -> createExperience(candidates, candidate);
                    case 1 -> createFresher(candidates, candidate);
                    case 2 -> createInternship(candidates, candidate);
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");

            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
    
    public void createExperience(ArrayList<CandidateModel> candidates, CandidateModel candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new ExperienceModel(yearExperience, professionalSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhoneNumber(), candidate.getEmail(), candidate.getCandidateType()));
        System.err.println("Create success.");
    }

    public void createFresher(ArrayList<CandidateModel> candidates, CandidateModel candidate) {
        System.out.print("Enter graduation date: ");
        int graduationDate = Validation.checkInputIntLimit(1950, Calendar.getInstance().get(Calendar.YEAR));
        String graduationRank = inputGraduationRank();
        System.out.println("Enter name of graduated university");
        String universityName = Validation.checkInputString();

        candidates.add(new FresherModel(graduationDate, graduationRank, universityName, candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhoneNumber(), candidate.getEmail(),
                candidate.getCandidateType()));
        System.err.println("Create success.");
    }

    public void createInternship(ArrayList<CandidateModel> candidates, CandidateModel candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        candidates.add(new InternshipModel(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhoneNumber(), candidate.getEmail(),
                candidate.getCandidateType()));
        System.err.println("Create success.");
    }

    public String inputGraduationRank() {
        System.out.print("Enter graduation rank (1: A,2: B,3: C,4: D): ");
        int input = Validation.checkInputIntLimit(1, 4);
        String graduationRank;
        switch (input) {
            case 1:
                return graduationRank = "Excellence";
            case 2:
                return graduationRank = "Good";
            case 3:
                return graduationRank = "Fair";
            case 4:
                return graduationRank = "Poor";
            default:
                return "";
        }
    }

    public void searchCandidate(ArrayList<CandidateModel> candidates) {
        System.out.print("Enter type of candidate(0: Experience, 1: Fresher, 2:Internship): ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        for (CandidateModel candidate : candidates) {
            if (candidate.getCandidateType() == typeCandidate && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                System.out.println(candidate.toString());
            }
        }
    }
    
    public void printList() {
        System.out.println("========Experience========");
        for (CandidateModel candidate : candidateList) {
            if (candidate instanceof ExperienceModel) {
                System.out.println(candidate.toString());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("========Fresher========");
        for (CandidateModel person2 : candidateList) {
            if (person2 instanceof FresherModel) {
                System.out.println(person2.toString());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("========Internship========");
        for (CandidateModel person3 : candidateList) {
            if (person3 instanceof InternshipModel) {
                System.out.println(person3.toString());
            }
        }
    }
}


