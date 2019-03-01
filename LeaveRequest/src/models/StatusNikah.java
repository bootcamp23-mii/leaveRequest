/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pandu
 */
@Entity
@Table(name = "STATUS_NIKAH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusNikah.findAll", query = "SELECT s FROM StatusNikah s")
    , @NamedQuery(name = "StatusNikah.findById", query = "SELECT s FROM StatusNikah s WHERE s.id = :id")
    , @NamedQuery(name = "StatusNikah.findByStatus", query = "SELECT s FROM StatusNikah s WHERE s.status = :status")})
public class StatusNikah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "statusnikah", fetch = FetchType.LAZY)
    private Collection<Karyawan> karyawanCollection;

    public StatusNikah() {
    }

    public StatusNikah(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Karyawan> getKaryawanCollection() {
        return karyawanCollection;
    }

    public void setKaryawanCollection(Collection<Karyawan> karyawanCollection) {
        this.karyawanCollection = karyawanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusNikah)) {
            return false;
        }
        StatusNikah other = (StatusNikah) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.StatusNikah[ id=" + id + " ]";
    }
    
}
