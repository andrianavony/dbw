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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Possiblevalues.findAll", query = "SELECT p FROM Possiblevalues p"),
    @NamedQuery(name = "Possiblevalues.findByIdpossiblevalue", query = "SELECT p FROM Possiblevalues p WHERE p.idpossiblevalue = :idpossiblevalue"),
    @NamedQuery(name = "Possiblevalues.findByDescription", query = "SELECT p FROM Possiblevalues p WHERE p.description = :description")})
public class Possiblevalues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idpossiblevalue;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @OneToMany(mappedBy = "idpossiblevalue")
    private List<Methoddetails> methoddetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "possiblevalues")
    private List<Possiblevaluesdetails> possiblevaluesdetailsList;

    public Possiblevalues() {
    }

    public Possiblevalues(Long idpossiblevalue) {
        this.idpossiblevalue = idpossiblevalue;
    }

    public Long getIdpossiblevalue() {
        return idpossiblevalue;
    }

    public void setIdpossiblevalue(Long idpossiblevalue) {
        this.idpossiblevalue = idpossiblevalue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Methoddetails> getMethoddetailsList() {
        return methoddetailsList;
    }

    public void setMethoddetailsList(List<Methoddetails> methoddetailsList) {
        this.methoddetailsList = methoddetailsList;
    }

    @XmlTransient
    public List<Possiblevaluesdetails> getPossiblevaluesdetailsList() {
        return possiblevaluesdetailsList;
    }

    public void setPossiblevaluesdetailsList(List<Possiblevaluesdetails> possiblevaluesdetailsList) {
        this.possiblevaluesdetailsList = possiblevaluesdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpossiblevalue != null ? idpossiblevalue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possiblevalues)) {
            return false;
        }
        Possiblevalues other = (Possiblevalues) object;
        if ((this.idpossiblevalue == null && other.idpossiblevalue != null) || (this.idpossiblevalue != null && !this.idpossiblevalue.equals(other.idpossiblevalue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Possiblevalues[ idpossiblevalue=" + idpossiblevalue + " ]";
    }
    
}
