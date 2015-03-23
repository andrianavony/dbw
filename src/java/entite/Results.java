/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r"),
    @NamedQuery(name = "Results.findByIdresult", query = "SELECT r FROM Results r WHERE r.idresult = :idresult"),
    @NamedQuery(name = "Results.findByIdmethoddetails", query = "SELECT r FROM Results r WHERE r.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Results.findByBatchname", query = "SELECT r FROM Results r WHERE r.batchname = :batchname"),
    @NamedQuery(name = "Results.findByIdstatus", query = "SELECT r FROM Results r WHERE r.idstatus = :idstatus"),
    @NamedQuery(name = "Results.findByDescription", query = "SELECT r FROM Results r WHERE r.description = :description"),
    @NamedQuery(name = "Results.findByIsvirtual", query = "SELECT r FROM Results r WHERE r.isvirtual = :isvirtual"),
    @NamedQuery(name = "Results.findByIsfinal", query = "SELECT r FROM Results r WHERE r.isfinal = :isfinal"),
    @NamedQuery(name = "Results.findByIsresults", query = "SELECT r FROM Results r WHERE r.isresults = :isresults"),
    @NamedQuery(name = "Results.findByIsrequired", query = "SELECT r FROM Results r WHERE r.isrequired = :isrequired"),
    @NamedQuery(name = "Results.findByOccurence", query = "SELECT r FROM Results r WHERE r.occurence = :occurence"),
    @NamedQuery(name = "Results.findByCounteranalysis", query = "SELECT r FROM Results r WHERE r.counteranalysis = :counteranalysis"),
    @NamedQuery(name = "Results.findByOfficialename", query = "SELECT r FROM Results r WHERE r.officialename = :officialename"),
    @NamedQuery(name = "Results.findByMaingroup", query = "SELECT r FROM Results r WHERE r.maingroup = :maingroup"),
    @NamedQuery(name = "Results.findBySubgroup", query = "SELECT r FROM Results r WHERE r.subgroup = :subgroup"),
    @NamedQuery(name = "Results.findByMeasuremaster", query = "SELECT r FROM Results r WHERE r.measuremaster = :measuremaster"),
    @NamedQuery(name = "Results.findByMeasuredetails", query = "SELECT r FROM Results r WHERE r.measuredetails = :measuredetails"),
    @NamedQuery(name = "Results.findByRepetition", query = "SELECT r FROM Results r WHERE r.repetition = :repetition"),
    @NamedQuery(name = "Results.findBySubrepetition", query = "SELECT r FROM Results r WHERE r.subrepetition = :subrepetition"),
    @NamedQuery(name = "Results.findByRawresults", query = "SELECT r FROM Results r WHERE r.rawresults = :rawresults"),
    @NamedQuery(name = "Results.findByFormated", query = "SELECT r FROM Results r WHERE r.formated = :formated"),
    @NamedQuery(name = "Results.findByApporved", query = "SELECT r FROM Results r WHERE r.apporved = :apporved"),
    @NamedQuery(name = "Results.findByApporveddate", query = "SELECT r FROM Results r WHERE r.apporveddate = :apporveddate"),
    @NamedQuery(name = "Results.findByApporvedby", query = "SELECT r FROM Results r WHERE r.apporvedby = :apporvedby"),
    @NamedQuery(name = "Results_1.findByDateofentry", query = "SELECT r FROM Results_1 r WHERE r.dateofentry = :dateofentry"),
    @NamedQuery(name = "Results_1.findByHerited", query = "SELECT r FROM Results_1 r WHERE r.herited = :herited"),
    @NamedQuery(name = "Results_1.findByMeasurename", query = "SELECT r FROM Results_1 r WHERE r.measurename = :measurename"),
    @NamedQuery(name = "Results_1.findByAnalysisname", query = "SELECT r FROM Results_1 r WHERE r.analysisname = :analysisname"),
    @NamedQuery(name = "Results_1.findByMethodname", query = "SELECT r FROM Results_1 r WHERE r.methodname = :methodname")})
