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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Method.findAll", query = "SELECT m FROM Method m"),
    @NamedQuery(name = "Method.findByIdmethod", query = "SELECT m FROM Method m WHERE m.idmethod = :idmethod"),
    @NamedQuery(name = "Method.findByMethodname", query = "SELECT m FROM Method m WHERE m.methodname = :methodname"),
    @NamedQuery(name = "Method.findByDescription", query = "SELECT m FROM Method m WHERE m.description = :description"),
    @NamedQuery(name = "Method.findByOfficialname", query = "SELECT m FROM Method m WHERE m.officialname = :officialname"),
    @NamedQuery(name = "Method.findByIsvirtual", query = "SELECT m FROM Method m WHERE m.isvirtual = :isvirtual"),
    @NamedQuery(name = "Method.findByOfficialanalysis", query = "SELECT m FROM Method m WHERE m.officialanalysis = :officialanalysis"),
    @NamedQuery(name = "Method.findByInternalanalysis", query = "SELECT m FROM Method m WHERE m.internalanalysis = :internalanalysis")})
public class Method implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long idmethod;
    @Size(max = 50)
    @Column(length = 50)
    private String methodname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    private Boolean isvirtual;
    private Boolean officialanalysis;
    private Boolean internalanalysis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "method")
    private List<Methoddetails> methoddetailsList;
    @OneToMany(mappedBy = "idsubmethod")
    private List<Methoddetails> methoddetailsList1;
    @OneToMany(mappedBy = "idmethod")
    private List<Results> resultsList;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS")
    @ManyToOne
    private Modelanalysis idmodelanalysis;
    @OneToMany(mappedBy = "idmother")
    private List<Method> methodList;
    @JoinColumn(name = "IDMOTHER", referencedColumnName = "IDMETHOD")
    @ManyToOne
    private Method idmother;
    @OneToMany(mappedBy = "idmethod")
    private List<Specificationdetails> specificationdetailsList;
    @OneToMany(mappedBy = "idmethod")
    private List<Analysis> analysisList;

    public Method() {
    }

    public Method(Long idmethod) {
        this.idmethod = idmethod;
    }

    public Long getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(Long idmethod) {
        this.idmethod = idmethod;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
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

    public Boolean getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Boolean isvirtual) {
        this.isvirtual = isvirtual;
    }

    public Boolean getOfficialanalysis() {
        return officialanalysis;
    }

    public void setOfficialanalysis(Boolean officialanalysis) {
        this.officialanalysis = officialanalysis;
    }

    public Boolean getInternalanalysis() {
        return internalanalysis;
    }

    public void setInternalanalysis(Boolean internalanalysis) {
        this.internalanalysis = internalanalysis;
    }

    @XmlTransient
    public List<Methoddetails> getMethoddetailsList() {
        return methoddetailsList;
    }

    public void setMethoddetailsList(List<Methoddetails> methoddetailsList) {
        this.methoddetailsList = methoddetailsList;
    }

    @XmlTransient
    public List<Methoddetails> getMethoddetailsList1() {
        return methoddetailsList1;
    }

    public void setMethoddetailsList1(List<Methoddetails> methoddetailsList1) {
        this.methoddetailsList1 = methoddetailsList1;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    public Modelanalysis getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(Modelanalysis idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    @XmlTransient
    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public Method getIdmother() {
        return idmother;
    }

    public void setIdmother(Method idmother) {
        this.idmother = idmother;
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
        hash += (idmethod != null ? idmethod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Method)) {
            return false;
        }
        Method other = (Method) object;
        if ((this.idmethod == null && other.idmethod != null) || (this.idmethod != null && !this.idmethod.equals(other.idmethod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Method[ idmethod=" + idmethod + " ]";
    }
    
}
