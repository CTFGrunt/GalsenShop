/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ept.sn.galsenshop.resources;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;





/**
 *
 * @author Dosecurity
 */

@XmlRootElement(name = "categorie")
@Entity
@Table(name = "categorie")
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCode", query = "SELECT c FROM Categorie c WHERE c.code = :code"),
    @NamedQuery(name = "Categorie.findByLibelle", query = "SELECT c FROM Categorie c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Categorie.findByDescription", query = "SELECT c FROM Categorie c WHERE c.description = :description"),
    @NamedQuery(name = "Categorie.findByTva", query = "SELECT c FROM Categorie c WHERE c.tva = :tva")})
public class Categorie implements Serializable {

    @Size(max = 30)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "codeCategorie")
    private Collection<Article> articleCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tva")
    private Double tva;

    public Categorie() {
    }

    public Categorie(String code, String description, String libelle, Double tva) {
        this.code = code;
        this.description = description ;
        this.libelle = libelle;
        this.tva = tva ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie( code: " + code + ", description: " + description + ", libelle: "+ libelle + ", tva: "+ tva + ")";
    }


    @XmlTransient
    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
