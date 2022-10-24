package com.example;

import org.jboss.resteasy.reactive.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Path("test2")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response save(@MultipartForm FileRequest fileCreateRequest) {
        // do some validations and save the file to some repository


        java.nio.file.Path path
                = Paths.get("C:\\test2\\gfg.txt");

        // Custom string as an input
        String str
                = fileCreateRequest.getName();

        // Converting string to byte array
        // using getBytes() method
        byte[] arr = str.getBytes();

        // Try block to check for exceptions
        try {
            // Now calling Files.write() method using path
            // and byte array
            Files.write(path, arr);
        }

        // Catch block to handle the exceptions
        catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }

        return Response.ok().build();
    }

}