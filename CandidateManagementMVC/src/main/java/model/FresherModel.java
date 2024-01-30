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
public class FresherModel extends CandidateModel {
    private int graduationTime;
    private String graduationRank;
    private String universityName;

    public FresherModel(int graduationTime,String graduationRank,String universityName , String candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.graduationTime = graduationTime;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
    }

    public int getGraduationTime() {
        return graduationTime;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "graduationTime=" + graduationTime + ", graduationRank=" + graduationRank + ", universityName=" + universityName + '}';
    } 
    
}