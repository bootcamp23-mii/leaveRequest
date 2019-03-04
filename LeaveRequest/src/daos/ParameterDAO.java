/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Parameter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Panji Sadewo
 */
public class ParameterDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public ParameterDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public ParameterDAO() {
    }
    
    public boolean saveOrDelete(Parameter parameter, boolean isSave) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isSave) {
                session.saveOrUpdate(parameter);
            } else {
                session.delete(parameter);
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
    
    public Parameter getById(int id) {
        Parameter parameter = new Parameter();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            parameter = (Parameter) session.createQuery("FROM Parameter where id = "+id).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return parameter;
    }
    
    public List<Parameter> getData(Object keyword) {
        List<Parameter> parameters = new ArrayList<Parameter>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            parameters = session.createQuery("FROM Parameter where name id '%"+keyword+"%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        
        return parameters;
    }
    
}
