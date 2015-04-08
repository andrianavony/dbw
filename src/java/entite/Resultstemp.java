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
    @NamedQuery(name = "Resultstemp.findAll", query = "SELECT r FROM Resultstemp r"),
    @NamedQuery(name = "Resultstemp.findByIdresult", query = "SELECT r FROM Resultstemp r WHERE r.idresult = :idresult"),
    @NamedQuery(name = "Resultstemp.findByIdmeasure", query = "SELECT r FROM Resultstemp r WHERE r.idmeasure = :idmeasure"),
    @NamedQuery(name = "Resultstemp.findByLimsmeasureid", query = "SELECT r FROM Resultstemp r WHERE r.limsmeasureid = :limsmeasureid"),
    @NamedQuery(name = "Resultstemp.findByLimsid", query = "SELECT r FROM Resultstemp r WHERE r.limsid = :limsid"),
    @NamedQuery(name = "Resultstemp.findByLimsidseries", query = "SELECT r FROM Resultstemp r WHERE r.limsidseries = :limsidseries"),
    @NamedQuery(name = "Resultstemp.findByIdseries", query = "SELECT r FROM Resultstemp r WHERE r.idseries = :idseries"),
    @NamedQuery(name = "Resultstemp.findByLimssampleid", query = "SELECT r FROM Resultstemp r WHERE r.limssampleid = :limssampleid"),
    @NamedQuery(name = "Resultstemp.findByIdanalysis", query = "SELECT r FROM Resultstemp r WHERE r.idanalysis = :idanalysis"),
    @NamedQuery(name = "Resultstemp.findByIdmodelanalysis", query = "SELECT r FROM Resultstemp r WHERE r.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Resultstemp.findByLimsidanalysis", query = "SELECT r FROM Resultstemp r WHERE r.limsidanalysis = :limsidanalysis"),
    @NamedQuery(name = "Resultstemp.findByLimsidmethod", query = "SELECT r FROM Resultstemp r WHERE r.limsidmethod = :limsidmethod"),
    @NamedQuery(name = "Resultstemp.findByIdmethod", query = "SELECT r FROM Resultstemp r WHERE r.idmethod = :idmethod"),
    @NamedQuery(name = "Resultstemp.findByIdmethoddetails", query = "SELECT r FROM Resultstemp r WHERE r.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Resultstemp.findByIdspecification", query = "SELECT r FROM Resultstemp r WHERE r.idspecification = :idspecification"),
    @NamedQuery(name = "Resultstemp.findByIdsamples", query = "SELECT r FROM Resultstemp r WHERE r.idsamples = :idsamples"),
    @NamedQuery(name = "Resultstemp.findByIdcasefile", query = "SELECT r FROM Resultstemp r WHERE r.idcasefile = :idcasefile"),
    @NamedQuery(name = "Resultstemp.findByIdbatch", query = "SELECT r FROM Resultstemp r WHERE r.idbatch = :idbatch"),
    @NamedQuery(name = "Resultstemp.findByLimsbatchid", query = "SELECT r FROM Resultstemp r WHERE r.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Resultstemp.findByLimsfolderno", query = "SELECT r FROM Resultstemp r WHERE r.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Resultstemp.findByBatchname", query = "SELECT r FROM Resultstemp r WHERE r.batchname = :batchname"),
    @NamedQuery(name = "Resultstemp.findByIdstatus", query = "SELECT r FROM Resultstemp r WHERE r.idstatus = :idstatus"),
    @NamedQuery(name = "Resultstemp.findByStatuslabel", query = "SELECT r FROM Resultstemp r WHERE r.statuslabel = :statuslabel"),
    @NamedQuery(name = "Resultstemp.findByIdapprobationstatus", query = "SELECT r FROM Resultstemp r WHERE r.idapprobationstatus = :idapprobationstatus"),
    @NamedQuery(name = "Resultstemp.findByApprobationstatuslabel", query = "SELECT r FROM Resultstemp r WHERE r.approbationstatuslabel = :approbationstatuslabel"),
    @NamedQuery(name = "Resultstemp.findByAnalysisidstatus", query = "SELECT r FROM Resultstemp r WHERE r.analysisidstatus = :analysisidstatus"),
    @NamedQuery(name = "Resultstemp.findByAnalysisstatuslabel", query = "SELECT r FROM Resultstemp r WHERE r.analysisstatuslabel = :analysisstatuslabel"),
    @NamedQuery(name = "Resultstemp.findByAnalysisidapprobationstatus", query = "SELECT r FROM Resultstemp r WHERE r.analysisidapprobationstatus = :analysisidapprobationstatus"),
    @NamedQuery(name = "Resultstemp.findByAnalysisapprobationstatuslabel", query = "SELECT r FROM Resultstemp r WHERE r.analysisapprobationstatuslabel = :analysisapprobationstatuslabel"),
    @NamedQuery(name = "Resultstemp.findByDescription", query = "SELECT r FROM Resultstemp r WHERE r.description = :description"),
    @NamedQuery(name = "Resultstemp.findByIsvirtual", query = "SELECT r FROM Resultstemp r WHERE r.isvirtual = :isvirtual"),
    @NamedQuery(name = "Resultstemp.findByIsfinal", query = "SELECT r FROM Resultstemp r WHERE r.isfinal = :isfinal"),
    @NamedQuery(name = "Resultstemp.findByIsresults", query = "SELECT r FROM Resultstemp r WHERE r.isresults = :isresults"),
    @NamedQuery(name = "Resultstemp.findByIsrequired", query = "SELECT r FROM Resultstemp r WHERE r.isrequired = :isrequired"),
    @NamedQuery(name = "Resultstemp.findByOccurence", query = "SELECT r FROM Resultstemp r WHERE r.occurence = :occurence"),
    @NamedQuery(name = "Resultstemp.findByCounteranalysis", query = "SELECT r FROM Resultstemp r WHERE r.counteranalysis = :counteranalysis"),
    @NamedQuery(name = "Resultstemp.findByCounteranalysisidlims", query = "SELECT r FROM Resultstemp r WHERE r.counteranalysisidlims = :counteranalysisidlims"),
    @NamedQuery(name = "Resultstemp.findByOfficialename", query = "SELECT r FROM Resultstemp r WHERE r.officialename = :officialename"),
    @NamedQuery(name = "Resultstemp.findByMaingroup", query = "SELECT r FROM Resultstemp r WHERE r.maingroup = :maingroup"),
    @NamedQuery(name = "Resultstemp.findBySubgroup", query = "SELECT r FROM Resultstemp r WHERE r.subgroup = :subgroup"),
    @NamedQuery(name = "Resultstemp.findByMeasuremaster", query = "SELECT r FROM Resultstemp r WHERE r.measuremaster = :measuremaster"),
    @NamedQuery(name = "Resultstemp.findByMeasuredetails", query = "SELECT r FROM Resultstemp r WHERE r.measuredetails = :measuredetails"),
    @NamedQuery(name = "Resultstemp.findByRepetition", query = "SELECT r FROM Resultstemp r WHERE r.repetition = :repetition"),
    @NamedQuery(name = "Resultstemp.findBySubrepetition", query = "SELECT r FROM Resultstemp r WHERE r.subrepetition = :subrepetition"),
    @NamedQuery(name = "Resultstemp.findByRawresults", query = "SELECT r FROM Resultstemp r WHERE r.rawresults = :rawresults"),
    @NamedQuery(name = "Resultstemp.findByFormated", query = "SELECT r FROM Resultstemp r WHERE r.formated = :formated"),
    @NamedQuery(name = "Resultstemp.findByApporved", query = "SELECT r FROM Resultstemp r WHERE r.apporved = :apporved"),
    @NamedQuery(name = "Resultstemp.findByApporveddate", query = "SELECT r FROM Resultstemp r WHERE r.apporveddate = :apporveddate"),
    @NamedQuery(name = "Resultstemp.findByApporvedby", query = "SELECT r FROM Resultstemp r WHERE r.apporvedby = :apporvedby"),
    @NamedQuery(name = "Resultstemp.findByDateofentry", query = "SELECT r FROM Resultstemp r WHERE r.dateofentry = :dateofentry"),
    @NamedQuery(name = "Resultstemp.findByIduser", query = "SELECT r FROM Resultstemp r WHERE r.iduser = :iduser"),
    @NamedQuery(name = "Resultstemp.findByUsername", query = "SELECT r FROM Resultstemp r WHERE r.username = :username"),
    @NamedQuery(name = "Resultstemp.findByHerited", query = "SELECT r FROM Resultstemp r WHERE r.herited = :herited"),
    @NamedQuery(name = "Resultstemp.findByMeasurename", query = "SELECT r FROM Resultstemp r WHERE r.measurename = :measurename"),
    @NamedQuery(name = "Resultstemp.findByAnalysisname", query = "SELECT r FROM Resultstemp r WHERE r.analysisname = :analysisname"),
    @NamedQuery(name = "Resultstemp.findByMethodname", query = "SELECT r FROM Resultstemp r WHERE r.methodname = :methodname"),
    @NamedQuery(name = "Resultstemp.findByCopiedfrom", query = "SELECT r FROM Resultstemp r WHERE r.copiedfrom = :copiedfrom"),
    @NamedQuery(name = "Resultstemp.findByIsresultsinserted", query = "SELECT r FROM Resultstemp r WHERE r.isresultsinserted = :isresultsinserted"),
    @NamedQuery(name = "Resultstemp.findByLimsanalysisorigrec", query = "SELECT r FROM Resultstemp r WHERE r.limsanalysisorigrec = :limsanalysisorigrec")})
