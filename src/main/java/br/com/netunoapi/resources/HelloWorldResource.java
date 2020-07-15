/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Thiago Luiz
 */
@Path("hello")
public class HelloWorldResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String helloworld() {
        return "Hello World Java Web Service!";  
    }
}
