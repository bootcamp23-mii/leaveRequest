/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.Interface;
import java.util.List;
import mainTools.BCrypt;
import models.Karyawan;
import models.Pekerjaan;
import models.Session;
import models.StatusNikah;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class KaryawanController implements KaryawanInterface {

//    private KaryawanDAO kdao;
    private Interface<Karyawan> kdao;

    public KaryawanController(SessionFactory sessionFactory) {
        kdao = new GeneralDAO<>(sessionFactory, new Karyawan());
    }

    @Override
    public String register(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager, String jobs) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        if (kdao.saveOrDelete(new Karyawan(id, nama, jenisKelamin, new Long(jumlahCuti), email, passwordHash, new StatusNikah(statusNikah), new Karyawan(idManager), new Pekerjaan(jobs)), true)) {
            return "Selamat penambahan karyawan berhasil";
        }
        return "Maaf coba lagi";
    }

    @Override
    public boolean login(String username, String password) {
        List<Karyawan> list = kdao.login(username);
        if (!list.isEmpty()) {
            for (Karyawan karyawan : list) {
                Session.setId(karyawan.getId());
                if (BCrypt.checkpw(password, karyawan.getPassword())) {
                    return true;
                }
            }
        }
        System.out.println("List kosong");
        return false;
    }

    @Override
    public String update(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager, String jobs) {
        if (kdao.saveOrDelete(new Karyawan(id, nama, jenisKelamin, Long.valueOf(jumlahCuti), email, password, new StatusNikah(statusNikah), new Karyawan(idManager), new Pekerjaan(jobs)), true)) {
            return "SUCCESSFULLY UPDATE YOUR DATA";
        }
        return "FAIL TO UPDATE";
    }
    
    @Override
    public String literallyUpdate(String id, String jumlahCuti) {
        if (kdao.saveOrDelete(new Karyawan(id, Long.valueOf(jumlahCuti)), true)) {
            return "SUCCESSFULLY UPDATE YOUR DATA";
        }
        return "FAIL TO UPDATE";
    }

    @Override
    public Karyawan getById(String key) {
        return kdao.getById(key);
    }

    @Override
    public List<Karyawan> getAll(String key) {
        return kdao.getData(key);
    }

    @Override
    public String delete(String key) {
        if (kdao.saveOrDelete(new Karyawan(key), false)) {
            return "RECORD SUCCESSFULLY DELETED";
        } else {
            return "DELETE FAILED";
        }
    }

    @Override
    public List<Karyawan> getAll() {
        return kdao.getData("");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Karyawan> getKar(String key) {
        return kdao.getByKar(key);
    }

    @Override
    public List<Karyawan> getByJob(String key) {
        return kdao.getKarType(key);
    }

    @Override
    public List<Karyawan> getIdKar(String key) {
        return kdao.getByIdKar(key);
    }

    @Override
    public List<Karyawan> getKarByMang(String key) {
        return kdao.getByKarByMang(key);
    }

}
