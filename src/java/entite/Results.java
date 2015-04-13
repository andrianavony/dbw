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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import session.ejb.AddResultsListener;

/**
 *
 * @author S.ANDRIANAVONY
 */
@EntityListeners({AddResultsListener.class})
@Entity
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r"),
    @NamedQuery(name = "Results.findByIdresult", query = "SELECT r FROM Results r WHERE r.idresult = :idresult"),
    @NamedQuery(name = "Results.findByLimsmeasureid", query = "SELECT r FROM Results r WHERE r.limsmeasureid = :limsmeasureid"),
    @NamedQuery(name = "Results.findByLimsid", query = "SELECT r FROM Results r WHERE r.limsid = :limsid"),
    @NamedQuery(name = "Results.findByLimsidseries", query = "SELECT r FROM Results r WHERE r.limsidseries = :limsidseries"),
    @NamedQuery(name = "Results.findByIdseries", query = "SELECT r FROM Results r WHERE r.idseries = :idseries"),
    @NamedQuery(name = "Results.findByLimssampleid", query = "SELECT r FROM Results r WHERE r.limssampleid = :limssampleid"),
    @NamedQuery(name = "Results.findByLimsidanalysis", query = "SELECT r FROM Results r WHERE r.limsidanalysis = :limsidanalysis"),
    @NamedQuery(name = "Results.findByLimsidmethod", query = "SELECT r FROM Results r WHERE r.limsidmethod = :limsidmethod"),
    @NamedQuery(name = "Results.findByIdmethoddetails", query = "SELECT r FROM Results r WHERE r.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Results.findByIdcasefile", query = "SELECT r FROM Results r WHERE r.idcasefile = :idcasefile"),
    @NamedQuery(name = "Results.findByLimsbatchid", query = "SELECT r FROM Results r WHERE r.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Results.findByLimsfolderno", query = "SELECT r FROM Results r WHERE r.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Results.findByBatchname", query = "SELECT r FROM Results r WHERE r.batchname = :batchname"),
    @NamedQuery(name = "Results.findByIdstatus", query = "SELECT r FROM Results r WHERE r.idstatus = :idstatus"),
    @NamedQuery(name = "Results.findByStatuslabel", query = "SELECT r FROM Results r WHERE r.statuslabel = :statuslabel"),
    @NamedQuery(name = "Results.findByIdapprobationstatus", query = "SELECT r FROM Results r WHERE r.idapprobationstatus = :idapprobationstatus"),
    @NamedQuery(name = "Results.findByApprobationstatuslabel", query = "SELECT r FROM Results r WHERE r.approbationstatuslabel = :approbationstatuslabel"),
    @NamedQuery(name = "Results.findByAnalysisidstatus", query = "SELECT r FROM Results r WHERE r.analysisidstatus = :analysisidstatus"),
    @NamedQuery(name = "Results.findByAnalysisstatuslabel", query = "SELECT r FROM Results r WHERE r.analysisstatuslabel = :analysisstatuslabel"),
    @NamedQuery(name = "Results.findByAnalysisidapprobationstatus", query = "SELECT r FROM Results r WHERE r.analysisidapprobationstatus = :analysisidapprobationstatus"),
    @NamedQuery(name = "Results.findByAnalysisapprobationstatuslabel", query = "SELECT r FROM Results r WHERE r.analysisapprobationstatuslabel = :analysisapprobationstatuslabel"),
    @NamedQuery(name = "Results.findByDescription", query = "SELECT r FROM Results r WHERE r.description = :description"),
    @NamedQuery(name = "Results.findByIsvirtual", query = "SELECT r FROM Results r WHERE r.isvirtual = :isvirtual"),
    @NamedQuery(name = "Results.findByIsfinal", query = "SELECT r FROM Results r WHERE r.isfinal = :isfinal"),
    @NamedQuery(name = "Results.findByIsresults", query = "SELECT r FROM Results r WHERE r.isresults = :isresults"),
    @NamedQuery(name = "Results.findByIsrequired", query = "SELECT r FROM Results r WHERE r.isrequired = :isrequired"),
    @NamedQuery(name = "Results.findByOccurence", query = "SELECT r FROM Results r WHERE r.occurence = :occurence"),
    @NamedQuery(name = "Results.findByCounteranalysis", query = "SELECT r FROM Results r WHERE r.counteranalysis = :counteranalysis"),
    @NamedQuery(name = "Results.findByCounteranalysisidlims", query = "SELECT r FROM Results r WHERE r.counteranalysisidlims = :counteranalysisidlims"),
    @NamedQuery(name = "Results.findByOfficialename", query = "SELECT r FROM Results r WHERE r.officialename = :officialename"),
    @NamedQuery(name = "Results.findByMaingroup", query = "SELECT r FROM Results r WHERE r.maingroup = :maingroup"),
    @NamedQuery(name = "Results.findBySubgroup", query = "SELECT r FROM Results r WHERE r.subgroup = :subgroup"),
    @NamedQuery(name = "Results.findByMeasuremaster", query = "SELECT r FROM Results r WHERE r.measuremaster = :measuremaster"),
    @NamedQuery(name = "Results.findByMeasuredetails", query = "SELECT r FROM Results r WHERE r.measuredetails = :measuredetails"),
    @NamedQuery(name = "Results.findByRepetition", query = "SELECT r FROM Results r WHERE r.repetition = :repetition"),
    @NamedQuery(name = "Results.findBySubrepetition", query = "SELECT r FROM Results r WHERE r.subrepetition = :subrepetition"),
    @NamedQuery(name = "Results.findByValuemin", query = "SELECT r FROM Results r WHERE r.valuemin = :valuemin"),
    @NamedQuery(name = "Results.findByPreferdvaluemin", query = "SELECT r FROM Results r WHERE r.preferdvaluemin = :preferdvaluemin"),
    @NamedQuery(name = "Results.findByPreferdvaluemax", query = "SELECT r FROM Results r WHERE r.preferdvaluemax = :preferdvaluemax"),
    @NamedQuery(name = "Results.findByValuemax", query = "SELECT r FROM Results r WHERE r.valuemax = :valuemax"),
    @NamedQuery(name = "Results.findByRawresults", query = "SELECT r FROM Results r WHERE r.rawresults = :rawresults"),
    @NamedQuery(name = "Results.findByFormated", query = "SELECT r FROM Results r WHERE r.formated = :formated"),
    @NamedQuery(name = "Results.findByApporved", query = "SELECT r FROM Results r WHERE r.apporved = :apporved"),
    @NamedQuery(name = "Results.findByApporveddate", query = "SELECT r FROM Results r WHERE r.apporveddate = :apporveddate"),
    @NamedQuery(name = "Results.findByApporvedby", query = "SELECT r FROM Results r WHERE r.apporvedby = :apporvedby"),
    @NamedQuery(name = "Results.findByDateofentry", query = "SELECT r FROM Results r WHERE r.dateofentry = :dateofentry"),
    @NamedQuery(name = "Results.findByUsername", query = "SELECT r FROM Results r WHERE r.username = :username"),
    @NamedQuery(name = "Results.findByHerited", query = "SELECT r FROM Results r WHERE r.herited = :herited"),
    @NamedQuery(name = "Results.findByMeasurename", query = "SELECT r FROM Results r WHERE r.measurename = :measurename"),
    @NamedQuery(name = "Results.findByAnalysisname", query = "SELECT r FROM Results r WHERE r.analysisname = :analysisname"),
    @NamedQuery(name = "Results.findByMethodname", query = "SELECT r FROM Results r WHERE r.methodname = :methodname"),
    @NamedQuery(name = "Results.findByCopiedfrom", query = "SELECT r FROM Results r WHERE r.copiedfrom = :copiedfrom"),
    @NamedQuery(name = "Results.findByIsresultsinserted", query = "SELECT r FROM Results r WHERE r.isresultsinserted = :isresultsinserted")})
