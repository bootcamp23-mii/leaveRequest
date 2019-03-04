/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.JenisCuti;

/**
 *
 * @author Pandu
 */
public interface JenisCutiInterface {
    public JenisCuti getId(String s);
    public List<JenisCuti> getAll(String s);
    
    public String save(String id, String jenis);
    public String update(String id, String jenis);
    public String delete(String id);
}
