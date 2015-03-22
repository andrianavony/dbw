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
public class MethoddetailsPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private long idmethoddetails;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmethod;

    public MethoddetailsPK() {
    }

    public MethoddetailsPK(long idmethoddetails, long idmethod) {
        this.idmethoddetails = idmethoddetails;
        this.idmethod = idmethod;
    }

    public long getIdmethoddetails() {
        return idmethoddetails;
    }

    public void setIdmethoddetails(long idmethoddetails) {
        this.idmethoddetails = idmethoddetails;
    }

    public long getIdmethod() {
        return idmethod;
    }

    public void setIdmethod(long idmethod) {
        this.idmethod = idmethod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmethoddetails;
        hash += (int) idmethod;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MethoddetailsPK)) {
            return false;
        }
        MethoddetailsPK other = (MethoddetailsPK) object;
        if (this.idmethoddetails != other.idmethoddetails) {
            return false;
        }
        if (this.idmethod != other.idmethod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.MethoddetailsPK[ idmethoddetails=" + idmethoddetails + ", idmethod=" + idmethod + " ]";
    }
    
}
