/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "Specification.findAll", query = "SELECT s FROM Specification s"),
    @NamedQuery(name = "Specification.findByIdspecification", query = "SELECT s FROM Specification s WHERE s.idspecification = :idspecification"),
    @NamedQuery(name = "Specification.findByIdmodelanalysis", query = "SELECT s FROM Specification s WHERE s.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Specification.findByDescription", query = "SELECT s FROM Specification s WHERE s.description = :description")})
public class Specification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idspecification;
    private BigInteger idmodelanalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "idspecification")
    private List<Results> resultsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specification")
    private List<Specificationdetails> specificationdetailsList;
    @OneToMany(mappedBy = "idspecification")
    private List<Analysis> analysisList;

    public Specification() {
    }

    public Specification(Long idspecification) {
        this.idspecification = idspecification;
    }

    public Long getIdspecification() {
        return idspecification;
    }

    public void setIdspecification(Long idspecification) {
        this.idspecification = idspecification;
    }

    public BigInteger getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(BigInteger idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @XmlTransient
    public List<Specificationdetails> getSpecificationdetailsList() {
        return specificationdetailsList;
    }

    public void setSpecificationdetailsList(List<Specificationdetails> specificationdetailsList) {
        this.specificationdetailsList = specificationdetailsList;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspecification != null ? idspecification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specification)) {
            return false;
        }
        Specification other = (Specification) object;
        if ((this.idspecification == null && other.idspecification != null) || (this.idspecification != null && !this.idspecification.equals(other.idspecification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Specification[ idspecification=" + idspecification + " ]";
    }
    
}
