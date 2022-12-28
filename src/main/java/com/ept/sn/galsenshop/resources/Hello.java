/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dosecurity
 */
@Path("hello")
public class Hello {
    
    @GET
    public Response ping(){
        return Response
                .ok("Hello world")
                .status(Response.Status.OK)
                .build();
    }
}
