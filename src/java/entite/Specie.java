/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specie.findAll", query = "SELECT s FROM Specie s"),
    @NamedQuery(name = "Specie.findByIdspecie", query = "SELECT s FROM Specie s WHERE s.idspecie = :idspecie")})
public class Specie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idspecie;
    @OneToMany(mappedBy = "idspecie")
    private List<Article> articleList;

    public Specie() {
    }

    public Specie(String idspecie) {
        this.idspecie = idspecie;
    }

    public String getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(String idspecie) {
        this.idspecie = idspecie;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspecie != null ? idspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specie)) {
            return false;
        }
        Specie other = (Specie) object;
        if ((this.idspecie == null && other.idspecie != null) || (this.idspecie != null && !this.idspecie.equals(other.idspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Specie[ idspecie=" + idspecie + " ]";
    }
    
}
