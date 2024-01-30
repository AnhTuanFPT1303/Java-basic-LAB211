/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HELLO
 */
public class InternshipModel extends CandidateModel {
    private String major;
    private String semester;
    private String universityName;

    public InternshipModel(String major, String semester, String universityName, String candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }
  
    public String getMajor() {
        return this.major;
    }
    
    public String getSemester() {
        return this.semester;
    }
    
    public String getUniversityName() {
        return this.universityName;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "major=" + major + ", semester=" + semester + ", universityName=" + universityName + '}';
    }
}
