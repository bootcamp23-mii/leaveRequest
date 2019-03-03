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
        
        System.out.println(cc.insert("P3", "2018-03-03", "2018-03-04", "1", "11205", "JC1"));

    }

}
