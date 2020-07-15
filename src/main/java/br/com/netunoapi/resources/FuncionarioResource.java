/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.resources;

import br.com.netunoapi.models.Funcionario;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Thiago Luiz
 */
@Stateless
@Path("funcionario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioResource {
    
    @PersistenceContext(unitName = "LavacaoPU")
    EntityManager entityManager;
    
    @GET    
    public List<Funcionario> getFuncionario() {
        TypedQuery<Funcionario> query = entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
        return query.getResultList();
    }
    
    @POST
    public Response addFuncionario(Funcionario funcionario){
        entityManager.persist(funcionario);
        return Response.status(Response.Status.CREATED).entity(funcionario).build();
    }
    
    @GET
    @Path("{id}")
    public Funcionario getFuncionarios(@PathParam("id")UUID id) {
        return entityManager.find(Funcionario.class, id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeFuncionario(@PathParam("id")UUID id) {
        Funcionario funcionario = entityManager.find(Funcionario.class, id);
        entityManager.remove(funcionario);
    }
    
    @PUT
    @Path("{id}")
    public Funcionario updateFuncionario(@PathParam("id")UUID id, Funcionario c) {
        c.setId(id);
        entityManager.merge(c);
        return c;
    }    
}
