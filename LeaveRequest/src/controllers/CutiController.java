/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.Interface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.JenisCuti;
import models.Karyawan;
import models.Pengajuan;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class CutiController implements CutiControllerInterface {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    private final Interface<Pengajuan> cdao;

    public CutiController(SessionFactory sessionFactory) {
        cdao = new GeneralDAO<>(sessionFactory, new Pengajuan());
    }

    @Override
    public String save(String id, String start, String end, String total, String karyawan, String jenisCuti) {
        try {
            if (cdao.saveOrDelete(new Pengajuan(id, sdf.parse(start), sdf.parse(end), new Short(total), new Karyawan(karyawan), new JenisCuti(jenisCuti)), true)) {
                return "LEAVE REQUEST INPUTED";
            } else {
                return "FAILED INPUT LEAVE REQUEST";
            }
        } catch (ParseException ex) {
            Logger.getLogger(CutiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAIL";
    }

    @Override
    public String update(String id, String start, String end, String total, String karyawan, String jenisCuti) {
        try {
            if (cdao.saveOrDelete(new Pengajuan(id, sdf.parse(start), sdf.parse(end), new Short(total), new Karyawan(karyawan), new JenisCuti(jenisCuti)), true)) {
                return "DATA UPDATED FOR ID = " + id;
            } else {
                return "UPDATE FAILED";
            }
        } catch (ParseException ex) {
            Logger.getLogger(CutiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAIL";
    }

    @Override
    public String delete(String id) {
        if (cdao.saveOrDelete(new Pengajuan(id), false)) {
            return "RECORD SUCCESSFULLY DELETED";
        } else {
            return "DELETE FAILED";
        }
    }

    @Override
    public Pengajuan getById(String key) {
        return cdao.getById(key);
    }

    @Override
    public List<Pengajuan> getByKaryawan(String key) {
        return cdao.getByKar(key);
    }

    @Override
    public List<Pengajuan> getByIdKaryawan(String key) {
        return cdao.getByKar(key);
    }

    @Override
    public List<Pengajuan> getAll(String key) {
        return cdao.getData("");
    }

    @Override
    public List<Pengajuan> getData(String key) {
        return cdao.getData(key);
    }

}
