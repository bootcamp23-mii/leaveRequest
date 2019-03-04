/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.Interface;
import java.util.List;
import models.JenisCuti;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class JenisCutiController implements JenisCutiInterface {

    private final Interface<JenisCuti> cdao;

    public JenisCutiController(SessionFactory sessionFactory) {
        cdao = new GeneralDAO<>(sessionFactory, new JenisCuti());
    }

    @Override
    public models.JenisCuti getId(String s) {
        return cdao.getById(s);
    }

    @Override
    public List<models.JenisCuti> getAll(String s) {
        return cdao.getData("");
    }

    @Override
    public String save(String id, String jenis) {
        if (cdao.saveOrDelete(new JenisCuti(id, jenis), true)) {
            return "NEW LEAVE TYPES SUCCESSFULLY INSERTED";
        } else {
            return "UH OH, SOMETING WENT WRONG";
        }
    }

    @Override
    public String update(String id, String jenis) {
        if (cdao.saveOrDelete(new JenisCuti(id, jenis), true)) {
            return "NEW LEAVE TYPES SUCCESSFULLY UPDATED";
        } else {
            return "UH OH, SOMETING WENT WRONG";
        }
    }

    @Override
    public String delete(String id) {
        if (cdao.saveOrDelete(new JenisCuti(id), false)) {
            return "NEW LEAVE TYPES SUCCESSFULLY DELETED";
        } else {
            return "UH OH, SOMETING WENT WRONG";
        }
    }

}
