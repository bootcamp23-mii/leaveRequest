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
@Table(name = "STATUS_PENGAJUAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusPengajuan.findAll", query = "SELECT s FROM StatusPengajuan s")
    , @NamedQuery(name = "StatusPengajuan.findById", query = "SELECT s FROM StatusPengajuan s WHERE s.id = :id")
    , @NamedQuery(name = "StatusPengajuan.findByDatetime", query = "SELECT s FROM StatusPengajuan s WHERE s.datetime = :datetime")
    , @NamedQuery(name = "StatusPengajuan.findByKeterangan", query = "SELECT s FROM StatusPengajuan s WHERE s.keterangan = :keterangan")})
public class StatusPengajuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @JoinColumn(name = "PENGAJUAN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pengajuan pengajuan;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    public StatusPengajuan() {
    }

    public StatusPengajuan(String id) {
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Pengajuan getPengajuan() {
        return pengajuan;
    }

    public void setPengajuan(Pengajuan pengajuan) {
        this.pengajuan = pengajuan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        if (!(object instanceof StatusPengajuan)) {
            return false;
        }
        StatusPengajuan other = (StatusPengajuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.StatusPengajuan[ id=" + id + " ]";
    }
    
}
