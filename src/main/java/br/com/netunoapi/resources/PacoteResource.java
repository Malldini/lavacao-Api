/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.resources;

import br.com.netunoapi.models.Pacote;
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
@Path("pacote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacoteResource {
    
    @PersistenceContext(unitName = "LavacaoPU")
    EntityManager entityManager;
    
    @GET
    public List<Pacote> getPacote(){
        TypedQuery<Pacote> query = entityManager.createQuery("SELECT p FROM Pacote p", Pacote.class);
        return query.getResultList();
    }
    
    @POST
    public Response addPacote(Pacote pacote){
        entityManager.persist(pacote);
        return Response.status(Response.Status.CREATED).entity(pacote).build();
    }
    
    @GET
    @Path("{id}")
    public Pacote getPacotes(@PathParam("id")UUID id){
        return entityManager.find(Pacote.class, id);
    }
    
    @DELETE
    @Path("{id}")
    public void removePacote(@PathParam("id")UUID id){
        Pacote pacote = entityManager.find(Pacote.class, id);
        entityManager.remove(pacote);
    }
    
    @PUT
    @Path("{id}")
    public Pacote updatePacote(@PathParam("id")UUID id, Pacote p){
        p.setId(id);
        entityManager.merge(p);
        return p;
    }
}
