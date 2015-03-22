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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Measures.findAll", query = "SELECT m FROM Measures m"),
    @NamedQuery(name = "Measures.findByIdmeasure", query = "SELECT m FROM Measures m WHERE m.idmeasure = :idmeasure"),
    @NamedQuery(name = "Measures.findByMeasurename", query = "SELECT m FROM Measures m WHERE m.measurename = :measurename"),
    @NamedQuery(name = "Measures.findByDescription", query = "SELECT m FROM Measures m WHERE m.description = :description"),
    @NamedQuery(name = "Measures.findByOfficialname", query = "SELECT m FROM Measures m WHERE m.officialname = :officialname"),
    @NamedQuery(name = "Measures.findByPrintname", query = "SELECT m FROM Measures m WHERE m.printname = :printname")})
public class Measures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idmeasure;
    @Size(max = 50)
    @Column(length = 50)
    private String measurename;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    @Size(max = 50)
    @Column(length = 50)
    private String printname;
    @OneToMany(mappedBy = "idmeasure")
    private List<Methoddetails> methoddetailsList;
    @JoinColumns({
        @JoinColumn(name = "IDPOSSIBLEVALUE",referencedColumnName = "IDPOSSIBLEVALUE"),
        @JoinColumn(name = "IDMEASURE"      ,referencedColumnName = "IDMEASURE")
    })
    @ManyToOne
    private Possiblevaluesdetails idpossiblevalue;
    @OneToMany(mappedBy = "idmeasure")
    private List<Results> resultsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measures")
    private List<Specificationdetails> specificationdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measures")
    private List<Possiblevaluesdetails> possiblevaluesdetailsList;

    public Measures() {
    }

    public Measures(Long idmeasure) {
        this.idmeasure = idmeasure;
    }

    public Long getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(Long idmeasure) {
        this.idmeasure = idmeasure;
    }

    public String getMeasurename() {
        return measurename;
    }

    public void setMeasurename(String measurename) {
        this.measurename = measurename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    public String getPrintname() {
        return printname;
    }

    public void setPrintname(String printname) {
        this.printname = printname;
    }

    @XmlTransient
    public List<Methoddetails> getMethoddetailsList() {
        return methoddetailsList;
    }

    public void setMethoddetailsList(List<Methoddetails> methoddetailsList) {
        this.methoddetailsList = methoddetailsList;
    }

    public Possiblevaluesdetails getIdpossiblevalue() {
        return idpossiblevalue;
    }

    public void setIdpossiblevalue(Possiblevaluesdetails idpossiblevalue) {
        this.idpossiblevalue = idpossiblevalue;
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
    public List<Possiblevaluesdetails> getPossiblevaluesdetailsList() {
        return possiblevaluesdetailsList;
    }

    public void setPossiblevaluesdetailsList(List<Possiblevaluesdetails> possiblevaluesdetailsList) {
        this.possiblevaluesdetailsList = possiblevaluesdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmeasure != null ? idmeasure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measures)) {
            return false;
        }
        Measures other = (Measures) object;
        if ((this.idmeasure == null && other.idmeasure != null) || (this.idmeasure != null && !this.idmeasure.equals(other.idmeasure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Measures[ idmeasure=" + idmeasure + " ]";
    }
    
}
