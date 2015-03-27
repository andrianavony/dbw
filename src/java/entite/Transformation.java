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
    @NamedQuery(name = "Transformation.findAll", query = "SELECT t FROM Transformation t"),
    @NamedQuery(name = "Transformation.findByIdtransformation", query = "SELECT t FROM Transformation t WHERE t.idtransformation = :idtransformation"),
    @NamedQuery(name = "Transformation.findByDescription", query = "SELECT t FROM Transformation t WHERE t.description = :description"),
    @NamedQuery(name = "Transformation.findByTransformationlabel", query = "SELECT t FROM Transformation t WHERE t.transformationlabel = :transformationlabel")})
public class Transformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idtransformation;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Integer transformationlabel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transformation")
    private List<Heritagebytransformation> heritagebytransformationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transformation1")
    private List<Heritagebytransformation> heritagebytransformationList1;

    public Transformation() {
    }

    public Transformation(Long idtransformation) {
        this.idtransformation = idtransformation;
    }

    public Long getIdtransformation() {
        return idtransformation;
    }

    public void setIdtransformation(Long idtransformation) {
        this.idtransformation = idtransformation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTransformationlabel() {
        return transformationlabel;
    }

    public void setTransformationlabel(Integer transformationlabel) {
        this.transformationlabel = transformationlabel;
    }

    @XmlTransient
    public List<Heritagebytransformation> getHeritagebytransformationList() {
        return heritagebytransformationList;
    }

    public void setHeritagebytransformationList(List<Heritagebytransformation> heritagebytransformationList) {
        this.heritagebytransformationList = heritagebytransformationList;
    }

    @XmlTransient
    public List<Heritagebytransformation> getHeritagebytransformationList1() {
        return heritagebytransformationList1;
    }

    public void setHeritagebytransformationList1(List<Heritagebytransformation> heritagebytransformationList1) {
        this.heritagebytransformationList1 = heritagebytransformationList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransformation != null ? idtransformation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transformation)) {
            return false;
        }
        Transformation other = (Transformation) object;
        if ((this.idtransformation == null && other.idtransformation != null) || (this.idtransformation != null && !this.idtransformation.equals(other.idtransformation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Transformation[ idtransformation=" + idtransformation + " ]";
    }
    
}