public class Results implements Serializable {    
    private Boolean herited;
    //@Size(max = 50)
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    @Size(max = 50)
    @Column(length = 50)
    private String limssampleid;
    private BigInteger limsidanalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisname;
    @Size(max = 50)
    @Column(length = 50)
    private String methodname;
    private Short repetition;
    private Short subrepetition;
    @Size(max = 50)
    @Column(length = 50)
    private String measurename;
    @Size(max = 50)
    @Column(length = 50)
    private String rawresults;
    @Size(max = 50)
    @Column(length = 50)
    private String formated;
    private BigInteger limsidseries;
    private BigInteger idseries;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Size(max = 50)
    @Column(length = 50)
    private String statuslabel;
    @Size(max = 50)
    @Column(length = 50)
    private String approbationstatuslabel;
    private Boolean apporved;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger idresult;
    private BigInteger limsmeasureid;
    @Size(max = 50)
    @Column(length = 50)
    private String limscounteranalysissampelid;
    private Short counteranalysis;
    private BigInteger limsid;
    private BigInteger limsbatchid;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    @Size(max = 50)
    @Column(length = 50)
    private String limsidmethod;
    private BigInteger idmethoddetails;
    private Boolean idstatus;
    private Boolean idapprobationstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Boolean isvirtual;
    private Boolean isfinal;
    private Boolean isresults;
    private Boolean isrequired;
    private Short occurence;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valuemin;
    @Column(precision = 22)
    private Double preferdvaluemin;
    @Column(precision = 22)
    private Double preferdvaluemax;
    @Column(precision = 22)
    private Double valuemax;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofentry;
    @Size(max = 50)
    @Column(length = 50)
    private String username;
    private Boolean considered;
    @Size(max = 50)
    @Column(length = 50)
    private String prodgroup;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE")
    @ManyToOne
    private Specie idspecie;
    
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;
    @Size(max = 50)
    @Column(length = 50)
    private String copiedfromlimsbathcname;
    @OneToMany(mappedBy = "copiedfromidanalysis")
    private List<Results> resultsList;
    @JoinColumn(name = "COPIEDFROMIDANALYSIS", referencedColumnName = "IDANALYSIS")
    @ManyToOne
    private Results copiedfromidanalysis;
    @JoinColumn(name = "COPIEDFROMIDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch copiedfromidbatch;
    @JoinColumn(name = "COPIEDFROMIDSAMPLE", referencedColumnName = "IDSAMPLES")
    @ManyToOne
    private Samples copiedfromidsample;
    @JoinColumn(name = "IDCASEFILE", referencedColumnName = "IDCASEFILE")
    @ManyToOne
    private Casefile idcasefile;

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
    private String counteranalysisidlims;
    @Size(max = 50)
    @Column(length = 50)
    private String copiedfrom;
    private Boolean isresultsinserted;
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

    public Results(BigInteger idresult) {
        this.idresult = idresult;
    }

    public BigInteger getIdresult() {
        return idresult;
    }

    public void setIdresult(BigInteger idresult) {
        this.idresult = idresult;
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

    public BigInteger getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(BigInteger idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
    }

    public Casefile getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(Casefile idcasefile) {
        this.idcasefile = idcasefile;
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

    public Double getValuemin() {
        return valuemin;
    }

    public void setValuemin(Double valuemin) {
        this.valuemin = valuemin;
    }

    public Double getPreferdvaluemin() {
        return preferdvaluemin;
    }

    public void setPreferdvaluemin(Double preferdvaluemin) {
        this.preferdvaluemin = preferdvaluemin;
    }

    public Double getPreferdvaluemax() {
        return preferdvaluemax;
    }

    public void setPreferdvaluemax(Double preferdvaluemax) {
        this.preferdvaluemax = preferdvaluemax;
    }

    public Double getValuemax() {
        return valuemax;
    }

    public void setValuemax(Double valuemax) {
        this.valuemax = valuemax;
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

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Boolean getConsidered() {
        return considered;
    }

    public void setConsidered(Boolean considered) {
        this.considered = considered;
    }

    public String getProdgroup() {
        return prodgroup;
    }

    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
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

    public String getCopiedfromlimsbathcname() {
        return copiedfromlimsbathcname;
    }

    public void setCopiedfromlimsbathcname(String copiedfromlimsbathcname) {
        this.copiedfromlimsbathcname = copiedfromlimsbathcname;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    public Results getCopiedfromidanalysis() {
        return copiedfromidanalysis;
    }

    public void setCopiedfromidanalysis(Results copiedfromidanalysis) {
        this.copiedfromidanalysis = copiedfromidanalysis;
    }

    public Batch getCopiedfromidbatch() {
        return copiedfromidbatch;
    }

    public void setCopiedfromidbatch(Batch copiedfromidbatch) {
        this.copiedfromidbatch = copiedfromidbatch;
    }

    public Samples getCopiedfromidsample() {
        return copiedfromidsample;
    }

    public void setCopiedfromidsample(Samples copiedfromidsample) {
        this.copiedfromidsample = copiedfromidsample;
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
