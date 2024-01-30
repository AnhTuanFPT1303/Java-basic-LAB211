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
public class ExperienceModel extends CandidateModel {
    private int experienment;
    private String professionalSkill;

    public ExperienceModel(int experienment, String professionalSkill, String candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.experienment = experienment;
        this.professionalSkill = professionalSkill;
    }
    
    public int getExperienment() {
        return this.experienment;
    }
    
    public String getProfessionalSkill() {
        return this.professionalSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "experienment=" + experienment + ", professionalSkill=" + professionalSkill + '}';
    }

    
}