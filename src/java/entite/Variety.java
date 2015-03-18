/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variety.findAll", query = "SELECT v FROM Variety v"),
    @NamedQuery(name = "Variety.findByIdvariety", query = "SELECT v FROM Variety v WHERE v.varietyPK.idvariety = :idvariety"),
    @NamedQuery(name = "Variety.findByIdspecie", query = "SELECT v FROM Variety v WHERE v.varietyPK.idspecie = :idspecie")})
public class Variety implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VarietyPK varietyPK;
    @OneToMany(mappedBy = "idvariety")
    private List<Article> articleList;

    public Variety() {
    }

    public Variety(VarietyPK varietyPK) {
        this.varietyPK = varietyPK;
    }

    public Variety(String idvariety, String idspecie) {
        this.varietyPK = new VarietyPK(idvariety, idspecie);
    }

    public VarietyPK getVarietyPK() {
        return varietyPK;
    }

    public void setVarietyPK(VarietyPK varietyPK) {
        this.varietyPK = varietyPK;
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
        hash += (varietyPK != null ? varietyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variety)) {
            return false;
        }
        Variety other = (Variety) object;
        if ((this.varietyPK == null && other.varietyPK != null) || (this.varietyPK != null && !this.varietyPK.equals(other.varietyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Variety[ varietyPK=" + varietyPK + " ]";
    }
    
}
