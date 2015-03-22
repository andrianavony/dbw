/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sampleplan.findAll", query = "SELECT s FROM Sampleplan s"),
    @NamedQuery(name = "Sampleplan.findByIdsampleplan", query = "SELECT s FROM Sampleplan s WHERE s.idsampleplan = :idsampleplan"),
    @NamedQuery(name = "Sampleplan.findBySampleplanname", query = "SELECT s FROM Sampleplan s WHERE s.sampleplanname = :sampleplanname"),
    @NamedQuery(name = "Sampleplan.findByDescription", query = "SELECT s FROM Sampleplan s WHERE s.description = :description"),
    @NamedQuery(name = "Sampleplan.findBySampleplanidlims", query = "SELECT s FROM Sampleplan s WHERE s.sampleplanidlims = :sampleplanidlims")})
public class Sampleplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idsampleplan;
    @Size(max = 50)
    @Column(length = 50)
    private String sampleplanname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private BigInteger sampleplanidlims;
    @JoinColumn(name = "IDSAMPLEPLANGROUP", referencedColumnName = "IDSAMPLEPLANGROUP")
    @ManyToOne
    private Sampleplangroup idsampleplangroup;

    public Sampleplan() {
    }

    public Sampleplan(Long idsampleplan) {
        this.idsampleplan = idsampleplan;
    }

    public Long getIdsampleplan() {
        return idsampleplan;
    }

    public void setIdsampleplan(Long idsampleplan) {
        this.idsampleplan = idsampleplan;
    }

    public String getSampleplanname() {
        return sampleplanname;
    }

    public void setSampleplanname(String sampleplanname) {
        this.sampleplanname = sampleplanname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getSampleplanidlims() {
        return sampleplanidlims;
    }

    public void setSampleplanidlims(BigInteger sampleplanidlims) {
        this.sampleplanidlims = sampleplanidlims;
    }

    public Sampleplangroup getIdsampleplangroup() {
        return idsampleplangroup;
    }

    public void setIdsampleplangroup(Sampleplangroup idsampleplangroup) {
        this.idsampleplangroup = idsampleplangroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsampleplan != null ? idsampleplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sampleplan)) {
            return false;
        }
        Sampleplan other = (Sampleplan) object;
        if ((this.idsampleplan == null && other.idsampleplan != null) || (this.idsampleplan != null && !this.idsampleplan.equals(other.idsampleplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Sampleplan[ idsampleplan=" + idsampleplan + " ]";
    }
    
}
