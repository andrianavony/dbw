/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p"),
    @NamedQuery(name = "Producer.findByProducername", query = "SELECT p FROM Producer p WHERE p.producername = :producername"),
    @NamedQuery(name = "Producer.findByDescription", query = "SELECT p FROM Producer p WHERE p.description = :description")})
public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String producername;
    @Size(max = 50)
    @Column(length = 50)
    private String description;

    public Producer() {
    }

    public Producer(String producername) {
        this.producername = producername;
    }

    public String getProducername() {
        return producername;
    }

    public void setProducername(String producername) {
        this.producername = producername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producername != null ? producername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.producername == null && other.producername != null) || (this.producername != null && !this.producername.equals(other.producername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Producer[ producername=" + producername + " ]";
    }
    
}
