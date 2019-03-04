/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Panji Sadewo
 */
public class RoleDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public boolean saveOrDelete(Role role, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(role);
            } else {
                session.delete(role);
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
    
    public Role getById(int id) {
        Role role = new Role();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            role = (Role) session.createQuery("FROM Role where id = "+id).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return role;
    }
    
    public List<Role> getData(Object keyword) {
        List<Role> roles = new ArrayList<Role>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            roles = session.createQuery("FROM Role where id like '%"+keyword+"%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return roles;
    }
    
}
