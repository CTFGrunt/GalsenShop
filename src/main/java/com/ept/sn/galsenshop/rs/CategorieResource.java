/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.rs;

import com.ept.sn.galsenshop.facades.CategorieFacade;
import com.ept.sn.galsenshop.resources.Categorie;
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

@Path("categories")
public class CategorieResource {
    
    @EJB
    private CategorieFacade categorieFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> getCategories() {
        
        return categorieFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "galsenshop/categorie"})
    public Categorie getCategorieById(@PathParam("id") Integer id) {
        Categorie e = categorieFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;
    }
    
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie createCategorie(Categorie e) {
        System.out.println("createCategorie "+e);
        categorieFacade.create(e);
        return e;
    }
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie updateEleve(@PathParam("id") Integer id, Categorie e) {
        
        Categorie el=getCategorieById(id);
        //epdda el a partir de e
        el.setCode(e.getCode());
        
        //faire pour les autres attributs de la classe ou de l'objet
        
        categorieFacade.edit(el);
        
        return el;
        
    }
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> findCategorie(@QueryParam("text") String searchText) {
        return categorieFacade.findCategorie(searchText);
    }
    
    
    
}


