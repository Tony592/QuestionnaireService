package com.example.QuestionnaireService;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static PatientService patients = null;
    private List <Patient> patientList;


    public PatientService() {
       patientList= new ArrayList<>();
    }

    public  boolean create(Patient patient) {
        return patientList.add(patient);
    }

    public  List <Patient> findAll() {
        return patientList;
    }

    public Patient findBytaxCode(String taxCode) {
        for (Patient patient : patientList) {
            if (patient.getTaxCode().equals(taxCode)) {
                return patient;
            }
        }
        return null;
    }

    public static PatientService getInstance(){
        if(patients == null)
            patients = new PatientService();
        return patients;
    }


    @Override
    public String toString() {
        return "Insert your personal data:";
    }
}
