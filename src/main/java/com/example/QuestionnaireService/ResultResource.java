package com.example.QuestionnaireService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("result")
public class ResultResource {

    ResultService resultService = new ResultService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ok")
    public Response getOk() {
            return Response.ok(resultService.createOk()).build();
        }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/bad")
    public Response getBad() {
        return Response.ok(resultService.createBad()).build();
    }
}
