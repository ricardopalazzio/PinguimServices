/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mypinguim.pinguimservices.enumerated.Role;
import com.mypinguim.pinguimservices.model.Pais;
import com.mypinguim.pinguimservices.security.AuthenticatedUser;
import com.mypinguim.pinguimservices.security.Secured;
import com.mypinguim.pinguimservices.security.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricar
 */
@Stateless
@Path("com.mypinguim.pinguimservices.model.pais")
public class PaisFacadeREST extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "pinguimPU")
    private EntityManager em;

    @Inject
    @AuthenticatedUser Instance<User> user;
    
    public PaisFacadeREST() {
        super(Pais.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Secured(value = {Role.ADMINISTRATOR , Role.MASTER_VENDOR})
    public void create(Pais entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Pais entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @Secured(value = {Role.ADMINISTRATOR})
    public void remove(@PathParam("id") Long id  ) {
        try{
            System.out.println("service.PaisFacadeREST.remove()"+"  helooooo "+ user.get().getToken());
      //  super.remove(super.find(id));
        }catch(NotAuthorizedException e){
            e.printStackTrace();
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pais find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
