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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "KARYAWAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findById", query = "SELECT k FROM Karyawan k WHERE k.id = :id")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByJeniskelamin", query = "SELECT k FROM Karyawan k WHERE k.jeniskelamin = :jeniskelamin")
    , @NamedQuery(name = "Karyawan.findByJumlahcuti", query = "SELECT k FROM Karyawan k WHERE k.jumlahcuti = :jumlahcuti")
    , @NamedQuery(name = "Karyawan.findByEmail", query = "SELECT k FROM Karyawan k WHERE k.email = :email")
    , @NamedQuery(name = "Karyawan.findByPassword", query = "SELECT k FROM Karyawan k WHERE k.password = :password")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JENISKELAMIN")
    private String jeniskelamin;
    @Column(name = "JUMLAHCUTI")
    private Long jumlahcuti;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY)
    private Collection<Role> roleCollection;
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY)
    private Collection<Pengajuan> pengajuanCollection;
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY)
    private Collection<RiwayatCuti> riwayatCutiCollection;
    @OneToMany(mappedBy = "idmanager", fetch = FetchType.LAZY)
    private Collection<Karyawan> karyawanCollection;
    @JoinColumn(name = "IDMANAGER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Karyawan idmanager;
    @JoinColumn(name = "STATUSNIKAH", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusNikah statusnikah;

    public Karyawan() {
    }

    public Karyawan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public Long getJumlahcuti() {
        return jumlahcuti;
    }

    public void setJumlahcuti(Long jumlahcuti) {
        this.jumlahcuti = jumlahcuti;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Pengajuan> getPengajuanCollection() {
        return pengajuanCollection;
    }

    public void setPengajuanCollection(Collection<Pengajuan> pengajuanCollection) {
        this.pengajuanCollection = pengajuanCollection;
    }

    @XmlTransient
    public Collection<RiwayatCuti> getRiwayatCutiCollection() {
        return riwayatCutiCollection;
    }

    public void setRiwayatCutiCollection(Collection<RiwayatCuti> riwayatCutiCollection) {
        this.riwayatCutiCollection = riwayatCutiCollection;
    }

    @XmlTransient
    public Collection<Karyawan> getKaryawanCollection() {
        return karyawanCollection;
    }

    public void setKaryawanCollection(Collection<Karyawan> karyawanCollection) {
        this.karyawanCollection = karyawanCollection;
    }

    public Karyawan getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(Karyawan idmanager) {
        this.idmanager = idmanager;
    }

    public StatusNikah getStatusnikah() {
        return statusnikah;
    }

    public void setStatusnikah(StatusNikah statusnikah) {
        this.statusnikah = statusnikah;
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Karyawan[ id=" + id + " ]";
    }
    
}
