/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ept.sn.galsenshop;

import com.ept.sn.galsenshop.facades.CategorieFacade;
import com.ept.sn.galsenshop.resources.Categorie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


/**
 *
 * @author Dosecurity
 */
@Singleton
@Startup
public class InitCategorie {
    
    
    @EJB
    private CategorieFacade categorieFacade;
    
    
    @PostConstruct()
    private void init() {
        
        List<Categorie> categories;
        
        categories = new ArrayList<>();
        
        categories.add(new Categorie("BSE", "biens sociaux essentiels",
            "les médicaments, appareils médico-chirurgicaux, le papier journal, les livres, les journaux, les fauteuils roulants, certains engrais etc", 0.0)) ;
        
        categories.add(new Categorie("BPN", "biens de première nécessité",
            "les matières premières de base, les biens d’équipement et les intrants spécifiques ", 5.0)) ;
        
        categories.add(new Categorie("IPI", " intrants et produits intermédiaires", "", 10.0)) ;
        
        categories.add(new Categorie("BCF", "biens de consommation finale", "catégorie par defaut", 20.0)) ;
        
         for (Categorie cat : categories) {
            System.out.println("categorie enregistre: "+ cat.toString());
            categorieFacade.create(cat);
            // return "listEleve.xhtml?faces-redirect=true";
        }

    }
      

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
