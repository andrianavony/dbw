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
public class WoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idcompany;

    public WoPK() {
    }

    public WoPK(String idwo, String idcompany) {
        this.idwo = idwo;
        this.idcompany = idcompany;
    }

    public String getIdwo() {
        return idwo;
    }

    public void setIdwo(String idwo) {
        this.idwo = idwo;
    }

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwo != null ? idwo.hashCode() : 0);
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WoPK)) {
            return false;
        }
        WoPK other = (WoPK) object;
        if ((this.idwo == null && other.idwo != null) || (this.idwo != null && !this.idwo.equals(other.idwo))) {
            return false;
        }
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.WoPK[ idwo=" + idwo + ", idcompany=" + idcompany + " ]";
    }
    
}
