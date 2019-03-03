/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import daos.KaryawanDAO;
import java.util.List;
import mainTools.BCrypt;
import models.Karyawan;
import org.hibernate.SessionFactory;

/**
 *
 * @author Panji Sadewo
 */
public class KaryawanController {
    
    private KaryawanDAO kdao;
    public KaryawanController(SessionFactory sessionFactory){
        kdao = new KaryawanDAO(sessionFactory);
    }
    
    public boolean login(String username, String password){
        List<Karyawan> list = kdao.login(username);
        if (!list.isEmpty()) 
            for (Karyawan karyawan : list) 
                if (BCrypt.checkpw(password, karyawan.getPassword())) 
                    return true;
        return false;
    }

    public Object getById(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
