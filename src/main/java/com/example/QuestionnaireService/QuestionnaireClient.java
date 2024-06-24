package com.example.QuestionnaireService;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class QuestionnaireClient {
    private static final String BASE_URI = "http://localhost:8080/QuestionnaireService_war_exploded/api/";




    public static void main(String[] args) {

        //Initial page
        Client client = ClientBuilder.newClient();
        Response initialPage = client.target(BASE_URI + "welcome").request(MediaType.TEXT_PLAIN_TYPE).get();
                System.out.println("INITIAL PAGE: " + initialPage.readEntity(String.class));

                //personal data

        Response personalData = client.target(BASE_URI + "patient").request(MediaType.TEXT_PLAIN).get();
        System.out.println("PATIENT PAGE: " + personalData.readEntity(String.class));

        Patient patient = new Patient("Foo2","Bar2", new Date(1995,12,5), "SSHJF88I98E314T",
                "0123456789");

        //submit data
        Response submitData= client.target(BASE_URI + "patient").request(MediaType.APPLICATION_JSON)
                .post(Entity.json(patient));

        System.out.println("patient data submitted: Welcome " + patient.getName() + " " +  patient.getSurname() +
                " TAXCODE: " +  patient.getTaxCode()+ submitData.readEntity(String.class));


        //submit questionnaire
        Response  questionnaire = client.target(BASE_URI + "questionnaire").request(MediaType.APPLICATION_JSON).get();
        System.out.println("Answer the following questions: ");
        System.out.println("QUESTIONNAIRE PAGE: " + questionnaire.readEntity(String.class));

        QuestionnaireService qservice = new QuestionnaireService();
        Map<String,Boolean> answer= new HashMap<>();
        answer.put(qservice.getQuestionnaire().get(0),true);
        answer.put(qservice.getQuestionnaire().get(1),true);
        answer.put(qservice.getQuestionnaire().get(2),true);
        answer.put(qservice.getQuestionnaire().get(3),false);
        answer.put(qservice.getQuestionnaire().get(4),true);


        Questionnaire questionnaire1 = new Questionnaire(patient.getTaxCode(),answer);

        Response submitQuestionnaire= client.target(BASE_URI + "questionnaire").request(MediaType.APPLICATION_JSON)
                .post(Entity.json(questionnaire1));

        System.out.println("questionnaire submitted : " + answer);

        //Result
        if(questionnaire1.isRisk())
            System.out.println("RESULT PAGE: " + client.target(BASE_URI+ "result/bad").request(MediaType.TEXT_PLAIN_TYPE).get(String.class));
        else
            System.out.println("RESULT PAGE: " +client.target(BASE_URI + "result/ok").request(MediaType.TEXT_PLAIN_TYPE).get(String.class
            ));
    }


}
