/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Pengajuan;

/**
 *
 * @author Pandu
 */
public interface CutiControllerInterface {

    public Pengajuan getByid(String id);

    public List<Pengajuan> getAll();

    public List<Pengajuan> search(Object keyword);

    public String save(String id, String nama, String region);

    public String delete(String id);
}
