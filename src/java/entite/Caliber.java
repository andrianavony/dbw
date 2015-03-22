/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caliber.findAll", query = "SELECT c FROM Caliber c"),
    @NamedQuery(name = "Caliber.findByIdcaliber", query = "SELECT c FROM Caliber c WHERE c.idcaliber = :idcaliber"),
    @NamedQuery(name = "Caliber.findByCalibername", query = "SELECT c FROM Caliber c WHERE c.calibername = :calibername"),
    @NamedQuery(name = "Caliber.findByDescription", query = "SELECT c FROM Caliber c WHERE c.description = :description")})
public class Caliber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idcaliber;
    @Size(max = 50)
    @Column(length = 50)
    private String calibername;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caliber")
    private List<Calibrationdiagramline> calibrationdiagramlineList;

    public Caliber() {
    }

    public Caliber(String idcaliber) {
        this.idcaliber = idcaliber;
    }

    public String getIdcaliber() {
        return idcaliber;
    }

    public void setIdcaliber(String idcaliber) {
        this.idcaliber = idcaliber;
    }

    public String getCalibername() {
        return calibername;
    }

    public void setCalibername(String calibername) {
        this.calibername = calibername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Calibrationdiagramline> getCalibrationdiagramlineList() {
        return calibrationdiagramlineList;
    }

    public void setCalibrationdiagramlineList(List<Calibrationdiagramline> calibrationdiagramlineList) {
        this.calibrationdiagramlineList = calibrationdiagramlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaliber != null ? idcaliber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caliber)) {
            return false;
        }
        Caliber other = (Caliber) object;
        if ((this.idcaliber == null && other.idcaliber != null) || (this.idcaliber != null && !this.idcaliber.equals(other.idcaliber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Caliber[ idcaliber=" + idcaliber + " ]";
    }
    
}
