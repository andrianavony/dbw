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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Entity
@Table(name = "generation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generation.findAll", query = "SELECT g FROM Generation g"),
    @NamedQuery(name = "Generation.findByIdgeneration", query = "SELECT g FROM Generation g WHERE g.idgeneration = :idgeneration"),
    @NamedQuery(name = "Generation.findByDescription", query = "SELECT g FROM Generation g WHERE g.description = :description"),
    @NamedQuery(name = "Generation.findByGenerationame", query = "SELECT g FROM Generation g WHERE g.generationame = :generationame")})
public class Generation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String idgeneration;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    @Size(max = 50)
    @Column(length = 50)
    private String generationame;
    @OneToMany(mappedBy = "idgeneration")
    private List<Article> articleList;

    public Generation() {
    }

    public Generation(String idgeneration) {
        this.idgeneration = idgeneration;
    }

    public String getIdgeneration() {
        return idgeneration;
    }

    public void setIdgeneration(String idgeneration) {
        this.idgeneration = idgeneration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenerationame() {
        return generationame;
    }

    public void setGenerationame(String generationame) {
        this.generationame = generationame;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgeneration != null ? idgeneration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generation)) {
            return false;
        }
        Generation other = (Generation) object;
        if ((this.idgeneration == null && other.idgeneration != null) || (this.idgeneration != null && !this.idgeneration.equals(other.idgeneration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Generation[ idgeneration=" + idgeneration + " ]";
    }
    
}
