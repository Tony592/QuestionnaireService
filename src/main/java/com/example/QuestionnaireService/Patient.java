package com.example.QuestionnaireService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Patient {
    @JsonProperty("name")
    private String  name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty ("birthdayDate")
    private Date birthdayDate;
    @JsonProperty("taxCode")
    private String taxCode;
    @JsonProperty("phoneNumber")
    private String phoneNumber;


    public Patient() {
    }

    public Patient(String name,String surname,Date birthdayDate,String taxCode,String phoneNumber){
        super();
        this.name=name;
        this.surname=surname;
        this.birthdayDate=birthdayDate;
        this.taxCode=taxCode;
        this.phoneNumber=phoneNumber;
    }


    public String getTaxCode() {
        return taxCode;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
}


