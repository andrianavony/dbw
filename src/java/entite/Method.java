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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@Table(name = "method")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Method.findAll", query = "SELECT m FROM Method m"),
    @NamedQuery(name = "Method.findByIdmethod", query = "SELECT m FROM Method m WHERE m.idmethod = :idmethod"),
    @NamedQuery(name = "Method.findByLimsmethodid", query = "SELECT m FROM Method m WHERE m.limsmethodid = :limsmethodid"),
    @NamedQuery(name = "Method.findByLimsanalysisid", query = "SELECT m FROM Method m WHERE m.limsanalysisid = :limsanalysisid"),
    @NamedQuery(name = "Method.findByIddepartement", query = "SELECT m FROM Method m WHERE m.iddepartement = :iddepartement"),
    @NamedQuery(name = "Method.findByIdservice", query = "SELECT m FROM Method m WHERE m.idservice = :idservice"),
    @NamedQuery(name = "Method.findByMethodname", query = "SELECT m FROM Method m WHERE m.methodname = :methodname"),
    @NamedQuery(name = "Method.findByDuration", query = "SELECT m FROM Method m WHERE m.duration = :duration"),
    @NamedQuery(name = "Method.findByDescription", query = "SELECT m FROM Method m WHERE m.description = :description"),
    @NamedQuery(name = "Method.findByOfficialname", query = "SELECT m FROM Method m WHERE m.officialname = :officialname"),
    @NamedQuery(name = "Method.findByIsvirtual", query = "SELECT m FROM Method m WHERE m.isvirtual = :isvirtual"),
    @NamedQuery(name = "Method.findByIsdefault", query = "SELECT m FROM Method m WHERE m.isdefault = :isdefault"),
    @NamedQuery(name = "Method.findByOfficialanalysis", query = "SELECT m FROM Method m WHERE m.officialanalysis = :officialanalysis"),
    @NamedQuery(name = "Method.findByInternalanalysis", query = "SELECT m FROM Method m WHERE m.internalanalysis = :internalanalysis")})
public class Method implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger idmethod;
    private BigInteger limsmethodid;
    private BigInteger limsanalysisid;
    @Size(max = 50)
    @Column(length = 50)
    private String iddepartement;
    @Size(max = 50)
    @Column(length = 50)
    private String idservice;
    @Size(max = 50)
    @Column(length = 50)
    private String methodname;
    @Size(max = 50)
    @Column(length = 50)
    private String duration;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    private Boolean isvirtual;
    private Boolean isdefault;
    private Boolean officialanalysis;
    private Boolean internalanalysis;
    @OneToMany(mappedBy = "idmethod")
    private List<Analysis> analysisList;

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

    public Method() {
    }

    public Method(BigInteger idmethod) {
        this.idmethod = idmethod;
    }

    public BigInteger getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(BigInteger idmethod) {
        this.idmethod = idmethod;
    }
    
        public BigInteger getLimsmethodid() {
        return limsmethodid;
    }

    public void setLimsmethodid(BigInteger limsmethodid) {
        this.limsmethodid = limsmethodid;
    }

    public BigInteger getLimsanalysisid() {
        return limsanalysisid;
    }

    public void setLimsanalysisid(BigInteger limsanalysisid) {
        this.limsanalysisid = limsanalysisid;
    }

    public String getIddepartement() {
        return iddepartement;
    }

    public void setIddepartement(String iddepartement) {
        this.iddepartement = iddepartement;
    }

    public String getIdservice() {
        return idservice;
    }

    public void setIdservice(String idservice) {
        this.idservice = idservice;
    }


    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }
        public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
    
    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
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
