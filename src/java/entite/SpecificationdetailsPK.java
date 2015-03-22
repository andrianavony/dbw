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
public class SpecificationdetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idspecification;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmeasure;

    public SpecificationdetailsPK() {
    }

    public SpecificationdetailsPK(long idspecification, long idmeasure) {
        this.idspecification = idspecification;
        this.idmeasure = idmeasure;
    }

    public long getIdspecification() {
        return idspecification;
    }

    public void setIdspecification(long idspecification) {
        this.idspecification = idspecification;
    }

    public long getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(long idmeasure) {
        this.idmeasure = idmeasure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idspecification;
        hash += (int) idmeasure;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecificationdetailsPK)) {
            return false;
        }
        SpecificationdetailsPK other = (SpecificationdetailsPK) object;
        if (this.idspecification != other.idspecification) {
            return false;
        }
        if (this.idmeasure != other.idmeasure) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.SpecificationdetailsPK[ idspecification=" + idspecification + ", idmeasure=" + idmeasure + " ]";
    }
    
}
