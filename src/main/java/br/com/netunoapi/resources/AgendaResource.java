package br.com.netunoapi.resources;


import br.com.netunoapi.models.Agenda;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

@Stateless
@Path("agenda")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgendaResource {
    
    @PersistenceContext(unitName = "LavacaoPU")
    EntityManager entityManager;
    static List<Agenda> agend = new ArrayList<>();
    
    @GET
    public List<Agenda> getAgenda(){
          return  entityManager
                .createQuery("SELECT g FROM Agenda g", Agenda.class)
                .getResultList();
    }
    
    @POST
    public Response addAgenda (Agenda agenda){
        entityManager.persist(agenda);
        return Response.status(Response.Status.CREATED).entity(agenda).build();
        
    }    
    @GET
    @Path("{id}")
    public Agenda getAgendas(@PathParam("id") UUID id){
        return entityManager.find(Agenda.class, id);
    }
    
    @DELETE
    @Path("{id}")
    public void removeAgenda(@PathParam("id") UUID id){
        Agenda agenda = entityManager.find(Agenda.class, id);
        entityManager.remove(agenda);
    }
    
    @PUT
    @Path("{id}")
    public Agenda updateAgenda(@PathParam("id") UUID id, Agenda g){
       g.setId(id);
        entityManager.merge(g);
        return g;
        
        
    }
}