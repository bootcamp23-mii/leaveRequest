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
import models.KeteranganCuti;
import models.Pengajuan;
import models.Status;
import models.StatusPengajuan;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class StatusPengajuanController implements StatusPengajuanInterface {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    private final Interface<StatusPengajuan> spdao;

    public StatusPengajuanController(SessionFactory sessionFactory) {
        spdao = new GeneralDAO<>(sessionFactory, new StatusPengajuan());
    }

    @Override
    public List<StatusPengajuan> getHistory(String id, Boolean isS1) {
        return spdao.getHistory(id, isS1);
    }
    
    @Override
    public List<StatusPengajuan> getHistoryByMang(String id, Boolean isS1) {
        return spdao.getHistoryByMang(id, isS1);
    }

    @Override
    public List<StatusPengajuan> getAll(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatusPengajuan> getData(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String date, String keterangan, String pengajuan, String status) {
    try {
            if (spdao.insertOrUpdate(new StatusPengajuan(id, sdf.parse(date), keterangan, new Pengajuan(pengajuan), new Status(status)), true)) {
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
    public String update(String id, String date, String keterangan, String pengajuan, String status) {
    try {
            if (spdao.insertOrUpdate(new StatusPengajuan(id, sdf.parse(date), keterangan, new Pengajuan(pengajuan), new Status(status)), false)) {
                return "DATA UPDATED FOR ID = " + id;
            } else {
                return "UPDATE FAILED";
            }
        } catch (ParseException ex) {
            Logger.getLogger(CutiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAIL";
    }
    
}
