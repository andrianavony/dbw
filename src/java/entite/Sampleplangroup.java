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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Sampleplangroup.findAll", query = "SELECT s FROM Sampleplangroup s"),
    @NamedQuery(name = "Sampleplangroup.findByIdsampleplangroup", query = "SELECT s FROM Sampleplangroup s WHERE s.idsampleplangroup = :idsampleplangroup"),
    @NamedQuery(name = "Sampleplangroup.findBySampleplangroupname", query = "SELECT s FROM Sampleplangroup s WHERE s.sampleplangroupname = :sampleplangroupname"),
    @NamedQuery(name = "Sampleplangroup.findByDescription", query = "SELECT s FROM Sampleplangroup s WHERE s.description = :description")})
public class Sampleplangroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idsampleplangroup;
    @Size(max = 50)
    @Column(length = 50)
    private String sampleplangroupname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "idsampleplangroup")
    private List<Sampleplan> sampleplanList;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDGROUPOFSAMPLEPLANGROUP", referencedColumnName = "IDGROUPOFSAMPLEPLANGROUP")
    @ManyToOne
    private Groupofsampleplangroup idgroupofsampleplangroup;

    public Sampleplangroup() {
    }

    public Sampleplangroup(Long idsampleplangroup) {
        this.idsampleplangroup = idsampleplangroup;
    }

    public Long getIdsampleplangroup() {
        return idsampleplangroup;
    }

    public void setIdsampleplangroup(Long idsampleplangroup) {
        this.idsampleplangroup = idsampleplangroup;
    }

    public String getSampleplangroupname() {
        return sampleplangroupname;
    }

    public void setSampleplangroupname(String sampleplangroupname) {
        this.sampleplangroupname = sampleplangroupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Sampleplan> getSampleplanList() {
        return sampleplanList;
    }

    public void setSampleplanList(List<Sampleplan> sampleplanList) {
        this.sampleplanList = sampleplanList;
    }

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public Groupofsampleplangroup getIdgroupofsampleplangroup() {
        return idgroupofsampleplangroup;
    }

    public void setIdgroupofsampleplangroup(Groupofsampleplangroup idgroupofsampleplangroup) {
        this.idgroupofsampleplangroup = idgroupofsampleplangroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsampleplangroup != null ? idsampleplangroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sampleplangroup)) {
            return false;
        }
        Sampleplangroup other = (Sampleplangroup) object;
        if ((this.idsampleplangroup == null && other.idsampleplangroup != null) || (this.idsampleplangroup != null && !this.idsampleplangroup.equals(other.idsampleplangroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Sampleplangroup[ idsampleplangroup=" + idsampleplangroup + " ]";
    }
    
}
