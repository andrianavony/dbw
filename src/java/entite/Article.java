/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdarticle", query = "SELECT a FROM Article a WHERE a.idarticle = :idarticle")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idarticle;
    @JoinColumn(name = "IDGENERATION", referencedColumnName = "IDGENERATION")
    @ManyToOne
    private Generation idgeneration;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", insertable = false, updatable = false)
    @ManyToOne
    private Specie idspecie;
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;
     @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn( name="idvariety", referencedColumnName = "IDVARIETY", insertable = true, updatable = false, nullable = true),
        @JoinColumn( name="idspecie", referencedColumnName = "IDSPECIE", insertable = true, updatable = false, nullable = true)
    })
    private Variety idvariety;

    public Article() {
    }

    public Article(String idarticle) {
        this.idarticle = idarticle;
    }

    public String getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }

    public Generation getIdgeneration() {
        return idgeneration;
    }

    public void setIdgeneration(Generation idgeneration) {
        this.idgeneration = idgeneration;
    }

    public Specie getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(Specie idspecie) {
        this.idspecie = idspecie;
    }

    public Stage getIdstage() {
        return idstage;
    }

    public void setIdstage(Stage idstage) {
        this.idstage = idstage;
    }

    public Variety getIdvariety() {
        return idvariety;
    }

    public void setIdvariety(Variety idvariety) {
        this.idvariety = idvariety;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticle != null ? idarticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idarticle == null && other.idarticle != null) || (this.idarticle != null && !this.idarticle.equals(other.idarticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Article[ idarticle=" + idarticle + " ]";
    }
    
}
