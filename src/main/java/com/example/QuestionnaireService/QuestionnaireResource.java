package com.example.QuestionnaireService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("questionnaire")

public class QuestionnaireResource {
    QuestionnaireService questionnaireService = QuestionnaireService.getQuesInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> getQuestionnaire() {
       return questionnaireService.getQuestionnaire();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuestionnaire() {
        if (!questionnaireService.findAllQuestionnaires().isEmpty()) {
            return Response.ok(questionnaireService.findAllQuestionnaires()).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

        @GET
        @Path("/{taxCode}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getQuestionnaireByTaxCode(@PathParam("taxCode") String taxCode) {
        if (questionnaireService.findQuestionnaireByTaxCode(taxCode)!=null) {
            return Response.ok(questionnaireService.findQuestionnaireByTaxCode(taxCode)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    @GET
    @Path("risk")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRiskQuestionnaire() {
        if (!questionnaireService.findAllQuestionnaires().isEmpty()) {
            return Response.ok(questionnaireService.findQuestionnaireByRisk()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response submitQuestionnaire (Questionnaire questionnaire){
            boolean result = questionnaireService.create(questionnaire);
            if (result) {
                return Response.ok().status(Response.Status.CREATED).build();
            } else {
                return Response.notModified().build();
            }
        }

}
