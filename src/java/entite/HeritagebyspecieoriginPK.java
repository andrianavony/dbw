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
import javax.validation.constraints.Size;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Embeddable
public class HeritagebyspecieoriginPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idspecie;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idorigin;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idmodelanalysis;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short downupboth;

    public HeritagebyspecieoriginPK() {
    }

    public HeritagebyspecieoriginPK(String idspecie, long idorigin, long idmodelanalysis, short downupboth) {
        this.idspecie = idspecie;
        this.idorigin = idorigin;
        this.idmodelanalysis = idmodelanalysis;
        this.downupboth = downupboth;
    }

    public String getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(String idspecie) {
        this.idspecie = idspecie;
    }

    public long getIdorigin() {
        return idorigin;
    }

    public void setIdorigin(long idorigin) {
        this.idorigin = idorigin;
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
        hash += (idspecie != null ? idspecie.hashCode() : 0);
        hash += (int) idorigin;
        hash += (int) idmodelanalysis;
        hash += (int) downupboth;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeritagebyspecieoriginPK)) {
            return false;
        }
        HeritagebyspecieoriginPK other = (HeritagebyspecieoriginPK) object;
        if ((this.idspecie == null && other.idspecie != null) || (this.idspecie != null && !this.idspecie.equals(other.idspecie))) {
            return false;
        }
        if (this.idorigin != other.idorigin) {
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
        return "entite.HeritagebyspecieoriginPK[ idspecie=" + idspecie + ", idorigin=" + idorigin + ", idmodelanalysis=" + idmodelanalysis + ", downupboth=" + downupboth + " ]";
    }
    
}
