/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "PEKERJAAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pekerjaan.findAll", query = "SELECT p FROM Pekerjaan p")
    , @NamedQuery(name = "Pekerjaan.findById", query = "SELECT p FROM Pekerjaan p WHERE p.id = :id")
    , @NamedQuery(name = "Pekerjaan.findByJabatan", query = "SELECT p FROM Pekerjaan p WHERE p.jabatan = :jabatan")})
public class Pekerjaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "JABATAN")
    private String jabatan;
    @OneToMany(mappedBy = "pekerjaan", fetch = FetchType.LAZY)
    private List<Role> roleList;

    public Pekerjaan() {
    }

    public Pekerjaan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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
        if (!(object instanceof Pekerjaan)) {
            return false;
        }
        Pekerjaan other = (Pekerjaan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pekerjaan[ id=" + id + " ]";
    }
    
}
