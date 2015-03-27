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
public class HeritagebytransformationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idtransformationdep;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idtransformationarr;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmodelanalysis;

    public HeritagebytransformationPK() {
    }

    public HeritagebytransformationPK(long idtransformationdep, long idtransformationarr, long idmodelanalysis) {
        this.idtransformationdep = idtransformationdep;
        this.idtransformationarr = idtransformationarr;
        this.idmodelanalysis = idmodelanalysis;
    }

    public long getIdtransformationdep() {
        return idtransformationdep;
    }

    public void setIdtransformationdep(long idtransformationdep) {
        this.idtransformationdep = idtransformationdep;
    }

    public long getIdtransformationarr() {
        return idtransformationarr;
    }

    public void setIdtransformationarr(long idtransformationarr) {
        this.idtransformationarr = idtransformationarr;
    }

    public long getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(long idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtransformationdep;
        hash += (int) idtransformationarr;
        hash += (int) idmodelanalysis;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeritagebytransformationPK)) {
            return false;
        }
        HeritagebytransformationPK other = (HeritagebytransformationPK) object;
        if (this.idtransformationdep != other.idtransformationdep) {
            return false;
        }
        if (this.idtransformationarr != other.idtransformationarr) {
            return false;
        }
        if (this.idmodelanalysis != other.idmodelanalysis) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.HeritagebytransformationPK[ idtransformationdep=" + idtransformationdep + ", idtransformationarr=" + idtransformationarr + ", idmodelanalysis=" + idmodelanalysis + " ]";
    }
    
}
