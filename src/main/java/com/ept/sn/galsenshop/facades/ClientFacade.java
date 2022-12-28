/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.facades;


import com.ept.sn.galsenshop.resources.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dosecurity
 */
@Stateless
public class ClientFacade  extends AbstractFacade<Client>{
    
    
    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em ;

    @Override
    protected EntityManager getEntityManager() {
        return em ;
    }
    
    public ClientFacade() {
        
        super(Client.class) ;
        
    }

    // à remodeler pour les autres Façades
    
    public List<Client> findClient(String searchText) {
        
        String requete = "SELECT * FROM categorie c WHERE c.libelle like '%" + searchText + "%' ORDER BY c.code DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }
    
}
