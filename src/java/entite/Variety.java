/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "variety")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variety.findAll", query = "SELECT v FROM Variety v"),
    @NamedQuery(name = "Variety.findByIdSpecieIdVariety", query = "SELECT v FROM Variety v WHERE v.varietyPK.idspecie = :idspecie and v.varietyPK.idvariety = :idvariety"),
    @NamedQuery(name = "Variety.findByIdvariety", query = "SELECT v FROM Variety v WHERE v.varietyPK.idvariety = :idvariety"),
    @NamedQuery(name = "Variety.findByIdspecie", query = "SELECT v FROM Variety v WHERE v.varietyPK.idspecie = :idspecie"),
    @NamedQuery(name = "Variety.findByDescription", query = "SELECT v FROM Variety v WHERE v.description = :description"),
    @NamedQuery(name = "Variety.findByVarietyname", query = "SELECT v FROM Variety v WHERE v.varietyname = :varietyname"),
    @NamedQuery(name = "Variety.findByOfficialname", query = "SELECT v FROM Variety v WHERE v.officialname = :officialname")})
public class Variety implements Serializable {
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String varietyname;
    @Size(max = 50)
    @Column(length = 50)
    private String officialname;
    @OneToMany(mappedBy = "idvariety")
    private List<Batch> batchList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VarietyPK varietyPK;
    @JoinColumn(name = "IDSPECIE", referencedColumnName = "IDSPECIE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Specie specie;
    @OneToMany(mappedBy = "idvariety")
    private List<Article> articleList;

    public Variety() {
    }

    public Variety(VarietyPK varietyPK) {
        this.varietyPK = varietyPK;
    }

    public Variety(String idvariety, String idspecie) {
        this.varietyPK = new VarietyPK(idvariety, idspecie);
    }

    public VarietyPK getVarietyPK() {
        return varietyPK;
    }

    public void setVarietyPK(VarietyPK varietyPK) {
        this.varietyPK = varietyPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVarietyname() {
        return varietyname;
    }

    public void setVarietyname(String varietyname) {
        this.varietyname = varietyname;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varietyPK != null ? varietyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variety)) {
            return false;
        }
        Variety other = (Variety) object;
        if ((this.varietyPK == null && other.varietyPK != null) || (this.varietyPK != null && !this.varietyPK.equals(other.varietyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Variety[ varietyPK=" + varietyPK + " ]";
    }
    
    public String getIdvariety(){
        return varietyPK.getIdvariety();
    }

        @XmlTransient
    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }
    
}
