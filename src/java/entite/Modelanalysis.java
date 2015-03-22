/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Modelanalysis.findAll", query = "SELECT m FROM Modelanalysis m"),
    @NamedQuery(name = "Modelanalysis.findByIdmodelanalysis", query = "SELECT m FROM Modelanalysis m WHERE m.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Modelanalysis.findByIdlims", query = "SELECT m FROM Modelanalysis m WHERE m.idlims = :idlims"),
    @NamedQuery(name = "Modelanalysis.findByCategory", query = "SELECT m FROM Modelanalysis m WHERE m.category = :category"),
    @NamedQuery(name = "Modelanalysis.findByDescription", query = "SELECT m FROM Modelanalysis m WHERE m.description = :description"),
    @NamedQuery(name = "Modelanalysis.findByAnalysisname", query = "SELECT m FROM Modelanalysis m WHERE m.analysisname = :analysisname"),
    @NamedQuery(name = "Modelanalysis.findByOfficialname", query = "SELECT m FROM Modelanalysis m WHERE m.officialname = :officialname"),
    @NamedQuery(name = "Modelanalysis.findByGroupmeasures", query = "SELECT m FROM Modelanalysis m WHERE m.groupmeasures = :groupmeasures"),
    @NamedQuery(name = "Modelanalysis.findByOfficialanalysis", query = "SELECT m FROM Modelanalysis m WHERE m.officialanalysis = :officialanalysis"),
    @NamedQuery(name = "Modelanalysis.findByInternalanalysis", query = "SELECT m FROM Modelanalysis m WHERE m.internalanalysis = :internalanalysis")})
public class Modelanalysis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idmodelanalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String idlims;
    @Size(max = 50)
    @Column(length = 50)
    private String category;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String analysisname;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    @Size(max = 50)
    @Column(length = 50)
    private String groupmeasures;
    private Boolean officialanalysis;
    private Boolean internalanalysis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelanalysis")
    private List<Heritagebygroupofsample> heritagebygroupofsampleList;
    @OneToMany(mappedBy = "idmodelanalysis")
    private List<Results> resultsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelanalysis")
    private List<Heritagebyspecieorigin> heritagebyspecieoriginList;
    @OneToMany(mappedBy = "idmodelanalysis")
    private List<Method> methodList;
    @OneToMany(mappedBy = "idmodelanalysis")
    private List<Analysis> analysisList;

    public Modelanalysis() {
    }

    public Modelanalysis(Long idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public Long getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(Long idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public String getIdlims() {
        return idlims;
    }

    public void setIdlims(String idlims) {
        this.idlims = idlims;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnalysisname() {
        return analysisname;
    }

    public void setAnalysisname(String analysisname) {
        this.analysisname = analysisname;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    public String getGroupmeasures() {
        return groupmeasures;
    }

    public void setGroupmeasures(String groupmeasures) {
        this.groupmeasures = groupmeasures;
    }

    public Boolean getOfficialanalysis() {
        return officialanalysis;
    }

    public void setOfficialanalysis(Boolean officialanalysis) {
        this.officialanalysis = officialanalysis;
    }

    public Boolean getInternalanalysis() {
        return internalanalysis;
    }

    public void setInternalanalysis(Boolean internalanalysis) {
        this.internalanalysis = internalanalysis;
    }

    @XmlTransient
    public List<Heritagebygroupofsample> getHeritagebygroupofsampleList() {
        return heritagebygroupofsampleList;
    }

    public void setHeritagebygroupofsampleList(List<Heritagebygroupofsample> heritagebygroupofsampleList) {
        this.heritagebygroupofsampleList = heritagebygroupofsampleList;
    }

    @XmlTransient
    public List<Results> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @XmlTransient
    public List<Heritagebyspecieorigin> getHeritagebyspecieoriginList() {
        return heritagebyspecieoriginList;
    }

    public void setHeritagebyspecieoriginList(List<Heritagebyspecieorigin> heritagebyspecieoriginList) {
        this.heritagebyspecieoriginList = heritagebyspecieoriginList;
    }

    @XmlTransient
    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
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
        hash += (idmodelanalysis != null ? idmodelanalysis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelanalysis)) {
            return false;
        }
        Modelanalysis other = (Modelanalysis) object;
        if ((this.idmodelanalysis == null && other.idmodelanalysis != null) || (this.idmodelanalysis != null && !this.idmodelanalysis.equals(other.idmodelanalysis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Modelanalysis[ idmodelanalysis=" + idmodelanalysis + " ]";
    }
    
}
