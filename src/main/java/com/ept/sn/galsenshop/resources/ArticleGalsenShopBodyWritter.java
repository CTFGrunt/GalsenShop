/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Dosecurity
 */
@Provider
@Produces("galsenshop/article")
public class ArticleGalsenShopBodyWritter implements MessageBodyWriter<Article>{

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        System.out.println("ArticleGalsenShopBodyWritter isWriteable");
        return mt.toString().equals("galsenshop/article") && type==Article.class;
    }

    @Override
    public void writeTo(Article t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
        out.write(t.toString().getBytes("UTF-8"));
        out.flush();
    }
    
}