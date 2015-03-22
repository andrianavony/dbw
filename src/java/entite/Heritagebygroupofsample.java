/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heritagebygroupofsample.findAll", query = "SELECT h FROM Heritagebygroupofsample h"),
    @NamedQuery(name = "Heritagebygroupofsample.findByIdgroupofsampleplangroup", query = "SELECT h FROM Heritagebygroupofsample h WHERE h.heritagebygroupofsamplePK.idgroupofsampleplangroup = :idgroupofsampleplangroup"),
    @NamedQuery(name = "Heritagebygroupofsample.findByIdmodelanalysis", query = "SELECT h FROM Heritagebygroupofsample h WHERE h.heritagebygroupofsamplePK.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Heritagebygroupofsample.findByDownupboth", query = "SELECT h FROM Heritagebygroupofsample h WHERE h.heritagebygroupofsamplePK.downupboth = :downupboth"),
    @NamedQuery(name = "Heritagebygroupofsample.findByHeritagebygroupofsamplename", query = "SELECT h FROM Heritagebygroupofsample h WHERE h.heritagebygroupofsamplename = :heritagebygroupofsamplename"),
    @NamedQuery(name = "Heritagebygroupofsample.findByDescription", query = "SELECT h FROM Heritagebygroupofsample h WHERE h.description = :description")})
public class Heritagebygroupofsample implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HeritagebygroupofsamplePK heritagebygroupofsamplePK;
    @Size(max = 50)
    @Column(length = 50)
    private String heritagebygroupofsamplename;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modelanalysis modelanalysis;
    @JoinColumn(name = "IDGROUPOFSAMPLEPLANGROUP", referencedColumnName = "IDGROUPOFSAMPLEPLANGROUP", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Groupofsampleplangroup groupofsampleplangroup;

    public Heritagebygroupofsample() {
    }

    public Heritagebygroupofsample(HeritagebygroupofsamplePK heritagebygroupofsamplePK) {
        this.heritagebygroupofsamplePK = heritagebygroupofsamplePK;
    }

    public Heritagebygroupofsample(long idgroupofsampleplangroup, long idmodelanalysis, short downupboth) {
        this.heritagebygroupofsamplePK = new HeritagebygroupofsamplePK(idgroupofsampleplangroup, idmodelanalysis, downupboth);
    }

    public HeritagebygroupofsamplePK getHeritagebygroupofsamplePK() {
        return heritagebygroupofsamplePK;
    }

    public void setHeritagebygroupofsamplePK(HeritagebygroupofsamplePK heritagebygroupofsamplePK) {
        this.heritagebygroupofsamplePK = heritagebygroupofsamplePK;
    }

    public String getHeritagebygroupofsamplename() {
        return heritagebygroupofsamplename;
    }

    public void setHeritagebygroupofsamplename(String heritagebygroupofsamplename) {
        this.heritagebygroupofsamplename = heritagebygroupofsamplename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Modelanalysis getModelanalysis() {
        return modelanalysis;
    }

    public void setModelanalysis(Modelanalysis modelanalysis) {
        this.modelanalysis = modelanalysis;
    }

    public Groupofsampleplangroup getGroupofsampleplangroup() {
        return groupofsampleplangroup;
    }

    public void setGroupofsampleplangroup(Groupofsampleplangroup groupofsampleplangroup) {
        this.groupofsampleplangroup = groupofsampleplangroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heritagebygroupofsamplePK != null ? heritagebygroupofsamplePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heritagebygroupofsample)) {
            return false;
        }
        Heritagebygroupofsample other = (Heritagebygroupofsample) object;
        if ((this.heritagebygroupofsamplePK == null && other.heritagebygroupofsamplePK != null) || (this.heritagebygroupofsamplePK != null && !this.heritagebygroupofsamplePK.equals(other.heritagebygroupofsamplePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Heritagebygroupofsample[ heritagebygroupofsamplePK=" + heritagebygroupofsamplePK + " ]";
    }
    
}
