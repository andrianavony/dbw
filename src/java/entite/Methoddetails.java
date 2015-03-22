/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigInteger;
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
    @NamedQuery(name = "Methoddetails.findAll", query = "SELECT m FROM Methoddetails m"),
    @NamedQuery(name = "Methoddetails.findByIdmethoddetails", query = "SELECT m FROM Methoddetails m WHERE m.methoddetailsPK.idmethoddetails = :idmethoddetails"),
    @NamedQuery(name = "Methoddetails.findByIdmethod", query = "SELECT m FROM Methoddetails m WHERE m.methoddetailsPK.idmethod = :idmethod"),
    @NamedQuery(name = "Methoddetails.findByDescription", query = "SELECT m FROM Methoddetails m WHERE m.description = :description"),
    @NamedQuery(name = "Methoddetails.findByDeleted", query = "SELECT m FROM Methoddetails m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "Methoddetails.findByMaingroup", query = "SELECT m FROM Methoddetails m WHERE m.maingroup = :maingroup"),
    @NamedQuery(name = "Methoddetails.findBySubgroup", query = "SELECT m FROM Methoddetails m WHERE m.subgroup = :subgroup"),
    @NamedQuery(name = "Methoddetails.findByIdmodelanalysis", query = "SELECT m FROM Methoddetails m WHERE m.idmodelanalysis = :idmodelanalysis"),
    @NamedQuery(name = "Methoddetails.findByMeasuremaster", query = "SELECT m FROM Methoddetails m WHERE m.measuremaster = :measuremaster"),
    @NamedQuery(name = "Methoddetails.findByIsresults", query = "SELECT m FROM Methoddetails m WHERE m.isresults = :isresults"),
    @NamedQuery(name = "Methoddetails.findByIsrequired", query = "SELECT m FROM Methoddetails m WHERE m.isrequired = :isrequired"),
    @NamedQuery(name = "Methoddetails.findByDefaultvalue", query = "SELECT m FROM Methoddetails m WHERE m.defaultvalue = :defaultvalue"),
    @NamedQuery(name = "Methoddetails.findByIsvirtual", query = "SELECT m FROM Methoddetails m WHERE m.isvirtual = :isvirtual"),
    @NamedQuery(name = "Methoddetails.findByMeasurevalue", query = "SELECT m FROM Methoddetails m WHERE m.measurevalue = :measurevalue"),
    @NamedQuery(name = "Methoddetails.findByValuemin", query = "SELECT m FROM Methoddetails m WHERE m.valuemin = :valuemin"),
    @NamedQuery(name = "Methoddetails.findByValuemax", query = "SELECT m FROM Methoddetails m WHERE m.valuemax = :valuemax"),
    @NamedQuery(name = "Methoddetails.findByValid", query = "SELECT m FROM Methoddetails m WHERE m.valid = :valid"),
    @NamedQuery(name = "Methoddetails.findByRepetition", query = "SELECT m FROM Methoddetails m WHERE m.repetition = :repetition"),
    @NamedQuery(name = "Methoddetails.findBySubrepetition", query = "SELECT m FROM Methoddetails m WHERE m.subrepetition = :subrepetition")})
