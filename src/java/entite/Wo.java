/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@Table(name = "wo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wo.findAll", query = "SELECT w FROM Wo w"),
    @NamedQuery(name = "Wo.findByIdwo", query = "SELECT w FROM Wo w WHERE w.woPK.idwo = :idwo"),
    @NamedQuery(name = "Wo.findByIdcompany", query = "SELECT w FROM Wo w WHERE w.woPK.idcompany = :idcompany"),
    @NamedQuery(name = "Wo.findByIddiagram", query = "SELECT w FROM Wo w WHERE w.iddiagram = :iddiagram"),
    @NamedQuery(name = "Wo.findByDescription", query = "SELECT w FROM Wo w WHERE w.description = :description")
    })
public class Wo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WoPK woPK;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "idwo")
    private List<Trace> traceList;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "IDDIAGRAM", referencedColumnName = "IDDIAGRAM")
    @ManyToOne
    private Calibrationdiagram iddiagram;
    @OneToMany(mappedBy = "idwo")
    private List<Batch> batchList;

    public Wo() {
    }

    public Wo(WoPK woPK) {
        this.woPK = woPK;
    }

    public Wo(String idwo, String idcompany) {
        this.woPK = new WoPK(idwo, idcompany);
    }

    public WoPK getWoPK() {
        return woPK;
    }

    public void setWoPK(WoPK woPK) {
        this.woPK = woPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Trace> getTraceList() {
        return traceList;
    }

    public void setTraceList(List<Trace> traceList) {
        this.traceList = traceList;
    }
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Calibrationdiagram getIddiagram() {
        return iddiagram;
    }

    public void setIddiagram(Calibrationdiagram iddiagram) {
        this.iddiagram = iddiagram;
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
        hash += (woPK != null ? woPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wo)) {
            return false;
        }
        Wo other = (Wo) object;
        if ((this.woPK == null && other.woPK != null) || (this.woPK != null && !this.woPK.equals(other.woPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Wo[ woPK=" + woPK + " ]";
    }
    
}
