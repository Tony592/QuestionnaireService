package com.example.QuestionnaireService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("patient")

public class PatientResource {
    PatientService patientService = PatientService.getInstance();


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String InsertData() {
        return "Insert Data: Name, Surname, Birthday Date, TaxCode, Telephone Number";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getPatient() {
        if (!patientService.findAll().isEmpty()) {
            return Response.ok(patientService.findAll()).build();
        } else {
            return Response.ok(patientService.toString()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{taxcode}")
    public Response getPatientByTaxCode(@PathParam("taxcode") String taxCode) {
        if (patientService.findBytaxCode(taxCode) !=null) {
            return Response.ok(patientService.findBytaxCode(taxCode)).build();
        } else {
            return Response.status(404).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response createPatient(Patient patient) {
        boolean result = patientService.create(patient);
        System.out.println(result);
        System.out.println(patientService.findAll().size());
        if (result) {
            return Response.ok().status(Response.Status.CREATED).build();

        } else {
            return Response.notModified().build();

        }
    }

}
