/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainTools;

import controllers.CutiController;
import controllers.CutiControllerInterface;
import controllers.EmailController;
import controllers.EmailInterface;
import controllers.JenisCutiController;
import controllers.JenisCutiInterface;
import controllers.KaryawanController;
import controllers.KaryawanInterface;
import controllers.StatusPengajuanController;
import controllers.StatusPengajuanInterface;
import daos.GeneralDAO;
import java.text.ParseException;
import org.hibernate.SessionFactory;
import mainTools.HibernateUtil;
import models.Karyawan;
import models.SendEmailTemp;

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
        CutiControllerInterface cc = new CutiController(sessionFactory);
        JenisCutiInterface jc = new JenisCutiController(sessionFactory);
        KaryawanInterface kc = new KaryawanController(sessionFactory);
        GeneralDAO gdao = new GeneralDAO(sessionFactory, kc);
        EmailInterface emailInterface = new EmailController();
        StatusPengajuanInterface spi = new StatusPengajuanController(sessionFactory);
//        CutiController cc = new CutiController(sessionFactory);
//        INSERT/UPDATE/DELETE
//        System.out.println(cc.save("", "04/03/19", "05/03/19", "2", "11205", "JC1"));
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
//        System.out.println(kc.literallyUpdate("11208", "20"));
//        for (Karyawan karyawan : kc.getIdKar("11205")) {
//            System.out.println(kc.update(karyawan.getId(), karyawan.getNama(), 
//                    karyawan.getJeniskelamin(), "99", 
//                    karyawan.getEmail(), karyawan.getPassword(), 
//                    karyawan.getStatusnikah().getId(), 
//                    karyawan.getIdmanager().getId(), karyawan.getJobs().getId()));
//        }
        
//        System.out.println(cc.getById("P1").getKaryawan().getId());
//        System.out.println(kc.getById(cc.getById("P1").getKaryawan().getId()).getEmail());
////        LOGIN
//        System.out.println(kc.register("11206", "loli", "Pria", "3", "loli@alo.com", "qdasd", "SN1", "11201"));
//        System.out.println(kc.register("11200", "admin", "Pria", "3", "loli@alo.com", "admin", "SN1", "11201"));
//        System.out.println(kc.login("loli", "qwe"));
//        System.out.println(kc.login("loli", "qwe"));
//        System.out.println(Session.getId());
        //        
//        for (JenisCuti jenisCuti : jc.getAll("")) {
//            System.out.println("===================");
//            System.out.println(jenisCuti.getId());
//            System.out.println(jenisCuti.getJenis());
//            
//        }
//        for (Pengajuan pengajuan : cc.getByKaryawan("11204")) {
//            System.out.println("===================");
//            System.out.println(pengajuan.getKaryawan().getNama());
//            
//        }
//        SendEmailTemp.setFromEmail("revilghost@gmail.com");
//        SendEmailTemp.setToEmail("pandu4431@gmail.com");
//        SendEmailTemp.setMessage("Test coi");
//        SendEmailTemp.setSubject("Test email");
//        SendEmailTemp.setPassword("");
//        emailInterface.sendEmail();
    }
    
}
