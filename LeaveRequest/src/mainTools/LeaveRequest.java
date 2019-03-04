/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainTools;

import controllers.CutiController;
import controllers.CutiControllerInterface;
import controllers.JenisCutiController;
import controllers.JenisCutiInterface;
import controllers.KaryawanController;
import controllers.KaryawanInterface;
import daosBackup.CutiDAO;
import java.text.ParseException;
import org.hibernate.SessionFactory;
import mainTools.HibernateUtil;
import models.JenisCuti;
import models.Pengajuan;

/**
 *
 * @author Pandu
 */
public class LeaveRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        CutiControllerInterface cc  = new CutiController(sessionFactory);
        JenisCutiInterface jc       = new JenisCutiController(sessionFactory);
        KaryawanInterface kc        = new KaryawanController(sessionFactory);
//        CutiController cc = new CutiController(sessionFactory);

//        INSERT/UPDATE/DELETE
//        System.out.println(cc.insert("P3", "2018-03-03", "2018-03-04", "1", "11205", "JC1"));
//        System.out.println(cc.getByID("11205"));
//        GET DATA BASED ON KARYAWAN ID
//        for (Pengajuan pengajuan : cc.getByKaryawan("11205")) {
//            System.out.println("==============================");
//            System.out.println("ID      : " + pengajuan.getId());
//            System.out.println("START   : " + pengajuan.getTanggalmulai());
//            System.out.println("END     : " + pengajuan.getTanggalakhir());
//            System.out.println("TOTAL   : " + pengajuan.getJumlah());
//            //I DONT EXACTLY KNOW WHAT'S WRONG WITH THIS LIL SHIT
//            System.out.println("KARYAWAN: " + pengajuan.getKaryawan().getNama());
//            System.out.println("TYPE    : " + pengajuan.getJeniscuti().getJenis());
//        }
//
////        LOGIN
        System.out.println(kc.register("11206", "loli", "Pria", "3", "loli@alo.com", "qdasd", "SN1", "11201"));
//        System.out.println(kc.login("loli", "qdasd"));
//        
//        for (JenisCuti jenisCuti : jc.getAll("")) {
//            System.out.println("===================");
//            System.out.println(jenisCuti.getId());
//            System.out.println(jenisCuti.getJenis());
//            
//        }
    }

}
