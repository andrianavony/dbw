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
import javax.persistence.EntityListeners;
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
import session.ejb.RecopieAnalysis;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@EntityListeners({RecopieAnalysis.class})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analysis.findAll", query = "SELECT a FROM Analysis a"),
    @NamedQuery(name = "Analysis.findByIdanalysis", query = "SELECT a FROM Analysis a WHERE a.idanalysis = :idanalysis"),
    @NamedQuery(name = "Analysis.findByLimsid", query = "SELECT a FROM Analysis a WHERE a.limsid = :limsid"),
    @NamedQuery(name = "Analysis.findByLimssampleid", query = "SELECT a FROM Analysis a WHERE a.limssampleid = :limssampleid"),
    @NamedQuery(name = "Analysis.findByLimsidanalysis", query = "SELECT a FROM Analysis a WHERE a.limsidanalysis = :limsidanalysis"),
    @NamedQuery(name = "Analysis.findByIdcasefile", query = "SELECT a FROM Analysis a WHERE a.idcasefile = :idcasefile"),
    @NamedQuery(name = "Analysis.findByLimsidseries", query = "SELECT a FROM Analysis a WHERE a.limsidseries = :limsidseries"),
    @NamedQuery(name = "Analysis.findByIdseries", query = "SELECT a FROM Analysis a WHERE a.idseries = :idseries"),
    @NamedQuery(name = "Analysis.findByIdmethoddetails", query = "SELECT a FROM Analysis a WHERE a.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Analysis.findByLimsbatchid", query = "SELECT a FROM Analysis a WHERE a.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Analysis.findByLimsfolderno", query = "SELECT a FROM Analysis a WHERE a.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Analysis.findByBatchname", query = "SELECT a FROM Analysis a WHERE a.batchname = :batchname"),
    @NamedQuery(name = "Analysis.findByIdstatus", query = "SELECT a FROM Analysis a WHERE a.idstatus = :idstatus"),
    @NamedQuery(name = "Analysis.findByStatuslabel", query = "SELECT a FROM Analysis a WHERE a.statuslabel = :statuslabel"),
    @NamedQuery(name = "Analysis.findByIdapprobationstatus", query = "SELECT a FROM Analysis a WHERE a.idapprobationstatus = :idapprobationstatus"),
    @NamedQuery(name = "Analysis.findByApprobationstatuslabel", query = "SELECT a FROM Analysis a WHERE a.approbationstatuslabel = :approbationstatuslabel"),
    @NamedQuery(name = "Analysis.findByDescription", query = "SELECT a FROM Analysis a WHERE a.description = :description"),
    @NamedQuery(name = "Analysis.findByIsvirtual", query = "SELECT a FROM Analysis a WHERE a.isvirtual = :isvirtual"),
    @NamedQuery(name = "Analysis.findByIsfinal", query = "SELECT a FROM Analysis a WHERE a.isfinal = :isfinal"),
    @NamedQuery(name = "Analysis.findByOccurence", query = "SELECT a FROM Analysis a WHERE a.occurence = :occurence"),
    @NamedQuery(name = "Analysis.findByOfficialename", query = "SELECT a FROM Analysis a WHERE a.officialename = :officialename"),
    @NamedQuery(name = "Analysis.findByLimscounteranalysissampelid", query = "SELECT a FROM Analysis a WHERE a.limscounteranalysissampelid = :limscounteranalysissampelid"),
    @NamedQuery(name = "Analysis.findByCounteranalysis", query = "SELECT a FROM Analysis a WHERE a.counteranalysis = :counteranalysis"),
    @NamedQuery(name = "Analysis.findByApporved", query = "SELECT a FROM Analysis a WHERE a.apporved = :apporved"),
    @NamedQuery(name = "Analysis.findByApporvedby", query = "SELECT a FROM Analysis a WHERE a.apporvedby = :apporvedby"),
    @NamedQuery(name = "Analysis.findByApporveddate", query = "SELECT a FROM Analysis a WHERE a.apporveddate = :apporveddate"),
    @NamedQuery(name = "Analysis.findByHerited", query = "SELECT a FROM Analysis a WHERE a.herited = :herited"),
    @NamedQuery(name = "Analysis.findByConsidered", query = "SELECT a FROM Analysis a WHERE a.considered = :considered"),
    @NamedQuery(name = "Analysis.findByAnalysisname", query = "SELECT a FROM Analysis a WHERE a.analysisname = :analysisname"),
    @NamedQuery(name = "Analysis.findByMethodname", query = "SELECT a FROM Analysis a WHERE a.methodname = :methodname"),
    @NamedQuery(name = "Analysis.findByIdsample", query = "SELECT a FROM Analysis a WHERE a.idsamples =:idsamples"),
    @NamedQuery(name = "Analysis.findByIdsampleIdModelanalysis", query = "SELECT a FROM Analysis a WHERE a.idsamples = :idsamples and a.idmodelanalysis.idmodelanalysis=:idmodelanalysis"),
    @NamedQuery(name = "Analysis.findByIdsampleIdModelanalysisIdMethod", query = "SELECT a FROM Analysis a WHERE 1=1 and a.idsamples = :idsamples and a.idmodelanalysis =:idmodelanalysis  and a.idmethod=:idmethod"),
    @NamedQuery(name = "Analysis.findByCopyStatus", query = "SELECT a FROM Analysis a WHERE a.copystatus=:copystatus"),
    @NamedQuery(name = "Analysis.findByLimsanalysisorigrec", query = "SELECT a FROM Analysis a WHERE a.limsanalysisorigrec=:limsanalysisorigrec"),
   
})
public class Analysis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger idanalysis;
    private BigInteger limsid;
    @Size(max = 50)
    @Column(length = 50)
    private String limssampleid;
    private BigInteger limsanalysisorigrec;
    private BigInteger limsidanalysis;
    @JoinColumn(name = "IDCASEFILE", referencedColumnName = "IDCASEFILE")
    @ManyToOne
    private Casefile idcasefile;
    private BigInteger limsidseries;
    private BigInteger idseries;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    private BigInteger idmethoddetails;
    private BigInteger limsbatchid;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    private short idstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String statuslabel;
    private short idapprobationstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String approbationstatuslabel;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Boolean isvirtual;
    private Boolean isfinal;
    private Short occurence;
    @Size(max = 50)
    @Column(length = 50)
    private String officialename;
    @Size(max = 50)
    @Column(length = 50)
    private String limscounteranalysissampelid;
    private Short counteranalysis;

    private Short apporved;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    private Boolean herited;
    private Boolean considered;
    @Size(max = 50)
    @Column(length = 50)
    private String prodgroup;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisname;
    @Size(max = 50)
    @Column(length = 50)
    private String methodname;
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

    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;

    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE")
    @ManyToOne
    private Specie idspecie;

    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;

    @JoinColumn(name = "COPIEDFROMIDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch copiedfromidbatch;

    @JoinColumn(name = "COPIEDFROMIDSAMPLE", referencedColumnName = "IDSAMPLES")
    @ManyToOne
    private Samples copiedfromidsample;
    
    private int copystatus;
    
    private String copytype;

    public String getCopytype() {
        return copytype;
    }

    public void setCopytype(String copytype) {
        this.copytype = copytype;
    }

    public int getCopystatus() {
        return copystatus;
    }

    public void setCopystatus(int copystatus) {
        this.copystatus = copystatus;
    }
    

    public Batch getCopiedfromidbatch() {
        return copiedfromidbatch;
    }

    public void setCopiedfromidbatch(Batch copiedfromidbatch) {
        this.copiedfromidbatch = copiedfromidbatch;
    }

    public Analysis() {
    }

    public Analysis(BigInteger idanalysis) {
        this.idanalysis = idanalysis;
    }

    public BigInteger getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(BigInteger idanalysis) {
        this.idanalysis = idanalysis;
    }

    public BigInteger getLimsid() {
        return limsid;
    }

    public void setLimsid(BigInteger limsid) {
        this.limsid = limsid;
    }

    public String getLimssampleid() {
        return limssampleid;
    }

    public void setLimssampleid(String limssampleid) {
        this.limssampleid = limssampleid;
    }

    public BigInteger getLimsidanalysis() {
        return limsidanalysis;
    }

    public void setLimsidanalysis(BigInteger limsidanalysis) {
        this.limsidanalysis = limsidanalysis;
    }

    public Casefile getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(Casefile idcasefile) {
        this.idcasefile = idcasefile;
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

    public BigInteger getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(BigInteger idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
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

    public short getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(short idstatus) {
        this.idstatus = idstatus;
    }

    public String getStatuslabel() {
        return statuslabel;
    }

    public void setStatuslabel(String statuslabel) {
        this.statuslabel = statuslabel;
    }

    public short getIdapprobationstatus() {
        return idapprobationstatus;
    }

    public void setIdapprobationstatus(short idapprobationstatus) {
        this.idapprobationstatus = idapprobationstatus;
    }

    public String getApprobationstatuslabel() {
        return approbationstatuslabel;
    }

    public void setApprobationstatuslabel(String approbationstatuslabel) {
        this.approbationstatuslabel = approbationstatuslabel;
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

    public String getLimscounteranalysissampelid() {
        return limscounteranalysissampelid;
    }

    public void setLimscounteranalysissampelid(String limscounteranalysissampelid) {
        this.limscounteranalysissampelid = limscounteranalysissampelid;
    }

    public Short getCounteranalysis() {
        return counteranalysis;
    }

    public void setCounteranalysis(Short counteranalysis) {
        this.counteranalysis = counteranalysis;
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

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public Specie getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(Specie idspecie) {
        this.idspecie = idspecie;
    }

    public Stage getIdstage() {
        return idstage;
    }

    public void setIdstage(Stage idstage) {
        this.idstage = idstage;
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

    /**
     * @return the copiedfromidsample
     */
    public Samples getCopiedfromidsample() {
        return copiedfromidsample;
    }

    /**
     * @param copiedfromidsample the copiedfromidsample to set
     */
    public void setCopiedfromidsample(Samples copiedfromidsample) {
        this.copiedfromidsample = copiedfromidsample;
    }

    /**
     * @return the prodgroup
     */
    public String getProdgroup() {
        return prodgroup;
    }

    /**
     * @param prodgroup the prodgroup to set
     */
    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
    }

    /**
     * @return the limsanalysisorigrec
     */
    public BigInteger getLimsanalysisorigrec() {
        return limsanalysisorigrec;
    }

    /**
     * @param limsanalysisorigrec the limsanalysisorigrec to set
     */
    public void setLimsanalysisorigrec(BigInteger limsanalysisorigrec) {
        this.limsanalysisorigrec = limsanalysisorigrec;
    }

    /**
     * @return the creationdate
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * @param creationdate the creationdate to set
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}
