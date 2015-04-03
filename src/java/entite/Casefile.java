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
@Table(name = "casefile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casefile.findAll", query = "SELECT c FROM Casefile c"),
    @NamedQuery(name = "Casefile.findByIdcasefile", query = "SELECT c FROM Casefile c WHERE c.idcasefile = :idcasefile"),
    @NamedQuery(name = "Casefile.findByBatchname", query = "SELECT c FROM Casefile c WHERE c.batchname = :batchname"),
    @NamedQuery(name = "Casefile.findByLimsbatchid", query = "SELECT c FROM Casefile c WHERE c.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Casefile.findByLimsfolderno", query = "SELECT c FROM Casefile c WHERE c.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Casefile.findByIdstatus", query = "SELECT c FROM Casefile c WHERE c.idstatus = :idstatus"),
    @NamedQuery(name = "Casefile.findByStatuslabel", query = "SELECT c FROM Casefile c WHERE c.statuslabel = :statuslabel"),
    @NamedQuery(name = "Casefile.findByIdapprobationstatus", query = "SELECT c FROM Casefile c WHERE c.idapprobationstatus = :idapprobationstatus"),
    @NamedQuery(name = "Casefile.findByApprobationstatuslabel", query = "SELECT c FROM Casefile c WHERE c.approbationstatuslabel = :approbationstatuslabel"),
    @NamedQuery(name = "Casefile.findByIscurrent", query = "SELECT c FROM Casefile c WHERE c.iscurrent = :iscurrent"),
    @NamedQuery(name = "Casefile.findByDescription", query = "SELECT c FROM Casefile c WHERE c.description = :description")
    ,@NamedQuery(name = "Casefile.findByIdbatch", query = "SELECT c FROM Casefile c WHERE c.idbatch = :idbatch")
    ,@NamedQuery(name = "Casefile.findByIdbatchCurrentCasefile", query = "SELECT c FROM Casefile c WHERE c.idbatch = :idbatch and c.iscurrent = 1")    
})
public class Casefile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger idcasefile;
    private Boolean iscurrent;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
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
    @Size(max = 50)
    @Column(length = 50)
    private String prodgroup;
    @Size(max = 50)
    @Column(length = 50)
    private String casefiletype;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    private BigInteger limsbatchid;
    private Boolean idstatus;
    private Boolean idapprobationstatus;
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE")
    @ManyToOne
    private Specie idspecie;
    @OneToMany(mappedBy = "idcasefile")
    private List<Analysis> analysisList;
    @OneToMany(mappedBy = "idcasefile")
    private List<Samples> samplesList;
    @OneToMany(mappedBy = "idcasefile")
    private List<Results> resultsList;
        
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    public Casefile() {
    }

    public Casefile(BigInteger idcasefile) {
        this.idcasefile = idcasefile;
    }

    public BigInteger getIdcasefile() {
        return idcasefile;
    }

    public void setIdcasefile(BigInteger idcasefile) {
        this.idcasefile = idcasefile;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Boolean getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(Boolean iscurrent) {
        this.iscurrent = iscurrent;
    }

   

    public Batch getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(Batch idbatch) {
        this.idbatch = idbatch;
    }

    @XmlTransient
    public List<Samples> getSamplesList() {
        return samplesList;
    }

    public void setSamplesList(List<Samples> samplesList) {
        this.samplesList = samplesList;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
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

    public String getProdgroup() {
        return prodgroup;
    }

    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
    }

    public String getCasefiletype() {
        return casefiletype;
    }

    public void setCasefiletype(String casefiletype) {
        this.casefiletype = casefiletype;
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

    public Specie getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(Specie idspecie) {
        this.idspecie = idspecie;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
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
        hash += (idcasefile != null ? idcasefile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casefile)) {
            return false;
        }
        Casefile other = (Casefile) object;
        if ((this.idcasefile == null && other.idcasefile != null) || (this.idcasefile != null && !this.idcasefile.equals(other.idcasefile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Casefile[ idcasefile=" + idcasefile + " ]";
    }
    
}
