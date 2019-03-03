/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Pengajuan;
import models.RiwayatCuti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Pandu
 */
public class CutiDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public CutiDAO(SessionFactory factory){
        this.factory=factory;
    }
    
    
    public List<RiwayatCuti> getAll(Object keyword) {
        List<RiwayatCuti> riwayatCuti = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            riwayatCuti = session.createQuery("FROM Riwayat_cuti").list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return riwayatCuti;
    }
    
    public boolean saveordelete(Pengajuan req, Boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(req);
            } else {
                session.delete(req);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
}


