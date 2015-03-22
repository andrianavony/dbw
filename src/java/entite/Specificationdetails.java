/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "Specificationdetails.findAll", query = "SELECT s FROM Specificationdetails s"),
    @NamedQuery(name = "Specificationdetails.findByIdspecification", query = "SELECT s FROM Specificationdetails s WHERE s.specificationdetailsPK.idspecification = :idspecification"),
    @NamedQuery(name = "Specificationdetails.findByIdmeasure", query = "SELECT s FROM Specificationdetails s WHERE s.specificationdetailsPK.idmeasure = :idmeasure"),
    @NamedQuery(name = "Specificationdetails.findByIdmethoddetails", query = "SELECT s FROM Specificationdetails s WHERE s.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Specificationdetails.findByDescription", query = "SELECT s FROM Specificationdetails s WHERE s.description = :description"),
    @NamedQuery(name = "Specificationdetails.findByMinvalue", query = "SELECT s FROM Specificationdetails s WHERE s.minvalue = :minvalue"),
    @NamedQuery(name = "Specificationdetails.findByMaxvalue", query = "SELECT s FROM Specificationdetails s WHERE s.maxvalue = :maxvalue"),
    @NamedQuery(name = "Specificationdetails.findByIdstatus", query = "SELECT s FROM Specificationdetails s WHERE s.idstatus = :idstatus")})
public class Specificationdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecificationdetailsPK specificationdetailsPK;
    private BigInteger idmethoddetails;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private BigInteger minvalue;
    private BigInteger maxvalue;
    private Short idstatus;
    @JoinColumn(name = "IDMEASURE", referencedColumnName = "IDMEASURE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Measures measures;
    @JoinColumn(name = "IDMETHOD", referencedColumnName = "IDMETHOD")
    @ManyToOne
    private Method idmethod;
    @JoinColumn(name = "IDSPECIFICATION", referencedColumnName = "IDSPECIFICATION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Specification specification;

    public Specificationdetails() {
    }

    public Specificationdetails(SpecificationdetailsPK specificationdetailsPK) {
        this.specificationdetailsPK = specificationdetailsPK;
    }

    public Specificationdetails(long idspecification, long idmeasure) {
        this.specificationdetailsPK = new SpecificationdetailsPK(idspecification, idmeasure);
    }

    public SpecificationdetailsPK getSpecificationdetailsPK() {
        return specificationdetailsPK;
    }

    public void setSpecificationdetailsPK(SpecificationdetailsPK specificationdetailsPK) {
        this.specificationdetailsPK = specificationdetailsPK;
    }

    public BigInteger getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(BigInteger idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMinvalue() {
        return minvalue;
    }

    public void setMinvalue(BigInteger minvalue) {
        this.minvalue = minvalue;
    }

    public BigInteger getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(BigInteger maxvalue) {
        this.maxvalue = maxvalue;
    }

    public Short getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Short idstatus) {
        this.idstatus = idstatus;
    }

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public Method getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(Method idmethod) {
        this.idmethod = idmethod;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specificationdetailsPK != null ? specificationdetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specificationdetails)) {
            return false;
        }
        Specificationdetails other = (Specificationdetails) object;
        if ((this.specificationdetailsPK == null && other.specificationdetailsPK != null) || (this.specificationdetailsPK != null && !this.specificationdetailsPK.equals(other.specificationdetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Specificationdetails[ specificationdetailsPK=" + specificationdetailsPK + " ]";
    }
    
}
