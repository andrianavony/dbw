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
public class PossiblevaluesdetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmeasure;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idpossiblevalue;

    public PossiblevaluesdetailsPK() {
    }

    public PossiblevaluesdetailsPK(long idmeasure, long idpossiblevalue) {
        this.idmeasure = idmeasure;
        this.idpossiblevalue = idpossiblevalue;
    }

    public long getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(long idmeasure) {
        this.idmeasure = idmeasure;
    }

    public long getIdpossiblevalue() {
        return idpossiblevalue;
    }

    public void setIdpossiblevalue(long idpossiblevalue) {
        this.idpossiblevalue = idpossiblevalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmeasure;
        hash += (int) idpossiblevalue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossiblevaluesdetailsPK)) {
            return false;
        }
        PossiblevaluesdetailsPK other = (PossiblevaluesdetailsPK) object;
        if (this.idmeasure != other.idmeasure) {
            return false;
        }
        if (this.idpossiblevalue != other.idpossiblevalue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.PossiblevaluesdetailsPK[ idmeasure=" + idmeasure + ", idpossiblevalue=" + idpossiblevalue + " ]";
    }
    
}
