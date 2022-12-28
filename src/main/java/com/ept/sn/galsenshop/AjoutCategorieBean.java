/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop;


import com.ept.sn.galsenshop.facades.CategorieFacade;
import com.ept.sn.galsenshop.resources.Categorie;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;


/**
 *
 * @author Dosecurity
 */

@Named(value = "ajoutCategorieBean")
@ViewScoped
public class AjoutCategorieBean implements Serializable {

    private Categorie categorie=new Categorie();
    
    @EJB
    private CategorieFacade categorieFacade;
    
    public AjoutCategorieBean() {
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public String enregistrerCategorie(){
        System.out.println("categorie enregistre "+categorie);
        categorieFacade.create(categorie);
        return "listCategorie.xhtml?faces-redirect=true";
    }
    
    
    
}

