/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heritagebyspecieorigin.findAll", query = "SELECT h FROM Heritagebyspecieorigin h"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByIdspecie", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.heritagebyspecieoriginPK.idspecie = :idspecie"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByIdorigin", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.heritagebyspecieoriginPK.idorigin = :idorigin"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByIdmodelanalysis", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.heritagebyspecieoriginPK.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByDownupboth", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.heritagebyspecieoriginPK.downupboth = :downupboth"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByHeritagebyspecieoriginname", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.heritagebyspecieoriginname = :heritagebyspecieoriginname"),
    @NamedQuery(name = "Heritagebyspecieorigin.findByDescription", query = "SELECT h FROM Heritagebyspecieorigin h WHERE h.description = :description")})
public class Heritagebyspecieorigin implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HeritagebyspecieoriginPK heritagebyspecieoriginPK;
    @Size(max = 50)
    @Column(length = 50)
    private String heritagebyspecieoriginname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modelanalysis modelanalysis;
    @JoinColumn(name = "IDORIGIN", referencedColumnName = "IDORIGIN", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Origin origin;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Specie specie;

    public Heritagebyspecieorigin() {
    }

    public Heritagebyspecieorigin(HeritagebyspecieoriginPK heritagebyspecieoriginPK) {
        this.heritagebyspecieoriginPK = heritagebyspecieoriginPK;
    }

    public Heritagebyspecieorigin(String idspecie, long idorigin, long idmodelanalysis, short downupboth) {
        this.heritagebyspecieoriginPK = new HeritagebyspecieoriginPK(idspecie, idorigin, idmodelanalysis, downupboth);
    }

    public HeritagebyspecieoriginPK getHeritagebyspecieoriginPK() {
        return heritagebyspecieoriginPK;
    }

    public void setHeritagebyspecieoriginPK(HeritagebyspecieoriginPK heritagebyspecieoriginPK) {
        this.heritagebyspecieoriginPK = heritagebyspecieoriginPK;
    }

    public String getHeritagebyspecieoriginname() {
        return heritagebyspecieoriginname;
    }

    public void setHeritagebyspecieoriginname(String heritagebyspecieoriginname) {
        this.heritagebyspecieoriginname = heritagebyspecieoriginname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Modelanalysis getModelanalysis() {
        return modelanalysis;
    }

    public void setModelanalysis(Modelanalysis modelanalysis) {
        this.modelanalysis = modelanalysis;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heritagebyspecieoriginPK != null ? heritagebyspecieoriginPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heritagebyspecieorigin)) {
            return false;
        }
        Heritagebyspecieorigin other = (Heritagebyspecieorigin) object;
        if ((this.heritagebyspecieoriginPK == null && other.heritagebyspecieoriginPK != null) || (this.heritagebyspecieoriginPK != null && !this.heritagebyspecieoriginPK.equals(other.heritagebyspecieoriginPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Heritagebyspecieorigin[ heritagebyspecieoriginPK=" + heritagebyspecieoriginPK + " ]";
    }
    
}
