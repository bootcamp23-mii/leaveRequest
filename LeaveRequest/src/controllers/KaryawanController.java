/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daosBackup.KaryawanDAO;
import java.util.List;
import mainTools.BCrypt;
import models.Karyawan;
import models.StatusNikah;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class KaryawanController implements KaryawanInterface{
    
    private KaryawanDAO kdao;
    public KaryawanController(SessionFactory sessionFactory){
        kdao = new KaryawanDAO(sessionFactory);
    }

    public Object getById(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String register(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        if (kdao.saveOrDelete(new Karyawan(id, nama, jenisKelamin, new Long(jumlahCuti) , email, passwordHash, new StatusNikah(statusNikah), new Karyawan(idManager)), true)) {
            return "Selamat penambahan karyawan berhasil";
        }
        return "Maaf coba lagi";
    }

    @Override
    public void getById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username, String password) {
         List<Karyawan> list = kdao.login(username);
        if (!list.isEmpty()) 
            for (Karyawan karyawan : list) 
                if (BCrypt.checkpw(password, karyawan.getPassword())) 
                    return true;
        return false;
    }
}
