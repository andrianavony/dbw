/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author S.ANDRIANAVONY
 */
@Entity
@Table(name = "specie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specie.findAll", query = "SELECT s FROM Specie s"),
    @NamedQuery(name = "Specie.findByIdspecie", query = "SELECT s FROM Specie s WHERE s.idspecie = :idspecie"),
    @NamedQuery(name = "Specie.findBySpeciename", query = "SELECT s FROM Specie s WHERE s.speciename = :speciename"),
    @NamedQuery(name = "Specie.findByOfficialname", query = "SELECT s FROM Specie s WHERE s.officialname = :officialname")})
public class Specie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idspecie;
    @Size(max = 50)
    @Column(length = 50)
    private String speciename;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specie")
    private List<Variety> varietyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specie")
    private List<Heritagebyspecieorigin> heritagebyspecieoriginList;
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

    public String getSpeciename() {
        return speciename;
    }

    public void setSpeciename(String speciename) {
        this.speciename = speciename;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    @XmlTransient
    public List<Variety> getVarietyList() {
        return varietyList;
    }

    public void setVarietyList(List<Variety> varietyList) {
        this.varietyList = varietyList;
    }

    @XmlTransient
    public List<Heritagebyspecieorigin> getHeritagebyspecieoriginList() {
        return heritagebyspecieoriginList;
    }

    public void setHeritagebyspecieoriginList(List<Heritagebyspecieorigin> heritagebyspecieoriginList) {
        this.heritagebyspecieoriginList = heritagebyspecieoriginList;
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
