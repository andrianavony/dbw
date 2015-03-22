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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Origin.findAll", query = "SELECT o FROM Origin o"),
    @NamedQuery(name = "Origin.findByIdorigin", query = "SELECT o FROM Origin o WHERE o.idorigin = :idorigin"),
    @NamedQuery(name = "Origin.findByOriginname", query = "SELECT o FROM Origin o WHERE o.originname = :originname"),
    @NamedQuery(name = "Origin.findByOrigincode", query = "SELECT o FROM Origin o WHERE o.origincode = :origincode"),
    @NamedQuery(name = "Origin.findByDescription", query = "SELECT o FROM Origin o WHERE o.description = :description")})
public class Origin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idorigin;
    @Size(max = 50)
    @Column(length = 50)
    private String originname;
    @Size(max = 50)
    @Column(length = 50)
    private String origincode;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin")
    private List<Heritagebyspecieorigin> heritagebyspecieoriginList;

    public Origin() {
    }

    public Origin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public Long getIdorigin() {
        return idorigin;
    }

    public void setIdorigin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public String getOriginname() {
        return originname;
    }

    public void setOriginname(String originname) {
        this.originname = originname;
    }

    public String getOrigincode() {
        return origincode;
    }

    public void setOrigincode(String origincode) {
        this.origincode = origincode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Heritagebyspecieorigin> getHeritagebyspecieoriginList() {
        return heritagebyspecieoriginList;
    }

    public void setHeritagebyspecieoriginList(List<Heritagebyspecieorigin> heritagebyspecieoriginList) {
        this.heritagebyspecieoriginList = heritagebyspecieoriginList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorigin != null ? idorigin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origin)) {
            return false;
        }
        Origin other = (Origin) object;
        if ((this.idorigin == null && other.idorigin != null) || (this.idorigin != null && !this.idorigin.equals(other.idorigin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Origin[ idorigin=" + idorigin + " ]";
    }
    
}
