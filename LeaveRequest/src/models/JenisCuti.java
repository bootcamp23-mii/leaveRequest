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
@Table(name = "JENIS_CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisCuti.findAll", query = "SELECT j FROM JenisCuti j")
    , @NamedQuery(name = "JenisCuti.findById", query = "SELECT j FROM JenisCuti j WHERE j.id = :id")
    , @NamedQuery(name = "JenisCuti.findByJenis", query = "SELECT j FROM JenisCuti j WHERE j.jenis = :jenis")})
public class JenisCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "JENIS")
    private String jenis;
    @OneToMany(mappedBy = "jeniscuti", fetch = FetchType.LAZY)
    private List<Pengajuan> pengajuanList;

    public JenisCuti() {
    }
    
    public JenisCuti(String id, String jenis) {
        this.id = id;
        this.jenis=jenis;
    }

    public JenisCuti(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @XmlTransient
    public List<Pengajuan> getPengajuanList() {
        return pengajuanList;
    }

    public void setPengajuanList(List<Pengajuan> pengajuanList) {
        this.pengajuanList = pengajuanList;
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
        if (!(object instanceof JenisCuti)) {
            return false;
        }
        JenisCuti other = (JenisCuti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.JenisCuti[ id=" + id + " ]";
    }
    
}
