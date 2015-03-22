/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Calibrationdiagram.findAll", query = "SELECT c FROM Calibrationdiagram c"),
    @NamedQuery(name = "Calibrationdiagram.findByIddiagram", query = "SELECT c FROM Calibrationdiagram c WHERE c.iddiagram = :iddiagram"),
    @NamedQuery(name = "Calibrationdiagram.findByDescription", query = "SELECT c FROM Calibrationdiagram c WHERE c.description = :description")})
public class Calibrationdiagram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String iddiagram;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "iddiagram")
    private List<Wo> woList;

    public Calibrationdiagram() {
    }

    public Calibrationdiagram(String iddiagram) {
        this.iddiagram = iddiagram;
    }

    public String getIddiagram() {
        return iddiagram;
    }

    public void setIddiagram(String iddiagram) {
        this.iddiagram = iddiagram;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Wo> getWoList() {
        return woList;
    }

    public void setWoList(List<Wo> woList) {
        this.woList = woList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiagram != null ? iddiagram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calibrationdiagram)) {
            return false;
        }
        Calibrationdiagram other = (Calibrationdiagram) object;
        if ((this.iddiagram == null && other.iddiagram != null) || (this.iddiagram != null && !this.iddiagram.equals(other.iddiagram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Calibrationdiagram[ iddiagram=" + iddiagram + " ]";
    }
    
}
