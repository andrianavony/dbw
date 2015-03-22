/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Possiblevaluesdetails.findAll", query = "SELECT p FROM Possiblevaluesdetails p"),
    @NamedQuery(name = "Possiblevaluesdetails.findByIdmeasure", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.possiblevaluesdetailsPK.idmeasure = :idmeasure"),
    @NamedQuery(name = "Possiblevaluesdetails.findByIdpossiblevalue", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.possiblevaluesdetailsPK.idpossiblevalue = :idpossiblevalue"),
    @NamedQuery(name = "Possiblevaluesdetails.findByRawresults", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.rawresults = :rawresults"),
    @NamedQuery(name = "Possiblevaluesdetails.findByPossiblevaluename", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.possiblevaluename = :possiblevaluename"),
    @NamedQuery(name = "Possiblevaluesdetails.findByDescription", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.description = :description"),
    @NamedQuery(name = "Possiblevaluesdetails.findByDefaultstatus", query = "SELECT p FROM Possiblevaluesdetails p WHERE p.defaultstatus = :defaultstatus")})
public class Possiblevaluesdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossiblevaluesdetailsPK possiblevaluesdetailsPK;
    @Size(max = 50)
    @Column(length = 50)
    private String rawresults;
    @Size(max = 50)
    @Column(length = 50)
    private String possiblevaluename;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Short defaultstatus;
    @OneToMany(mappedBy = "idpossiblevalue")
    private List<Measures> measuresList;
    @JoinColumn(name = "IDMEASURE", referencedColumnName = "IDMEASURE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Measures measures;
    @JoinColumn(name = "IDPOSSIBLEVALUE", referencedColumnName = "IDPOSSIBLEVALUE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Possiblevalues possiblevalues;

    public Possiblevaluesdetails() {
    }

    public Possiblevaluesdetails(PossiblevaluesdetailsPK possiblevaluesdetailsPK) {
        this.possiblevaluesdetailsPK = possiblevaluesdetailsPK;
    }

    public Possiblevaluesdetails(long idmeasure, long idpossiblevalue) {
        this.possiblevaluesdetailsPK = new PossiblevaluesdetailsPK(idmeasure, idpossiblevalue);
    }

    public PossiblevaluesdetailsPK getPossiblevaluesdetailsPK() {
        return possiblevaluesdetailsPK;
    }

    public void setPossiblevaluesdetailsPK(PossiblevaluesdetailsPK possiblevaluesdetailsPK) {
        this.possiblevaluesdetailsPK = possiblevaluesdetailsPK;
    }

    public String getRawresults() {
        return rawresults;
    }

    public void setRawresults(String rawresults) {
        this.rawresults = rawresults;
    }

    public String getPossiblevaluename() {
        return possiblevaluename;
    }

    public void setPossiblevaluename(String possiblevaluename) {
        this.possiblevaluename = possiblevaluename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getDefaultstatus() {
        return defaultstatus;
    }

    public void setDefaultstatus(Short defaultstatus) {
        this.defaultstatus = defaultstatus;
    }

    @XmlTransient
    public List<Measures> getMeasuresList() {
        return measuresList;
    }

    public void setMeasuresList(List<Measures> measuresList) {
        this.measuresList = measuresList;
    }

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public Possiblevalues getPossiblevalues() {
        return possiblevalues;
    }

    public void setPossiblevalues(Possiblevalues possiblevalues) {
        this.possiblevalues = possiblevalues;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possiblevaluesdetailsPK != null ? possiblevaluesdetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possiblevaluesdetails)) {
            return false;
        }
        Possiblevaluesdetails other = (Possiblevaluesdetails) object;
        if ((this.possiblevaluesdetailsPK == null && other.possiblevaluesdetailsPK != null) || (this.possiblevaluesdetailsPK != null && !this.possiblevaluesdetailsPK.equals(other.possiblevaluesdetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Possiblevaluesdetails[ possiblevaluesdetailsPK=" + possiblevaluesdetailsPK + " ]";
    }
    
}
