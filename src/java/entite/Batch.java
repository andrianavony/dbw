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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@Table(name = "batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batch.findAll", query = "SELECT b FROM Batch b"),
    @NamedQuery(name = "Batch.findByIdbatch", query = "SELECT b FROM Batch b WHERE b.idbatch = :idbatch"),
    @NamedQuery(name = "Batch.findByBatchname", query = "SELECT b FROM Batch b WHERE b.batchname = :batchname"),
    @NamedQuery(name = "Batch.findByDescription", query = "SELECT b FROM Batch b WHERE b.description = :description"),
    @NamedQuery(name = "Batch.findByIdarticle", query = "SELECT b FROM Batch b WHERE b.idarticle = :idarticle"),
    @NamedQuery(name = "Batch.findByIdstage", query = "SELECT b FROM Batch b WHERE b.idstage = :idstage"),
    @NamedQuery(name = "Batch.findByIdspecie", query = "SELECT b FROM Batch b WHERE b.idspecie = :idspecie"),
    @NamedQuery(name = "Batch.findByIdvariety", query = "SELECT b FROM Batch b WHERE b.idvariety = :idvariety"),
    @NamedQuery(name = "Batch.findByIdgeneration", query = "SELECT b FROM Batch b WHERE b.idgeneration = :idgeneration"),
    @NamedQuery(name = "Batch.findByProdgroup", query = "SELECT b FROM Batch b WHERE b.prodgroup = :prodgroup"),
    @NamedQuery(name = "Batch.findByIdpea", query = "SELECT b FROM Batch b WHERE b.idpea = :idpea"),
    @NamedQuery(name = "Batch.findByOrigin1", query = "SELECT b FROM Batch b WHERE b.origin1 = :origin1"),
    @NamedQuery(name = "Batch.findByOrigin2", query = "SELECT b FROM Batch b WHERE b.origin2 = :origin2"),
    @NamedQuery(name = "Batch.findByIddiagram", query = "SELECT b FROM Batch b WHERE b.iddiagram = :iddiagram"),
    @NamedQuery(name = "Batch.findByIdcaliber", query = "SELECT b FROM Batch b WHERE b.idcaliber = :idcaliber"),
    @NamedQuery(name = "Batch.findByIdwo", query = "SELECT b FROM Batch b WHERE b.idwo = :idwo"),
    @NamedQuery(name = "Batch.findByIdtrace", query = "SELECT b FROM Batch b WHERE b.idtrace = :idtrace"),
    @NamedQuery(name = "Batch.findByQuantity", query = "SELECT b FROM Batch b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Batch.findByUnits", query = "SELECT b FROM Batch b WHERE b.units = :units"),
    @NamedQuery(name = "Batch.findByLimsbatchid", query = "SELECT b FROM Batch b WHERE b.limsbatchid = :limsbatchid"),
    @NamedQuery(name = "Batch.findByIdcompany", query = "SELECT b FROM Batch b WHERE b.idcompany = :idcompany"),
    @NamedQuery(name = "Batch.findByContract", query = "SELECT b FROM Batch b WHERE b.contract = :contract"),
    @NamedQuery(name = "Batch.findByIdtreatement", query = "SELECT b FROM Batch b WHERE b.idtreatement = :idtreatement"),
    @NamedQuery(name = "Batch.findByLimsfolderno", query = "SELECT b FROM Batch b WHERE b.limsfolderno = :limsfolderno"),
    @NamedQuery(name = "Batch.findByIdarticleBatchname", query = "SELECT b "
            + " FROM Batch b "
            + " WHERE b.batchname = :batchname "
            + " and b.idarticle = :idarticle "),
    @NamedQuery(name = "Batch.findByIdarticleBatchnameCompanyname", query = "SELECT b "
            + " FROM Batch b "
            + " WHERE b.batchname = :batchname "
            + " and b.idarticle.idarticle= :idarticle "
            + " and b.idcompany.idcompany = :idcompany"
    )
    ,@NamedQuery(name = "Batch.findByIdarticleBatchnameCompanynameIdWo", query = "SELECT b "
            + " FROM Batch b "
            + " WHERE b.batchname = :batchname "
            + " and b.idarticle.idarticle= :idarticle "
            + " and b.idwo = :idwo "
            + " and b.idcompany.idcompany = :idcompany"
            
    )    
})

