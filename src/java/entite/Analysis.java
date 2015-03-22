/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Analysis.findAll", query = "SELECT a FROM Analysis a"),
    @NamedQuery(name = "Analysis.findByIdanalysis", query = "SELECT a FROM Analysis a WHERE a.idanalysis = :idanalysis"),
    @NamedQuery(name = "Analysis.findByIdmethoddetails", query = "SELECT a FROM Analysis a WHERE a.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Analysis.findByBatchname", query = "SELECT a FROM Analysis a WHERE a.batchname = :batchname"),
    @NamedQuery(name = "Analysis.findByIdstatus", query = "SELECT a FROM Analysis a WHERE a.idstatus = :idstatus"),
    @NamedQuery(name = "Analysis.findByDescription", query = "SELECT a FROM Analysis a WHERE a.description = :description"),
    @NamedQuery(name = "Analysis.findByIsvirtual", query = "SELECT a FROM Analysis a WHERE a.isvirtual = :isvirtual"),
    @NamedQuery(name = "Analysis.findByIsfinal", query = "SELECT a FROM Analysis a WHERE a.isfinal = :isfinal"),
    @NamedQuery(name = "Analysis.findByOccurence", query = "SELECT a FROM Analysis a WHERE a.occurence = :occurence"),
    @NamedQuery(name = "Analysis.findByOfficialename", query = "SELECT a FROM Analysis a WHERE a.officialename = :officialename"),
    @NamedQuery(name = "Analysis.findByCounteranalysis", query = "SELECT a FROM Analysis a WHERE a.counteranalysis = :counteranalysis"),
    @NamedQuery(name = "Analysis.findByStatus", query = "SELECT a FROM Analysis a WHERE a.status = :status"),
    @NamedQuery(name = "Analysis.findByApporved", query = "SELECT a FROM Analysis a WHERE a.apporved = :apporved"),
    @NamedQuery(name = "Analysis.findByApporvedby", query = "SELECT a FROM Analysis a WHERE a.apporvedby = :apporvedby"),
    @NamedQuery(name = "Analysis.findByApporveddate", query = "SELECT a FROM Analysis a WHERE a.apporveddate = :apporveddate"),
    @NamedQuery(name = "Analysis.findByHerited", query = "SELECT a FROM Analysis a WHERE a.herited = :herited"),
    @NamedQuery(name = "Analysis.findByConsidered", query = "SELECT a FROM Analysis a WHERE a.considered = :considered")})
public class Analysis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idanalysis;
    private BigInteger idmethoddetails;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    private Boolean idstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Boolean isvirtual;
    private Boolean isfinal;
    private Short occurence;
    @Size(max = 50)
    @Column(length = 50)
    private String officialename;
    private Short counteranalysis;
    private Short status;
    private Short apporved;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    private Boolean herited;
    private Boolean considered;
    @OneToMany(mappedBy = "idanalysis")
    private List<Results> resultsList;
    @JoinColumn(name = "IDMETHOD", referencedColumnName = "IDMETHOD")
    @ManyToOne
    private Method idmethod;
    @OneToMany(mappedBy = "idmotheranalysis")
    private List<Analysis> analysisList;
    @JoinColumn(name = "IDMOTHERANALYSIS", referencedColumnName = "IDANALYSIS")
    @ManyToOne
    private Analysis idmotheranalysis;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS")
    @ManyToOne
    private Modelanalysis idmodelanalysis;
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    @JoinColumn(name = "IDSAMPLES", referencedColumnName = "IDSAMPLES")
    @ManyToOne
    private Samples idsamples;
    @JoinColumn(name = "IDSPECIFICATION", referencedColumnName = "IDSPECIFICATION")
    @ManyToOne
    private Specification idspecification;

    public Analysis() {
    }

    public Analysis(Long idanalysis) {
        this.idanalysis = idanalysis;
    }

    public Long getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(Long idanalysis) {
        this.idanalysis = idanalysis;
    }

    public BigInteger getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(BigInteger idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public Boolean getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Boolean idstatus) {
        this.idstatus = idstatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Boolean isvirtual) {
        this.isvirtual = isvirtual;
    }

    public Boolean getIsfinal() {
        return isfinal;
    }

    public void setIsfinal(Boolean isfinal) {
        this.isfinal = isfinal;
    }

    public Short getOccurence() {
        return occurence;
    }

    public void setOccurence(Short occurence) {
        this.occurence = occurence;
    }

    public String getOfficialename() {
        return officialename;
    }

    public void setOfficialename(String officialename) {
        this.officialename = officialename;
    }

    public Short getCounteranalysis() {
        return counteranalysis;
    }

    public void setCounteranalysis(Short counteranalysis) {
        this.counteranalysis = counteranalysis;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getApporved() {
        return apporved;
    }

    public void setApporved(Short apporved) {
        this.apporved = apporved;
    }

    public String getApporvedby() {
        return apporvedby;
    }

    public void setApporvedby(String apporvedby) {
        this.apporvedby = apporvedby;
    }

    public Date getApporveddate() {
        return apporveddate;
    }

    public void setApporveddate(Date apporveddate) {
        this.apporveddate = apporveddate;
    }

    public Boolean getHerited() {
        return herited;
    }

    public void setHerited(Boolean herited) {
        this.herited = herited;
    }

    public Boolean getConsidered() {
        return considered;
    }

    public void setConsidered(Boolean considered) {
        this.considered = considered;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    public Method getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(Method idmethod) {
        this.idmethod = idmethod;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public Analysis getIdmotheranalysis() {
        return idmotheranalysis;
    }

    public void setIdmotheranalysis(Analysis idmotheranalysis) {
        this.idmotheranalysis = idmotheranalysis;
    }

    public Modelanalysis getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(Modelanalysis idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public Batch getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(Batch idbatch) {
        this.idbatch = idbatch;
    }

    public Samples getIdsamples() {
        return idsamples;
    }

    public void setIdsamples(Samples idsamples) {
        this.idsamples = idsamples;
    }

    public Specification getIdspecification() {
        return idspecification;
    }

    public void setIdspecification(Specification idspecification) {
        this.idspecification = idspecification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanalysis != null ? idanalysis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analysis)) {
            return false;
        }
        Analysis other = (Analysis) object;
        if ((this.idanalysis == null && other.idanalysis != null) || (this.idanalysis != null && !this.idanalysis.equals(other.idanalysis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Analysis[ idanalysis=" + idanalysis + " ]";
    }
    
}