public class Methoddetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MethoddetailsPK methoddetailsPK;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Boolean deleted;
    @Size(max = 50)
    @Column(length = 50)
    private String maingroup;
    @Size(max = 50)
    @Column(length = 50)
    private String subgroup;
    private BigInteger idmodelanalysis;
    @Size(max = 50)
    @Column(length = 50)
    private String measuremaster;
    private Boolean isresults;
    private Boolean isrequired;
    @Size(max = 50)
    @Column(length = 50)
    private String defaultvalue;
    private Boolean isvirtual;
    @Size(max = 50)
    @Column(length = 50)
    private String measurevalue;
    @Size(max = 50)
    @Column(length = 50)
    private String valuemin;
    @Size(max = 50)
    @Column(length = 50)
    private String valuemax;
    private Boolean valid;
    private Short repetition;
    private Short subrepetition;
    @JoinColumn(name = "IDMEASURE", referencedColumnName = "IDMEASURE")
    @ManyToOne
    private Measures idmeasure;
    @JoinColumn(name = "IDMETHOD", referencedColumnName = "IDMETHOD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Method method;
    @JoinColumn(name = "IDSUBMETHOD", referencedColumnName = "IDMETHOD")
    @ManyToOne
    private Method idsubmethod;
    @JoinColumn(name = "IDPOSSIBLEVALUE", referencedColumnName = "IDPOSSIBLEVALUE")
    @ManyToOne
    private Possiblevalues idpossiblevalue;

    public Methoddetails() {
    }

    public Methoddetails(MethoddetailsPK methoddetailsPK) {
        this.methoddetailsPK = methoddetailsPK;
    }

    public Methoddetails(long idmethoddetails, long idmethod) {
        this.methoddetailsPK = new MethoddetailsPK(idmethoddetails, idmethod);
    }

    public MethoddetailsPK getMethoddetailsPK() {
        return methoddetailsPK;
    }

    public void setMethoddetailsPK(MethoddetailsPK methoddetailsPK) {
        this.methoddetailsPK = methoddetailsPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getMaingroup() {
        return maingroup;
    }

    public void setMaingroup(String maingroup) {
        this.maingroup = maingroup;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public BigInteger getIdmodelanalysis() {
        return idmodelanalysis;
    }

    public void setIdmodelanalysis(BigInteger idmodelanalysis) {
        this.idmodelanalysis = idmodelanalysis;
    }

    public String getMeasuremaster() {
        return measuremaster;
    }

    public void setMeasuremaster(String measuremaster) {
        this.measuremaster = measuremaster;
    }

    public Boolean getIsresults() {
        return isresults;
    }

    public void setIsresults(Boolean isresults) {
        this.isresults = isresults;
    }

    public Boolean getIsrequired() {
        return isrequired;
    }

    public void setIsrequired(Boolean isrequired) {
        this.isrequired = isrequired;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public Boolean getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Boolean isvirtual) {
        this.isvirtual = isvirtual;
    }

    public String getMeasurevalue() {
        return measurevalue;
    }

    public void setMeasurevalue(String measurevalue) {
        this.measurevalue = measurevalue;
    }

    public String getValuemin() {
        return valuemin;
    }

    public void setValuemin(String valuemin) {
        this.valuemin = valuemin;
    }

    public String getValuemax() {
        return valuemax;
    }

    public void setValuemax(String valuemax) {
        this.valuemax = valuemax;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Short getRepetition() {
        return repetition;
    }

    public void setRepetition(Short repetition) {
        this.repetition = repetition;
    }

    public Short getSubrepetition() {
        return subrepetition;
    }

    public void setSubrepetition(Short subrepetition) {
        this.subrepetition = subrepetition;
    }

    public Measures getIdmeasure() {
        return idmeasure;
    }

    public void setIdmeasure(Measures idmeasure) {
        this.idmeasure = idmeasure;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Method getIdsubmethod() {
        return idsubmethod;
    }

    public void setIdsubmethod(Method idsubmethod) {
        this.idsubmethod = idsubmethod;
    }

    public Possiblevalues getIdpossiblevalue() {
        return idpossiblevalue;
    }

    public void setIdpossiblevalue(Possiblevalues idpossiblevalue) {
        this.idpossiblevalue = idpossiblevalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (methoddetailsPK != null ? methoddetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Methoddetails)) {
            return false;
        }
        Methoddetails other = (Methoddetails) object;
        if ((this.methoddetailsPK == null && other.methoddetailsPK != null) || (this.methoddetailsPK != null && !this.methoddetailsPK.equals(other.methoddetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Methoddetails[ methoddetailsPK=" + methoddetailsPK + " ]";
    }
    
}
