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
import javax.persistence.Table;
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
@Table(name = "samples")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Samples.findAll", query = "SELECT s FROM Samples s"),
    @NamedQuery(name = "Samples.findByIdsamples", query = "SELECT s FROM Samples s WHERE s.idsamples = :idsamples"),
    @NamedQuery(name = "Samples.findByIscurrent", query = "SELECT s FROM Samples s WHERE s.iscurrent = :iscurrent"),
    @NamedQuery(name = "Samples.findByBatchname", query = "SELECT s FROM Samples s WHERE s.batchname = :batchname"),
    @NamedQuery(name = "Samples.findByLimssampleid", query = "SELECT s FROM Samples s WHERE s.limssampleid = :limssampleid"),
    @NamedQuery(name = "Samples.findByCreationdate", query = "SELECT s FROM Samples s WHERE s.creationdate = :creationdate"),
    @NamedQuery(name = "Samples.findByStatuslabel", query = "SELECT s FROM Samples s WHERE s.statuslabel = :statuslabel"),
    @NamedQuery(name = "Samples.findByApprobationstatuslabel", query = "SELECT s FROM Samples s WHERE s.approbationstatuslabel = :approbationstatuslabel"),
    @NamedQuery(name = "Samples.findByApporved", query = "SELECT s FROM Samples s WHERE s.apporved = :apporved"),
    @NamedQuery(name = "Samples.findByApporvedby", query = "SELECT s FROM Samples s WHERE s.apporvedby = :apporvedby"),
    @NamedQuery(name = "Samples.findByApporveddate", query = "SELECT s FROM Samples s WHERE s.apporveddate = :apporveddate"),
    @NamedQuery(name = "Samples.findByLimsbatchid", query = "SELECT s FROM Samples s WHERE s.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Samples.findByLimsfolderno", query = "SELECT s FROM Samples s WHERE s.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Samples.findByIdsamplestype", query = "SELECT s FROM Samples s WHERE s.idsamplestype = :idsamplestype"),
    @NamedQuery(name = "Samples.findByDescription", query = "SELECT s FROM Samples s WHERE s.description = :description"),
    @NamedQuery(name = "Samples.findByIdstatus", query = "SELECT s FROM Samples s WHERE s.idstatus = :idstatus"),
    @NamedQuery(name = "Samples.findByIdapprobationstatus", query = "SELECT s FROM Samples s WHERE s.idapprobationstatus = :idapprobationstatus"),
    @NamedQuery(name = "Samples.findByProdgroup", query = "SELECT s FROM Samples s WHERE s.prodgroup = :prodgroup")
    ,@NamedQuery(name = "Samples.findByIdcasefileIscurrent", query = "SELECT s FROM Samples s WHERE s.idcasefile =:idcasefile and s.iscurrent = 1")    
})
public class Samples implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger idsamples;
    private Boolean iscurrent;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    @Size(max = 50)
    @Column(length = 50)
    private String limssampleid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Size(max = 50)
    @Column(length = 50)
    private String statuslabel;
    @Size(max = 50)
    @Column(length = 50)
    private String approbationstatuslabel;
    private Short apporved;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    private BigInteger limsbatchid;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    private BigInteger idsamplestype;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Boolean idstatus;
    private Boolean idapprobationstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String prodgroup;
    @OneToMany(mappedBy = "copiedfromidsample")
    private List<Analysis> analysisListCopiedFromOneOfMyanalysis;
    @OneToMany(mappedBy = "idsamples")
    private List<Analysis> analysisList;
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE", insertable = true, updatable = true)
    @ManyToOne
    private Stage idstage;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE",insertable = true, updatable = true)
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    @JoinColumn(name = "IDCASEFILE", referencedColumnName = "IDCASEFILE")
    @ManyToOne
    private Casefile idcasefile;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", insertable = true, updatable = true)
    @ManyToOne
    private Specie idspecie;
    
    @OneToMany(mappedBy = "copiedfromidsample")
    private List<Results> resultsListCopiedFromOneOfMyResults;
    @OneToMany(mappedBy = "idsamples")
    private List<Results> resultsList;

    public Samples() {
    }

    public Samples(BigInteger idsamples) {
        this.idsamples = idsamples;
    }

    public BigInteger getIdsamples() {
        return idsamples;
    }

    public void setIdsamples(BigInteger idsamples) {
        this.idsamples = idsamples;
    }

    public Boolean getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(Boolean iscurrent) {
        this.iscurrent = iscurrent;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getLimssampleid() {
        return limssampleid;
    }

    public void setLimssampleid(String limssampleid) {
        this.limssampleid = limssampleid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getStatuslabel() {
        return statuslabel;
    }

    public void setStatuslabel(String statuslabel) {
        this.statuslabel = statuslabel;
    }

    public String getApprobationstatuslabel() {
        return approbationstatuslabel;
    }

    public void setApprobationstatuslabel(String approbationstatuslabel) {
        this.approbationstatuslabel = approbationstatuslabel;
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

    public BigInteger getIdsamplestype() {
        return idsamplestype;
    }

    public void setIdsamplestype(BigInteger idsamplestype) {
        this.idsamplestype = idsamplestype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Boolean idstatus) {
        this.idstatus = idstatus;
    }

    public Boolean getIdapprobationstatus() {
        return idapprobationstatus;
    }

    public void setIdapprobationstatus(Boolean idapprobationstatus) {
        this.idapprobationstatus = idapprobationstatus;
    }

    public String getProdgroup() {
        return prodgroup;
    }

    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
    }

    @XmlTransient
    public List<Analysis> getAnalysisListCopiedFromOneOfMyanalysis() {
        return analysisListCopiedFromOneOfMyanalysis;
    }

    public void setAnalysisListCopiedFromOneOfMyanalysis(List<Analysis> analysisListCopiedFromOneOfMyanalysis) {
        this.analysisListCopiedFromOneOfMyanalysis = analysisListCopiedFromOneOfMyanalysis;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public Stage getIdstage() {
        return idstage;
    }

    public void setIdstage(Stage idstage) {
        this.idstage = idstage;
    }

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public Batch getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(Batch idbatch) {
        this.idbatch = idbatch;
    }

    public Casefile getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(Casefile idcasefile) {
        this.idcasefile = idcasefile;
    }

    public Specie getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(Specie idspecie) {
        this.idspecie = idspecie;
    }

    @XmlTransient
    public List<Results> getResultsListCopiedFromOneOfMyResults() {
        return resultsListCopiedFromOneOfMyResults;
    }

    public void setResultsListCopiedFromOneOfMyResults(List<Results> resultsListCopiedFromOneOfMyResults) {
        this.resultsListCopiedFromOneOfMyResults = resultsListCopiedFromOneOfMyResults;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsamples != null ? idsamples.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samples)) {
            return false;
        }
        Samples other = (Samples) object;
        if ((this.idsamples == null && other.idsamples != null) || (this.idsamples != null && !this.idsamples.equals(other.idsamples))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Samples[ idsamples=" + idsamples + " ]";
    }
    
}
