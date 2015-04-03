/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdarticle", query = "SELECT a FROM Article a WHERE a.idarticle = :idarticle"),
    @NamedQuery(name = "Article.findByDescription", query = "SELECT a FROM Article a WHERE a.description = :description"),
    @NamedQuery(name = "Article.findByArticlename", query = "SELECT a FROM Article a WHERE a.articlename = :articlename"),
    @NamedQuery(name = "Article.findByOfficialname", query = "SELECT a FROM Article a WHERE a.officialname = :officialname"),
    @NamedQuery(name = "Article.findByVarietyStadeGeneration", query = "SELECT a FROM Article a WHERE a.idvariety.varietyPK.idvariety = :idvariety and a.idstage.idstage = :idstage and a.idgeneration.idgeneration = :idgeneration"),
    @NamedQuery(name = "Article.findTest", query = "SELECT a FROM Article a WHERE a.idvariety.varietyPK.idvariety = 'S10039' and a.idstage.idstage = 'B'")
})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idarticle;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String articlename;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    @OneToMany(mappedBy = "idarticle")
    private List<Casefile> casefileList;
    @OneToMany(mappedBy = "idarticle")
    private List<Analysis> analysisList;
    @OneToMany(mappedBy = "idarticle")
    private List<Samples> samplesList;
    @OneToMany(mappedBy = "idarticle")
    private Collection<Trace> traceCollection;
    @OneToMany(mappedBy = "idarticle")
    private Collection<Sampleplangroup> sampleplangroupCollection;
    @OneToMany(mappedBy = "idarticle")
    private Collection<Batch> batchCollection;
    @JoinColumn(name = "IDSTAGE", referencedColumnName = "IDSTAGE")
    @ManyToOne
    private Stage idstage;
    @JoinColumn(name = "IDGENERATION", referencedColumnName = "IDGENERATION")
    @ManyToOne
    private Generation idgeneration;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", insertable = false, updatable = false)
    @ManyToOne
    private Specie idspecie;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn( name="idvariety", referencedColumnName = "IDVARIETY", insertable = true, updatable = false, nullable = true),
        @JoinColumn( name="idspecie", referencedColumnName = "IDSPECIE", insertable = true, updatable = false, nullable = true)
    })
    private Variety idvariety;
    @OneToMany(mappedBy = "idarticle")
    private Collection<Samples> samplesCollection;

    public Article() {
    }

    public Article(String idarticle) {
        this.idarticle = idarticle;
    }

    public String getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    @XmlTransient
    public Collection<Trace> getTraceCollection() {
        return traceCollection;
    }

    public void setTraceCollection(Collection<Trace> traceCollection) {
        this.traceCollection = traceCollection;
    }

    @XmlTransient
    public Collection<Sampleplangroup> getSampleplangroupCollection() {
        return sampleplangroupCollection;
    }

    public void setSampleplangroupCollection(Collection<Sampleplangroup> sampleplangroupCollection) {
        this.sampleplangroupCollection = sampleplangroupCollection;
    }

    @XmlTransient
    public Collection<Batch> getBatchCollection() {
        return batchCollection;
    }

    public void setBatchCollection(Collection<Batch> batchCollection) {
        this.batchCollection = batchCollection;
    }

    public Stage getIdstage() {
        return idstage;
    }

    public void setIdstage(Stage idstage) {
        this.idstage = idstage;
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

    public Variety getIdvariety() {
        return idvariety;
    }

    public void setIdvariety(Variety idvariety) {
        this.idvariety = idvariety;
    }

    @XmlTransient
    public Collection<Samples> getSamplesCollection() {
        return samplesCollection;
    }

    public void setSamplesCollection(Collection<Samples> samplesCollection) {
        this.samplesCollection = samplesCollection;
    }

    @XmlTransient
    public List<Casefile> getCasefileList() {
        return casefileList;
    }

    public void setCasefileList(List<Casefile> casefileList) {
        this.casefileList = casefileList;
    }

    @XmlTransient
    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    @XmlTransient
    public List<Samples> getSamplesList() {
        return samplesList;
    }

    public void setSamplesList(List<Samples> samplesList) {
        this.samplesList = samplesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticle != null ? idarticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idarticle == null && other.idarticle != null) || (this.idarticle != null && !this.idarticle.equals(other.idarticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Article[ idarticle=" + idarticle + " ]";
    }

}