public class Resultstemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idresult;
    private BigInteger idmeasure;
    private BigInteger limsmeasureid;
    private BigInteger limsid;
    private BigInteger limsidseries;
    private BigInteger idseries;
    @Size(max = 50)
    @Column(length = 50)
    private String limssampleid;
    private BigInteger idanalysis;
    private BigInteger idmodelanalysis;
    private BigInteger limsidanalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String limsidmethod;
    private BigInteger idmethod;
    private BigInteger idmethoddetails;
    private BigInteger idspecification;
    private BigInteger idsamples;
    private BigInteger idcasefile;
    private BigInteger idbatch;
    private BigInteger limsbatchid;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    private Boolean idstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String statuslabel;
    private Boolean idapprobationstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String approbationstatuslabel;
    private Boolean analysisidstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisstatuslabel;
    private Boolean analysisidapprobationstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisapprobationstatuslabel;
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
    private String counteranalysisidlims;
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
    private BigInteger iduser;
    @Size(max = 50)
    @Column(length = 50)
    private String username;
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
    @Size(max = 50)
    @Column(length = 50)
    private String copiedfrom;
    private Boolean isresultsinserted;
    private BigInteger limsanalysisorigrec;

    public Resultstemp() {
    }

    public Resultstemp(Long idresult) {
        this.idresult = idresult;
    }

    public Long getIdresult() {
        return idresult;
    }

    public void setIdresult(Long idresult) {
        this.idresult = idresult;
    }

    public BigInteger getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(BigInteger idmeasure) {
        this.idmeasure = idmeasure;
    }

    public BigInteger getLimsmeasureid() {
        return limsmeasureid;
    }

    public void setLimsmeasureid(BigInteger limsmeasureid) {
        this.limsmeasureid = limsmeasureid;
    }

    public BigInteger getLimsid() {
        return limsid;
    }

    public void setLimsid(BigInteger limsid) {
        this.limsid = limsid;
    }

    public BigInteger getLimsidseries() {
        return limsidseries;
    }

    public void setLimsidseries(BigInteger limsidseries) {
        this.limsidseries = limsidseries;
    }

    public BigInteger getIdseries() {
        return idseries;
    }

    public void setIdseries(BigInteger idseries) {
        this.idseries = idseries;
    }

    public String getLimssampleid() {
        return limssampleid;
    }

    public void setLimssampleid(String limssampleid) {
        this.limssampleid = limssampleid;
    }

    public BigInteger getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(BigInteger idanalysis) {
        this.idanalysis = idanalysis;
    }

    public BigInteger getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(BigInteger idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public BigInteger getLimsidanalysis() {
        return limsidanalysis;
    }

    public void setLimsidanalysis(BigInteger limsidanalysis) {
        this.limsidanalysis = limsidanalysis;
    }

    public String getLimsidmethod() {
        return limsidmethod;
    }

    public void setLimsidmethod(String limsidmethod) {
        this.limsidmethod = limsidmethod;
    }

    public BigInteger getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(BigInteger idmethod) {
        this.idmethod = idmethod;
    }

    public BigInteger getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(BigInteger idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
    }

    public BigInteger getIdspecification() {
        return idspecification;
    }

    public void setIdspecification(BigInteger idspecification) {
        this.idspecification = idspecification;
    }

    public BigInteger getIdsamples() {
        return idsamples;
    }

    public void setIdsamples(BigInteger idsamples) {
        this.idsamples = idsamples;
    }

    public BigInteger getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(BigInteger idcasefile) {
        this.idcasefile = idcasefile;
    }

    public BigInteger getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(BigInteger idbatch) {
        this.idbatch = idbatch;
    }

    public BigInteger getLimsbatchid() {
        return limsbatchid;
    }

    public void setLimsbatchid(BigInteger limsbatchid) {
        this.limsbatchid = limsbatchid;
    }

    public String getLimsfolderno() {
        return limsfolderno;
    }

    public void setLimsfolderno(String limsfolderno) {
        this.limsfolderno = limsfolderno;
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

    public String getStatuslabel() {
        return statuslabel;
    }

    public void setStatuslabel(String statuslabel) {
        this.statuslabel = statuslabel;
    }

    public Boolean getIdapprobationstatus() {
        return idapprobationstatus;
    }

    public void setIdapprobationstatus(Boolean idapprobationstatus) {
        this.idapprobationstatus = idapprobationstatus;
    }

    public String getApprobationstatuslabel() {
        return approbationstatuslabel;
    }

    public void setApprobationstatuslabel(String approbationstatuslabel) {
        this.approbationstatuslabel = approbationstatuslabel;
    }

    public Boolean getAnalysisidstatus() {
        return analysisidstatus;
    }

    public void setAnalysisidstatus(Boolean analysisidstatus) {
        this.analysisidstatus = analysisidstatus;
    }

    public String getAnalysisstatuslabel() {
        return analysisstatuslabel;
    }

    public void setAnalysisstatuslabel(String analysisstatuslabel) {
        this.analysisstatuslabel = analysisstatuslabel;
    }

    public Boolean getAnalysisidapprobationstatus() {
        return analysisidapprobationstatus;
    }

    public void setAnalysisidapprobationstatus(Boolean analysisidapprobationstatus) {
        this.analysisidapprobationstatus = analysisidapprobationstatus;
    }

    public String getAnalysisapprobationstatuslabel() {
        return analysisapprobationstatuslabel;
    }

    public void setAnalysisapprobationstatuslabel(String analysisapprobationstatuslabel) {
        this.analysisapprobationstatuslabel = analysisapprobationstatuslabel;
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

    public String getCounteranalysisidlims() {
        return counteranalysisidlims;
    }

    public void setCounteranalysisidlims(String counteranalysisidlims) {
        this.counteranalysisidlims = counteranalysisidlims;
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

    public BigInteger getIduser() {
        return iduser;
    }

    public void setIduser(BigInteger iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCopiedfrom() {
        return copiedfrom;
    }

    public void setCopiedfrom(String copiedfrom) {
        this.copiedfrom = copiedfrom;
    }

    public Boolean getIsresultsinserted() {
        return isresultsinserted;
    }

    public void setIsresultsinserted(Boolean isresultsinserted) {
        this.isresultsinserted = isresultsinserted;
    }

    public BigInteger getLimsanalysisorigrec() {
        return limsanalysisorigrec;
    }

    public void setLimsanalysisorigrec(BigInteger limsanalysisorigrec) {
        this.limsanalysisorigrec = limsanalysisorigrec;
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
        if (!(object instanceof Resultstemp)) {
            return false;
        }
        Resultstemp other = (Resultstemp) object;
        if ((this.idresult == null && other.idresult != null) || (this.idresult != null && !this.idresult.equals(other.idresult))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Resultstemp[ idresult=" + idresult + " ]";
    }
    
}
