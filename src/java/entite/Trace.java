/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Trace.findAll", query = "SELECT t FROM Trace t"),
    @NamedQuery(name = "Trace.findByIdtrace", query = "SELECT t FROM Trace t WHERE t.idtrace = :idtrace"),
    @NamedQuery(name = "Trace.findByTracetype", query = "SELECT t FROM Trace t WHERE t.tracetype = :tracetype"),
    @NamedQuery(name = "Trace.findByQuantity", query = "SELECT t FROM Trace t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "Trace.findByUnits", query = "SELECT t FROM Trace t WHERE t.units = :units"),
    @NamedQuery(name = "Trace_1.findByDescription", query = "SELECT t FROM Trace t WHERE t.description = :description"),
    @NamedQuery(name = "Trace_1.findByWarehouse", query = "SELECT t FROM Trace t WHERE t.warehouse = :warehouse")})
public class Trace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idtrace;
    @Size(max = 50)
    @Column(length = 50)
    private String tracetype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double quantity;
    @Size(max = 50)
    @Column(length = 50)
    private String units;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE")
    @ManyToOne
    private Article idarticle;
    @JoinColumn(name = "IDARTICLE", referencedColumnName = "IDARTICLE", insertable = false, updatable = false)
    @ManyToOne
    private Batch idarticle1;
    @JoinColumn(name = "BATCHNAME", referencedColumnName = "BATCHNAME")
    @ManyToOne
    private Batch batchname;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn(name = "IDWO", referencedColumnName = "IDWO"),
        @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = true, updatable = true)    
    })
    private Wo idwo;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = false, updatable = false)
    @ManyToOne
    private Company idcompany;

    @Size(max = 50)
    @Column(length = 50)
    private String warehouse;
    
    public Trace() {
    }

    public Trace(Long idtrace) {
        this.idtrace = idtrace;
    }

    public Long getIdtrace() {
        return idtrace;
    }

    public void setIdtrace(Long idtrace) {
        this.idtrace = idtrace;
    }

    public String getTracetype() {
        return tracetype;
    }

    public void setTracetype(String tracetype) {
        this.tracetype = tracetype;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public Batch getIdarticle1() {
        return idarticle1;
    }

    public void setIdarticle1(Batch idarticle1) {
        this.idarticle1 = idarticle1;
    }

    public Batch getBatchname() {
        return batchname;
    }

    public void setBatchname(Batch batchname) {
        this.batchname = batchname;
    }

    public Wo getIdwo() {
        return idwo;
    }

    public void setIdwo(Wo idwo) {
        this.idwo = idwo;
    }

    public Company getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Company idcompany) {
        this.idcompany = idcompany;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrace != null ? idtrace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trace)) {
            return false;
        }
        Trace other = (Trace) object;
        if ((this.idtrace == null && other.idtrace != null) || (this.idtrace != null && !this.idtrace.equals(other.idtrace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Trace[ idtrace=" + idtrace + " ]";
    }
    
}
