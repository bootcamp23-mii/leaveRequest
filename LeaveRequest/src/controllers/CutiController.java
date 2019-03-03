/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CutiDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.JenisCuti;
import models.Karyawan;
import models.Pengajuan;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class CutiController {

    private CutiDAO cdao;

    public CutiController(SessionFactory sessionFactory) {
        cdao = new CutiDAO(sessionFactory);
    }
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    public String insert(String id, String start, String end, String total, String karyawan, String jenisCuti) throws ParseException {
        if (cdao.saveordelete(new Pengajuan(id, sdf.parse(start), sdf.parse(end), new Short(total), new Karyawan(karyawan), new JenisCuti(jenisCuti)), true)) {
            return "LEAVE REQUEST INPUTED";
        } else {
            return "FAILED INPUT LEAVE REQUEST";
        }
    }

    public String update(String id, String start, String end, String total, String karyawan, String jenisCuti) throws ParseException {
        if (cdao.saveordelete(new Pengajuan(id, sdf.parse(start), sdf.parse(end), new Short(total), new Karyawan(karyawan), new JenisCuti(jenisCuti)), true)) {
            return "DATA UPDATED FOR ID = " + id;
        } else {
            return "UPDATE FAILED";
        }
    }

    public String delete(String id) {
        if (cdao.saveordelete(new Pengajuan(id), false))  {
            return "RECORD SUCCESSFULLY DELETED";
        } else {
            return "DELETE FAILED";
        }
    }
    
    public List<Pengajuan> getByID(String key){
        return cdao.getId(key);
    }
    
    public List<Pengajuan> getAll(String key){
        return cdao.getId("");
    }

}
