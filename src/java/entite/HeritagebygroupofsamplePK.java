/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Embeddable
public class HeritagebygroupofsamplePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idgroupofsampleplangroup;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmodelanalysis;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short downupboth;

    public HeritagebygroupofsamplePK() {
    }

    public HeritagebygroupofsamplePK(long idgroupofsampleplangroup, long idmodelanalysis, short downupboth) {
        this.idgroupofsampleplangroup = idgroupofsampleplangroup;
        this.idmodelanalysis = idmodelanalysis;
        this.downupboth = downupboth;
    }

    public long getIdgroupofsampleplangroup() {
        return idgroupofsampleplangroup;
    }

    public void setIdgroupofsampleplangroup(long idgroupofsampleplangroup) {
        this.idgroupofsampleplangroup = idgroupofsampleplangroup;
    }

    public long getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(long idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public short getDownupboth() {
        return downupboth;
    }

    public void setDownupboth(short downupboth) {
        this.downupboth = downupboth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idgroupofsampleplangroup;
        hash += (int) idmodelanalysis;
        hash += (int) downupboth;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeritagebygroupofsamplePK)) {
            return false;
        }
        HeritagebygroupofsamplePK other = (HeritagebygroupofsamplePK) object;
        if (this.idgroupofsampleplangroup != other.idgroupofsampleplangroup) {
            return false;
        }
        if (this.idmodelanalysis != other.idmodelanalysis) {
            return false;
        }
        if (this.downupboth != other.downupboth) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.HeritagebygroupofsamplePK[ idgroupofsampleplangroup=" + idgroupofsampleplangroup + ", idmodelanalysis=" + idmodelanalysis + ", downupboth=" + downupboth + " ]";
    }
    
}
