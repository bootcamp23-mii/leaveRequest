/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import models.Karyawan;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Panji Sadewo
 */
public class KaryawanDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public KaryawanDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public KaryawanDAO() {
    }
    
    
    public List<Karyawan> login(Object username) {
        List<Karyawan> karyawans = new ArrayList<Karyawan>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            karyawans = session.createQuery("FROM Karyawan WHERE id = '"+username+"'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return karyawans;
    }
    
    
    public boolean saveOrDelete(Karyawan karyawan, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(karyawan);
            } else {
                session.delete(karyawan);
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
    
    public Karyawan getById(int id) {
        Karyawan karyawan = new Karyawan();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            karyawan = (Karyawan) session.createQuery("FROM Karyawan where id = "+id).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return karyawan;
    }
    
    public List<Karyawan> getData(Object keyword) {
        List<Karyawan> regions = new ArrayList<Karyawan>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            regions = session.createQuery("FROM Karyawan where name like '%"+keyword+"%' or jeniskelamin like '%"+keyword+"%' order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return regions;
    }
    
}
