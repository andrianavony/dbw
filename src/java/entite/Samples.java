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
    @NamedQuery(name = "Samples.findAll", query = "SELECT s FROM Samples s"),
    @NamedQuery(name = "Samples.findByIdsamples", query = "SELECT s FROM Samples s WHERE s.idsamples = :idsamples"),
    @NamedQuery(name = "Samples.findByIdsamplestype", query = "SELECT s FROM Samples s WHERE s.idsamplestype = :idsamplestype"),
    @NamedQuery(name = "Samples.findByBatchname", query = "SELECT s FROM Samples s WHERE s.batchname = :batchname"),
    @NamedQuery(name = "Samples.findByDescription", query = "SELECT s FROM Samples s WHERE s.description = :description"),
    @NamedQuery(name = "Samples.findByCreationdate", query = "SELECT s FROM Samples s WHERE s.creationdate = :creationdate"),
    @NamedQuery(name = "Samples.findByIdstatus", query = "SELECT s FROM Samples s WHERE s.idstatus = :idstatus"),
    @NamedQuery(name = "Samples.findByApporved", query = "SELECT s FROM Samples s WHERE s.apporved = :apporved"),
    @NamedQuery(name = "Samples.findByApporvedby", query = "SELECT s FROM Samples s WHERE s.apporvedby = :apporvedby"),
    @NamedQuery(name = "Samples.findByApporveddate", query = "SELECT s FROM Samples s WHERE s.apporveddate = :apporveddate")})
public class Samples implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idsamples;
    private BigInteger idsamplestype;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    private Short idstatus;
    private Short apporved;
    @Size(max = 50)
    @Column(length = 50)
    private String apporvedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apporveddate;
    @OneToMany(mappedBy = "idsamples")
    private List<Results> resultsList;
    @OneToMany(mappedBy = "idsamples")
    private List<Analysis> analysisList;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDBATCH", referencedColumnName = "IDBATCH")
    @ManyToOne
    private Batch idbatch;
    @JoinColumn(name = "IDCASEFILE", referencedColumnName = "IDCASEFILE")
    @ManyToOne
    private Casefile idcasefile;

    public Samples() {
    }

    public Samples(Long idsamples) {
        this.idsamples = idsamples;
    }

    public Long getIdsamples() {
        return idsamples;
    }

    public void setIdsamples(Long idsamples) {
        this.idsamples = idsamples;
    }

    public BigInteger getIdsamplestype() {
        return idsamplestype;
    }

    public void setIdsamplestype(BigInteger idsamplestype) {
        this.idsamplestype = idsamplestype;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Short getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Short idstatus) {
        this.idstatus = idstatus;
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

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
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
