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
    @NamedQuery(name = "Treatement.findAll", query = "SELECT t FROM Treatement t"),
    @NamedQuery(name = "Treatement.findByIdtreatement", query = "SELECT t FROM Treatement t WHERE t.idtreatement = :idtreatement"),
    @NamedQuery(name = "Treatement.findByTreatementname", query = "SELECT t FROM Treatement t WHERE t.treatementname = :treatementname"),
    @NamedQuery(name = "Treatement.findByDescription", query = "SELECT t FROM Treatement t WHERE t.description = :description")})
public class Treatement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idtreatement;
    @Size(max = 50)
    @Column(length = 50)
    private String treatementname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "idtreatement")
    private List<Batch> batchList;

    public Treatement() {
    }

    public Treatement(String idtreatement) {
        this.idtreatement = idtreatement;
    }

    public String getIdtreatement() {
        return idtreatement;
    }

    public void setIdtreatement(String idtreatement) {
        this.idtreatement = idtreatement;
    }

    public String getTreatementname() {
        return treatementname;
    }

    public void setTreatementname(String treatementname) {
        this.treatementname = treatementname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtreatement != null ? idtreatement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatement)) {
            return false;
        }
        Treatement other = (Treatement) object;
        if ((this.idtreatement == null && other.idtreatement != null) || (this.idtreatement != null && !this.idtreatement.equals(other.idtreatement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Treatement[ idtreatement=" + idtreatement + " ]";
    }
    
}
