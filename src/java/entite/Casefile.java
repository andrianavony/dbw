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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Casefile.findAll", query = "SELECT c FROM Casefile c"),
    @NamedQuery(name = "Casefile.findByIdcasefile", query = "SELECT c FROM Casefile c WHERE c.idcasefile = :idcasefile"),
    @NamedQuery(name = "Casefile.findByDescription", query = "SELECT c FROM Casefile c WHERE c.description = :description"),
    @NamedQuery(name = "Casefile.findByIdcasefilelims", query = "SELECT c FROM Casefile c WHERE c.idcasefilelims = :idcasefilelims")})
public class Casefile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idcasefile;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String idcasefilelims;
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    @OneToMany(mappedBy = "idcasefile")
    private List<Samples> samplesList;

    public Casefile() {
    }

    public Casefile(Long idcasefile) {
        this.idcasefile = idcasefile;
    }

    public Long getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(Long idcasefile) {
        this.idcasefile = idcasefile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdcasefilelims() {
        return idcasefilelims;
    }

    public void setIdcasefilelims(String idcasefilelims) {
        this.idcasefilelims = idcasefilelims;
    }

    public Batch getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(Batch idbatch) {
        this.idbatch = idbatch;
    }

    @XmlTransient
    public List<Samples> getSamplesList() {
        return samplesList;
    }

    public void setSamplesList(List<Samples> samplesList) {
        this.samplesList = samplesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcasefile != null ? idcasefile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casefile)) {
            return false;
        }
        Casefile other = (Casefile) object;
        if ((this.idcasefile == null && other.idcasefile != null) || (this.idcasefile != null && !this.idcasefile.equals(other.idcasefile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Casefile[ idcasefile=" + idcasefile + " ]";
    }
    
}