public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = true)
    private BigInteger idbatch;
    @Size(max = 50)
    @Column(length = 50)
    private String batchname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String prodgroup;
    @Size(max = 50)
    @Column(length = 50)
    private String idpea;
    @Size(max = 50)
    @Column(length = 50)
    private String origin1;
    @Size(max = 50)
    @Column(length = 50)
    private String origin2;
    @Size(max = 50)
    @Column(length = 50)
    private String iddiagram;
    @Size(max = 50)
    @Column(length = 50)
    private String idcaliber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double quantity;
    @Size(max = 50)
    @Column(length = 50)
    private String units;
    private BigInteger limsbatchid;
    @Size(max = 50)
    @Column(length = 50)
    private String contract;
    @Size(max = 50)
    @Column(length = 50)
    private String producername;
    @Size(max = 50)
    @Column(length = 50)
    private String limsfolderno;
    @JoinColumn(name = "IDGENERATION", referencedColumnName = "IDGENERATION")
    @ManyToOne
    private Generation idgeneration;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", insertable = false, updatable = false)
    @ManyToOne
    private Specie idspecie;
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn(name = "IDVARIETY", referencedColumnName = "IDVARIETY"),
        @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", insertable = true, updatable = true)    
    })
    private Variety idvariety;
    @OneToMany(mappedBy = "copiedfromidbatch")
    private List<Analysis> analysisListCopiedFromThisBatch;
    @OneToMany(mappedBy = "idbatch")
    private List<Analysis> analysisList;
    @OneToMany(mappedBy = "idbatch")
    private List<Samples> samplesList;
    @OneToMany(mappedBy = "batchname")
    private List<Trace> traceList;
    @OneToMany(mappedBy = "idbatch")
    private List<Results> resultsList;
    @OneToMany(mappedBy = "idbatch")
    private List<Casefile> casefileList;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = true, updatable = true)
    private Company idcompany;
     @JoinColumn(name = "IDTRACE", referencedColumnName = "IDTRACE")
    @ManyToOne

    private Trace idtrace;
     
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn(name = "IDWO", referencedColumnName = "IDWO"),
        @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = false, updatable = false)    
    })
    private Wo idwo;
    @JoinColumn(name = "IDTREATEMENT", referencedColumnName = "IDTREATEMENT")
    @ManyToOne
    private Treatement idtreatement;

    
    public Batch() {
    }

    public Batch(BigInteger idbatch) {
        this.idbatch = idbatch;
    }

    public BigInteger getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(BigInteger idbatch) {
        this.idbatch = idbatch;
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
    
    public String getProdgroup() {
        return prodgroup;
    }

    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
    }

    public String getIdpea() {
        return idpea;
    }

    public void setIdpea(String idpea) {
        this.idpea = idpea;
    }

    public String getOrigin1() {
        return origin1;
    }

    public void setOrigin1(String origin1) {
        this.origin1 = origin1;
    }

    public String getOrigin2() {
        return origin2;
    }

    public void setOrigin2(String origin2) {
        this.origin2 = origin2;
    }

    public String getIddiagram() {
        return iddiagram;
    }

    public void setIddiagram(String iddiagram) {
        this.iddiagram = iddiagram;
    }

    public String getIdcaliber() {
        return idcaliber;
    }

    public void setIdcaliber(String idcaliber) {
        this.idcaliber = idcaliber;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public BigInteger getLimsbatchid() {
        return limsbatchid;
    }

    public void setLimsbatchid(BigInteger limsbatchid) {
        this.limsbatchid = limsbatchid;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    public String getProducername() {
        return producername;
    }

    public void setProducername(String producername) {
        this.producername = producername;
    }

        public String getLimsfolderno() {
        return limsfolderno;
    }

    public void setLimsfolderno(String limsfolderno) {
        this.limsfolderno = limsfolderno;
    }
    
    @XmlTransient
    public List<Trace> getTraceList() {
        return traceList;
    }

    public void setTraceList(List<Trace> traceList) {
        this.traceList = traceList;
    }


    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @XmlTransient
    public List<Casefile> getCasefileList() {
        return casefileList;
    }

    public void setCasefileList(List<Casefile> casefileList) {
        this.casefileList = casefileList;
    }

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public Company getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Company idcompany) {
        this.idcompany = idcompany;
    }
    
    public Trace getIdtrace() {
        return idtrace;
    }

    public void setIdtrace(Trace idtrace) {
        this.idtrace = idtrace;
    }

    public Wo getIdwo() {
        return idwo;
    }

    public void setIdwo(Wo idwo) {
        this.idwo = idwo;
    }

    public Treatement getIdtreatement() {
        return idtreatement;
    }

    public void setIdtreatement(Treatement idtreatement) {
        this.idtreatement = idtreatement;
    }

    @XmlTransient
    public List<Analysis> getAnalysisListCopiedFromThisBatch() {
        return analysisListCopiedFromThisBatch;
    }

    public void setAnalysisListCopiedFromThisBatch(List<Analysis> analysisListCopiedFromThisBatch) {
        this.analysisListCopiedFromThisBatch = analysisListCopiedFromThisBatch;
    }

    @XmlTransient
    public List<Samples> getSamplesList() {
        return samplesList;
    }

    public void setSamplesList(List<Samples> samplesList) {
        this.samplesList = samplesList;
    }

    public Generation getIdgeneration() {
        return idgeneration;
    }

    public void setIdgeneration(Generation idgeneration) {
        this.idgeneration = idgeneration;
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

    public Variety getIdvariety() {
        return idvariety;
    }

    public void setIdvariety(Variety idvariety) {
        this.idvariety = idvariety;
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
        hash += (idbatch != null ? idbatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.idbatch == null && other.idbatch != null) || (this.idbatch != null && !this.idbatch.equals(other.idbatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Batch[ idbatch=" + idbatch + " ]";
    }

        
}
