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
@Table(name = "KETERANGAN_CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KeteranganCuti.findAll", query = "SELECT k FROM KeteranganCuti k")
    , @NamedQuery(name = "KeteranganCuti.findById", query = "SELECT k FROM KeteranganCuti k WHERE k.id = :id")
    , @NamedQuery(name = "KeteranganCuti.findByKeterangan", query = "SELECT k FROM KeteranganCuti k WHERE k.keterangan = :keterangan")})
public class KeteranganCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @OneToMany(mappedBy = "keterangancuti", fetch = FetchType.LAZY)
    private List<RiwayatCuti> riwayatCutiList;

    public KeteranganCuti() {
    }

    public KeteranganCuti(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public List<RiwayatCuti> getRiwayatCutiList() {
        return riwayatCutiList;
    }

    public void setRiwayatCutiList(List<RiwayatCuti> riwayatCutiList) {
        this.riwayatCutiList = riwayatCutiList;
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
        if (!(object instanceof KeteranganCuti)) {
            return false;
        }
        KeteranganCuti other = (KeteranganCuti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.KeteranganCuti[ id=" + id + " ]";
    }
    
}
