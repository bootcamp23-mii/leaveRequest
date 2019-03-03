/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainTools;

import controllers.CutiController;
import daos.CutiDAO;
import java.text.ParseException;
import org.hibernate.SessionFactory;
import mainTools.HibernateUtil;
import models.Karyawan;
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

        CutiDAO cdao = new CutiDAO(sessionFactory);
        CutiController cc = new CutiController(sessionFactory);
        
//        INSERT/UPDATE/DELETE
//        System.out.println(cc.insert("P3", "2018-03-03", "2018-03-04", "1", "11205", "JC1"));

//        System.out.println(cc.getByID("11205"));


//        GET DATA BASED ON KARYAWAN ID
        for (Pengajuan pengajuan : cc.getByID("11205")) {
            System.out.println("==============================");
            System.out.println("ID      : "+pengajuan.getId());
            System.out.println("START   : "+pengajuan.getTanggalmulai());
            System.out.println("END     : "+pengajuan.getTanggalakhir());
            System.out.println("TOTAL   : "+pengajuan.getJumlah());
                
            //I DONT EXACTLY KNOW WHAT'S WRONG WITH THIS LIL SHIT
            System.out.println("KARYAWAN: "+pengajuan.getKaryawan().getNama());
            System.out.println("TYPE    : "+pengajuan.getJeniscuti().getJenis());

        }
    }

}