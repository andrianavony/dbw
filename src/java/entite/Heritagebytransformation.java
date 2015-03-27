/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heritagebytransformation.findAll", query = "SELECT h FROM Heritagebytransformation h"),
    @NamedQuery(name = "Heritagebytransformation.findByIdtransformationdep", query = "SELECT h FROM Heritagebytransformation h WHERE h.heritagebytransformationPK.idtransformationdep = :idtransformationdep"),
    @NamedQuery(name = "Heritagebytransformation.findByIdtransformationarr", query = "SELECT h FROM Heritagebytransformation h WHERE h.heritagebytransformationPK.idtransformationarr = :idtransformationarr"),
    @NamedQuery(name = "Heritagebytransformation.findByIdmodelanalysis", query = "SELECT h FROM Heritagebytransformation h WHERE h.heritagebytransformationPK.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Heritagebytransformation.findByDescription", query = "SELECT h FROM Heritagebytransformation h WHERE h.description = :description")})
public class Heritagebytransformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HeritagebytransformationPK heritagebytransformationPK;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @JoinColumn(name = "IDMODELANALYSIS", referencedColumnName = "IDMODELANALYSIS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modelanalysis modelanalysis;
    @JoinColumn(name = "IDTRANSFORMATIONARR", referencedColumnName = "IDTRANSFORMATION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transformation transformation;
    @JoinColumn(name = "IDTRANSFORMATIONDEP", referencedColumnName = "IDTRANSFORMATION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transformation transformation1;

    public Heritagebytransformation() {
    }

    public Heritagebytransformation(HeritagebytransformationPK heritagebytransformationPK) {
        this.heritagebytransformationPK = heritagebytransformationPK;
    }

    public Heritagebytransformation(long idtransformationdep, long idtransformationarr, long idmodelanalysis) {
        this.heritagebytransformationPK = new HeritagebytransformationPK(idtransformationdep, idtransformationarr, idmodelanalysis);
    }

    public HeritagebytransformationPK getHeritagebytransformationPK() {
        return heritagebytransformationPK;
    }

    public void setHeritagebytransformationPK(HeritagebytransformationPK heritagebytransformationPK) {
        this.heritagebytransformationPK = heritagebytransformationPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Modelanalysis getModelanalysis() {
        return modelanalysis;
    }

    public void setModelanalysis(Modelanalysis modelanalysis) {
        this.modelanalysis = modelanalysis;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public void setTransformation(Transformation transformation) {
        this.transformation = transformation;
    }

    public Transformation getTransformation1() {
        return transformation1;
    }

    public void setTransformation1(Transformation transformation1) {
        this.transformation1 = transformation1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heritagebytransformationPK != null ? heritagebytransformationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heritagebytransformation)) {
            return false;
        }
        Heritagebytransformation other = (Heritagebytransformation) object;
        if ((this.heritagebytransformationPK == null && other.heritagebytransformationPK != null) || (this.heritagebytransformationPK != null && !this.heritagebytransformationPK.equals(other.heritagebytransformationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Heritagebytransformation[ heritagebytransformationPK=" + heritagebytransformationPK + " ]";
    }
    
}
