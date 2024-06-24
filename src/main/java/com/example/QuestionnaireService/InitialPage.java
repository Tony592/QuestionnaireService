package com.example.QuestionnaireService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;


@Path("welcome")
public class InitialPage {
    @GET
    @Produces("text/plain")
    public String get() {
        return "Welcome to the hospital, in the next page you will insert your personal data";
    }
}
