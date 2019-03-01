/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pandu
 */
@Entity
@Table(name = "PENGAJUAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengajuan.findAll", query = "SELECT p FROM Pengajuan p")
    , @NamedQuery(name = "Pengajuan.findById", query = "SELECT p FROM Pengajuan p WHERE p.id = :id")
    , @NamedQuery(name = "Pengajuan.findByTanggalmulai", query = "SELECT p FROM Pengajuan p WHERE p.tanggalmulai = :tanggalmulai")
    , @NamedQuery(name = "Pengajuan.findByTanggalakhir", query = "SELECT p FROM Pengajuan p WHERE p.tanggalakhir = :tanggalakhir")
    , @NamedQuery(name = "Pengajuan.findByJumlah", query = "SELECT p FROM Pengajuan p WHERE p.jumlah = :jumlah")})
public class Pengajuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "TANGGALMULAI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalmulai;
    @Column(name = "TANGGALAKHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalakhir;
    @Column(name = "JUMLAH")
    private Short jumlah;
    @JoinColumn(name = "JENISCUTI", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private JenisCuti jeniscuti;
    @JoinColumn(name = "KARYAWAN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Karyawan karyawan;
    @OneToMany(mappedBy = "pengajuan", fetch = FetchType.LAZY)
    private Collection<StatusPengajuan> statusPengajuanCollection;

    public Pengajuan() {
    }

    public Pengajuan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTanggalmulai() {
        return tanggalmulai;
    }

    public void setTanggalmulai(Date tanggalmulai) {
        this.tanggalmulai = tanggalmulai;
    }

    public Date getTanggalakhir() {
        return tanggalakhir;
    }

    public void setTanggalakhir(Date tanggalakhir) {
        this.tanggalakhir = tanggalakhir;
    }

    public Short getJumlah() {
        return jumlah;
    }

    public void setJumlah(Short jumlah) {
        this.jumlah = jumlah;
    }

    public JenisCuti getJeniscuti() {
        return jeniscuti;
    }

    public void setJeniscuti(JenisCuti jeniscuti) {
        this.jeniscuti = jeniscuti;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    @XmlTransient
    public Collection<StatusPengajuan> getStatusPengajuanCollection() {
        return statusPengajuanCollection;
    }

    public void setStatusPengajuanCollection(Collection<StatusPengajuan> statusPengajuanCollection) {
        this.statusPengajuanCollection = statusPengajuanCollection;
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
        if (!(object instanceof Pengajuan)) {
            return false;
        }
        Pengajuan other = (Pengajuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pengajuan[ id=" + id + " ]";
    }
    
}
