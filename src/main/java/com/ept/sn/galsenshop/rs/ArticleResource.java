/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.rs;

import com.ept.sn.galsenshop.facades.ArticleFacade;
import com.ept.sn.galsenshop.resources.Article;
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

@Path("articles")
public class ArticleResource {
    
    @EJB
    private ArticleFacade articleFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> getArticles() {
        
        return articleFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "galsenshop/article"})
    public Article getArticleById(@PathParam("id") Integer id) {
        Article e = articleFacade.find(id);
        if (e == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return e;
    }
    
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article createArticle(Article e) {
        System.out.println("createArticle "+e);
        articleFacade.create(e);
        return e;
    }
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article updateEleve(@PathParam("id") Integer id, Article e) {
        
        Article el=getArticleById(id);
        //epdda el a partir de e
        el.setCode(e.getCode());
        
        //faire pour les autres attributs de la classe ou de l'objet
        
        articleFacade.edit(el);
        
        return el;
        
    }
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> findArticle(@QueryParam("text") String searchText) {
        return articleFacade.findArticle(searchText);
    }
    
    
    
}


