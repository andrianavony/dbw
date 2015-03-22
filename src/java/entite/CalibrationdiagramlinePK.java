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
public class CalibrationdiagramlinePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String iddiagram;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idcaliber;

    public CalibrationdiagramlinePK() {
    }

    public CalibrationdiagramlinePK(String iddiagram, String idcaliber) {
        this.iddiagram = iddiagram;
        this.idcaliber = idcaliber;
    }

    public String getIddiagram() {
        return iddiagram;
    }

    public void setIddiagram(String iddiagram) {
        this.iddiagram = iddiagram;
    }

    public String getIdcaliber() {
        return idcaliber;
    }

    public void setIdcaliber(String idcaliber) {
        this.idcaliber = idcaliber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiagram != null ? iddiagram.hashCode() : 0);
        hash += (idcaliber != null ? idcaliber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalibrationdiagramlinePK)) {
            return false;
        }
        CalibrationdiagramlinePK other = (CalibrationdiagramlinePK) object;
        if ((this.iddiagram == null && other.iddiagram != null) || (this.iddiagram != null && !this.iddiagram.equals(other.iddiagram))) {
            return false;
        }
        if ((this.idcaliber == null && other.idcaliber != null) || (this.idcaliber != null && !this.idcaliber.equals(other.idcaliber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.CalibrationdiagramlinePK[ iddiagram=" + iddiagram + ", idcaliber=" + idcaliber + " ]";
    }
    
}
