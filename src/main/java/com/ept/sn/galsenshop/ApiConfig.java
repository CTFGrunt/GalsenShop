/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */


@OpenAPIDefinition(
        info = @Info(
                title = "Service Galsen Shop",
                description = "Le service de la supermarché de Galsen Shop",
                contact = @Contact(name = "Mamouodu sow", email = "mamoudoumamadousow@gmail.com", url="http://ept.sn")
        ),
        servers = @Server(
                url= "http://localhost:8080/galsenshop/"
        )
)

@ApplicationPath("api")
public class ApiConfig extends Application {
    
}