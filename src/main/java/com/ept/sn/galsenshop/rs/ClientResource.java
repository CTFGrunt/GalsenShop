/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.rs;

import com.ept.sn.galsenshop.facades.ClientFacade;
import com.ept.sn.galsenshop.resources.Client;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dosecurity
 */

@Path("clients")
public class ClientResource {
    
    @EJB
    private ClientFacade clientFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> getClients() {
        
        return clientFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "galsenshop/client"})
    public Client getClientById(@PathParam("id") Integer id) {
        Client e = clientFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;
    }
    
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client createClient(Client e) {
        System.out.println("createClient "+e);
        clientFacade.create(e);
        return e;
    }
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client updateEleve(@PathParam("id") Integer id, Client e) {
        
        Client el=getClientById(id);
        //epdda el a partir de e
        el.setNom(e.getNom());
        
        //faire pour les autres attributs de la classe ou de l'objet
        
        clientFacade.edit(el);
        
        return el;
        
    }
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> findClient(@QueryParam("text") String searchText) {
        return clientFacade.findClient(searchText);
    }
    
    
    
}


