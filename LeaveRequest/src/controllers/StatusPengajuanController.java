/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.Interface;
import java.util.List;
import models.StatusPengajuan;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class StatusPengajuanController implements StatusPengajuanInterface {

    private final Interface<StatusPengajuan> spdao;

    public StatusPengajuanController(SessionFactory sessionFactory) {
        spdao = new GeneralDAO<>(sessionFactory, new StatusPengajuan());
    }

    @Override
    public List<StatusPengajuan> getHistory(String id, Boolean isS1) {
        return spdao.getHistory(id, isS1);
    }

    @Override
    public List<StatusPengajuan> getAll(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StatusPengajuan> getData(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