public class Results implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idresult;
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
    private Boolean isresults;
    private Boolean isrequired;
    private Short occurence;
    private Short counteranalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String officialename;
    @Size(max = 50)
    @Column(length = 50)
    private String maingroup;
    @Size(max = 50)
    @Column(length = 50)
    private String subgroup;
    @Size(max = 50)
    @Column(length = 50)
    private String measuremaster;
    @Size(max = 50)
    @Column(length = 50)
    private String measuredetails;
    private Short repetition;
    private Short subrepetition;
    @Size(max = 50)
    @Column(length = 50)
    private String rawresults;
    @Size(max = 50)
    @Column(length = 50)
    private String formated;
    private Boolean apporved;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofentry;
    private Boolean herited;
    @Size(max = 50)
    @Column(length = 50)
    private String measurename;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisname;
    @Size(max = 50)
    @Column(length = 50)
    private String methodname;
    @JoinColumn(name = "IDSAMPLES", referencedColumnName = "IDSAMPLES")
    @ManyToOne
    private Samples idsamples;
    @JoinColumn(name = "IDMEASURE", referencedColumnName = "IDMEASURE")
    @ManyToOne
    private Measures idmeasure;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private User iduser;
    @JoinColumn(name = "IDANALYSIS", referencedColumnName = "IDANALYSIS")
    @ManyToOne
    private Analysis idanalysis;
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    @JoinColumn(name = "IDMETHOD", referencedColumnName = "IDMETHOD")
    @ManyToOne
    private Method idmethod;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS")
    @ManyToOne
    private Modelanalysis idmodelanalysis;
    @JoinColumn(name = "IDSPECIFICATION", referencedColumnName = "IDSPECIFICATION")
    @ManyToOne
    private Specification idspecification;

    public Results() {
    }

    public Results(Long idresult) {
        this.idresult = idresult;
    }

    public Long getIdresult() {
        return idresult;
    }

    public void setIdresult(Long idresult) {
        this.idresult = idresult;
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

    public Boolean getIsresults() {
        return isresults;
    }

    public void setIsresults(Boolean isresults) {
        this.isresults = isresults;
    }

    public Boolean getIsrequired() {
        return isrequired;
    }

    public void setIsrequired(Boolean isrequired) {
        this.isrequired = isrequired;
    }

    public Short getOccurence() {
        return occurence;
    }

    public void setOccurence(Short occurence) {
        this.occurence = occurence;
    }

    public Short getCounteranalysis() {
        return counteranalysis;
    }

    public void setCounteranalysis(Short counteranalysis) {
        this.counteranalysis = counteranalysis;
    }

    public String getOfficialename() {
        return officialename;
    }

    public void setOfficialename(String officialename) {
        this.officialename = officialename;
    }

    public String getMaingroup() {
        return maingroup;
    }

    public void setMaingroup(String maingroup) {
        this.maingroup = maingroup;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getMeasuremaster() {
        return measuremaster;
    }

    public void setMeasuremaster(String measuremaster) {
        this.measuremaster = measuremaster;
    }

    public String getMeasuredetails() {
        return measuredetails;
    }

    public void setMeasuredetails(String measuredetails) {
        this.measuredetails = measuredetails;
    }

    public Short getRepetition() {
        return repetition;
    }

    public void setRepetition(Short repetition) {
        this.repetition = repetition;
    }

    public Short getSubrepetition() {
        return subrepetition;
    }

    public void setSubrepetition(Short subrepetition) {
        this.subrepetition = subrepetition;
    }

    public String getRawresults() {
        return rawresults;
    }

    public void setRawresults(String rawresults) {
        this.rawresults = rawresults;
    }

    public String getFormated() {
        return formated;
    }

    public void setFormated(String formated) {
        this.formated = formated;
    }

    public Boolean getApporved() {
        return apporved;
    }

    public void setApporved(Boolean apporved) {
        this.apporved = apporved;
    }

    public Date getApporveddate() {
        return apporveddate;
    }

    public void setApporveddate(Date apporveddate) {
        this.apporveddate = apporveddate;
    }

    public String getApporvedby() {
        return apporvedby;
    }

    public void setApporvedby(String apporvedby) {
        this.apporvedby = apporvedby;
    }

    public Date getDateofentry() {
        return dateofentry;
    }

    public void setDateofentry(Date dateofentry) {
        this.dateofentry = dateofentry;
    }

    public Boolean getHerited() {
        return herited;
    }

    public void setHerited(Boolean herited) {
        this.herited = herited;
    }

    public String getMeasurename() {
        return measurename;
    }

    public void setMeasurename(String measurename) {
        this.measurename = measurename;
    }

    public String getAnalysisname() {
        return analysisname;
    }

    public void setAnalysisname(String analysisname) {
        this.analysisname = analysisname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public Samples getIdsamples() {
        return idsamples;
    }

    public void setIdsamples(Samples idsamples) {
        this.idsamples = idsamples;
    }

    public Measures getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(Measures idmeasure) {
        this.idmeasure = idmeasure;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Analysis getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(Analysis idanalysis) {
        this.idanalysis = idanalysis;
    }

    public Batch getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(Batch idbatch) {
        this.idbatch = idbatch;
    }

    public Method getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(Method idmethod) {
        this.idmethod = idmethod;
    }

    public Modelanalysis getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(Modelanalysis idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
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
        hash += (idresult != null ? idresult.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.idresult == null && other.idresult != null) || (this.idresult != null && !this.idresult.equals(other.idresult))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Results[ idresult=" + idresult + " ]";
    }
    
}
