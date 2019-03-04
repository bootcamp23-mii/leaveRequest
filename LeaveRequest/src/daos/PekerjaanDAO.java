/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Pekerjaan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Panji Sadewo
 */
public class PekerjaanDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public boolean saveOrDelete(Pekerjaan pekerjaan, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(pekerjaan);
            } else {
                session.delete(pekerjaan);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }        
        return true;
    }
    
    public Pekerjaan getById(int id) {
        Pekerjaan pekerjaan = new Pekerjaan();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            pekerjaan = (Pekerjaan) session.createQuery("FROM Pekerjaan where id = "+id).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return pekerjaan;
    }
    
    public List<Pekerjaan> getData(Object keyword) {
        List<Pekerjaan> pekerjaans = new ArrayList<Pekerjaan>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            pekerjaans = session.createQuery("FROM Pekerjaan where name like '%"+keyword+"%' or jeniskelamin like '%"+keyword+"%' order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return pekerjaans;
    }
    
    
    
}
