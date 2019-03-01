/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pandu
 */
@Entity
@Table(name = "RIWAYAT_CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RiwayatCuti.findAll", query = "SELECT r FROM RiwayatCuti r")
    , @NamedQuery(name = "RiwayatCuti.findById", query = "SELECT r FROM RiwayatCuti r WHERE r.id = :id")
    , @NamedQuery(name = "RiwayatCuti.findByDatetime", query = "SELECT r FROM RiwayatCuti r WHERE r.datetime = :datetime")
    , @NamedQuery(name = "RiwayatCuti.findByJumlah", query = "SELECT r FROM RiwayatCuti r WHERE r.jumlah = :jumlah")})
public class RiwayatCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "JUMLAH")
    private Short jumlah;
    @JoinColumn(name = "KARYAWAN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Karyawan karyawan;
    @JoinColumn(name = "KETERANGANCUTI", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private KeteranganCuti keterangancuti;

    public RiwayatCuti() {
    }

    public RiwayatCuti(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Short getJumlah() {
        return jumlah;
    }

    public void setJumlah(Short jumlah) {
        this.jumlah = jumlah;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public KeteranganCuti getKeterangancuti() {
        return keterangancuti;
    }

    public void setKeterangancuti(KeteranganCuti keterangancuti) {
        this.keterangancuti = keterangancuti;
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
        if (!(object instanceof RiwayatCuti)) {
            return false;
        }
        RiwayatCuti other = (RiwayatCuti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RiwayatCuti[ id=" + id + " ]";
    }
    
}
