/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop;

import com.ept.sn.galsenshop.facades.CategorieFacade;
import com.ept.sn.galsenshop.resources.Categorie;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Dosecurity
 */
@Named(value = "listCategorieBean")
@RequestScoped
public class ListCategorieBean {
    
    @EJB
    private CategorieFacade categorieFacade;

    private List<Categorie> categories;
    
    public ListCategorieBean() {
    }

    public List<Categorie> getCategories() {
        if (categories==null) {
            categories=categorieFacade.findAll();
        }
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
    
    
}

