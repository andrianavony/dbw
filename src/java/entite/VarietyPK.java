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
public class VarietyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idvariety;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idspecie;

    public VarietyPK() {
    }

    public VarietyPK(String idvariety, String idspecie) {
        this.idvariety = idvariety;
        this.idspecie = idspecie;
    }

    public String getIdvariety() {
        return idvariety;
    }

    public void setIdvariety(String idvariety) {
        this.idvariety = idvariety;
    }

    public String getIdspecie() {
        return idspecie;
    }

    public void setIdspecie(String idspecie) {
        this.idspecie = idspecie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvariety != null ? idvariety.hashCode() : 0);
        hash += (idspecie != null ? idspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VarietyPK)) {
            return false;
        }
        VarietyPK other = (VarietyPK) object;
        if ((this.idvariety == null && other.idvariety != null) || (this.idvariety != null && !this.idvariety.equals(other.idvariety))) {
            return false;
        }
        if ((this.idspecie == null && other.idspecie != null) || (this.idspecie != null && !this.idspecie.equals(other.idspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.VarietyPK[ idvariety=" + idvariety + ", idspecie=" + idspecie + " ]";
    }
    
}
