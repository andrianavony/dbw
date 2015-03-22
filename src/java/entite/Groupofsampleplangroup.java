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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Groupofsampleplangroup.findAll", query = "SELECT g FROM Groupofsampleplangroup g"),
    @NamedQuery(name = "Groupofsampleplangroup.findByIdgroupofsampleplangroup", query = "SELECT g FROM Groupofsampleplangroup g WHERE g.idgroupofsampleplangroup = :idgroupofsampleplangroup"),
    @NamedQuery(name = "Groupofsampleplangroup.findByGroupofsampleplangroupname", query = "SELECT g FROM Groupofsampleplangroup g WHERE g.groupofsampleplangroupname = :groupofsampleplangroupname"),
    @NamedQuery(name = "Groupofsampleplangroup.findByDescription", query = "SELECT g FROM Groupofsampleplangroup g WHERE g.description = :description")})
public class Groupofsampleplangroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long idgroupofsampleplangroup;
    @Size(max = 50)
    @Column(length = 50)
    private String groupofsampleplangroupname;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupofsampleplangroup")
    private List<Heritagebygroupofsample> heritagebygroupofsampleList;
    @OneToMany(mappedBy = "idgroupofsampleplangroup")
    private List<Sampleplangroup> sampleplangroupList;

    public Groupofsampleplangroup() {
    }

    public Groupofsampleplangroup(Long idgroupofsampleplangroup) {
        this.idgroupofsampleplangroup = idgroupofsampleplangroup;
    }

    public Long getIdgroupofsampleplangroup() {
        return idgroupofsampleplangroup;
    }

    public void setIdgroupofsampleplangroup(Long idgroupofsampleplangroup) {
        this.idgroupofsampleplangroup = idgroupofsampleplangroup;
    }

    public String getGroupofsampleplangroupname() {
        return groupofsampleplangroupname;
    }

    public void setGroupofsampleplangroupname(String groupofsampleplangroupname) {
        this.groupofsampleplangroupname = groupofsampleplangroupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Heritagebygroupofsample> getHeritagebygroupofsampleList() {
        return heritagebygroupofsampleList;
    }

    public void setHeritagebygroupofsampleList(List<Heritagebygroupofsample> heritagebygroupofsampleList) {
        this.heritagebygroupofsampleList = heritagebygroupofsampleList;
    }

    @XmlTransient
    public List<Sampleplangroup> getSampleplangroupList() {
        return sampleplangroupList;
    }

    public void setSampleplangroupList(List<Sampleplangroup> sampleplangroupList) {
        this.sampleplangroupList = sampleplangroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroupofsampleplangroup != null ? idgroupofsampleplangroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupofsampleplangroup)) {
            return false;
        }
        Groupofsampleplangroup other = (Groupofsampleplangroup) object;
        if ((this.idgroupofsampleplangroup == null && other.idgroupofsampleplangroup != null) || (this.idgroupofsampleplangroup != null && !this.idgroupofsampleplangroup.equals(other.idgroupofsampleplangroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Groupofsampleplangroup[ idgroupofsampleplangroup=" + idgroupofsampleplangroup + " ]";
    }
    
}
