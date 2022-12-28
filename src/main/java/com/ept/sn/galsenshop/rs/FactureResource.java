/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.rs;

import com.ept.sn.galsenshop.facades.FactureFacade;
import com.ept.sn.galsenshop.resources.Facture;
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

@Path("factures")
public class FactureResource {
    
    @EJB
    private FactureFacade factureFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Facture> getFactures() {
        
        return factureFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "galsenshop/facture"})
    public Facture getFactureById(@PathParam("id") Integer id) {
        Facture e = factureFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;
    }
    
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Facture createFacture(Facture e) {
        System.out.println("createFacture "+e);
        factureFacade.create(e);
        return e;
    }
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Facture updateEleve(@PathParam("id") Integer id, Facture e) {
        
        Facture el=getFactureById(id);
        //epdda el a partir de e
        el.setIdClient(e.getIdClient());
        
        //faire pour les autres attributs de la classe ou de l'objet
        
        factureFacade.edit(el);
        
        return el;
        
    }
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Facture> findFacture(@QueryParam("text") String searchText) {
        return factureFacade.findFacture(searchText);
    }
    
    
    
}


