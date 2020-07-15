/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netunoapi.resources;

import br.com.netunoapi.models.Automovel;
import java.util.ArrayList;
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
@Path("automovel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutomovelResource {
    
    static List<Automovel> clientes = new ArrayList<Automovel>();
    
    @PersistenceContext(unitName = "LavacaoPU")
    EntityManager entityManager;
    
    @GET
    public List<Automovel> getAutomovel(){
        TypedQuery<Automovel> query = entityManager.createQuery("SELECT a FROM Automovel a", Automovel.class);
        return query.getResultList();
    }
    
    @POST
    public Response addAutomovel(Automovel automovel){
        entityManager.persist(automovel);
        return Response.status(Response.Status.CREATED).entity(automovel).build();
    }
    
    @GET
    @Path("{id}")
    public Automovel getAutomoveis(@PathParam("id")UUID id){
        return entityManager.find(Automovel.class, id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeAutomovel(@PathParam("id")UUID id){
        Automovel automovel = entityManager.find(Automovel.class, id);
        entityManager.remove(automovel);
    }
    
    @PUT
    @Path("{id}")
    public Automovel updateAutomovel(@PathParam("id")UUID id, Automovel a){
        a.setId(id);
        entityManager.merge(a);
        return a;
    }
}
