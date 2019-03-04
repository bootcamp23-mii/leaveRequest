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

    public Pengajuan getById(String id);
    
    public List<Pengajuan> getByKaryawan(String id);

    public List<Pengajuan> getAll(String key);

    public List<Pengajuan> search(Object keyword);

    public String save(String id, String start, String end, String total, String karyawan, String jenisCuti);
    public String update(String id, String start, String end, String total, String karyawan, String jenisCuti);
    public String delete(String id);
}
