/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "stage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findByIdstage", query = "SELECT s FROM Stage s WHERE s.idstage = :idstage"),
    @NamedQuery(name = "Stage.findByDescription", query = "SELECT s FROM Stage s WHERE s.description = :description"),
    @NamedQuery(name = "Stage.findByStagename", query = "SELECT s FROM Stage s WHERE s.stagename = :stagename")})
public class Stage implements Serializable {
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idstage;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String stagename;
    @OneToMany(mappedBy = "idstage")
    private List<Casefile> casefileList;
    @OneToMany(mappedBy = "idstage")
    private List<Batch> batchList;
    @OneToMany(mappedBy = "idstage")
    private List<Analysis> analysisList;
    @OneToMany(mappedBy = "idstage")
    private List<Samples> samplesList;
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "idstage")
    private List<Article> articleList;

    public Stage() {
    }

    public Stage(String idstage) {
        this.idstage = idstage;
    }

    public String getIdstage() {
        return idstage;
    }

    public void setIdstage(String idstage) {
        this.idstage = idstage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @XmlTransient
    public List<Casefile> getCasefileList() {
        return casefileList;
    }

    public void setCasefileList(List<Casefile> casefileList) {
        this.casefileList = casefileList;
    }

    @XmlTransient
    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
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
        hash += (idstage != null ? idstage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.idstage == null && other.idstage != null) || (this.idstage != null && !this.idstage.equals(other.idstage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Stage[ idstage=" + idstage + " ]";
    }
    
}
