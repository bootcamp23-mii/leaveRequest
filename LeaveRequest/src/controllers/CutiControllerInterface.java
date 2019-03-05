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
    
    //OPTIONAL BY GALANG
    public List<Pengajuan> getByKaryawan(String id);
    
    public List<Pengajuan> getByIdKaryawan(String id);
    
//    public List<Pengajuan> getHistory(String id);

    public List<Pengajuan> getAll(String key);
    
    public List<Pengajuan> getData(String key);

    public String save(String id, String start, String end, String total, String karyawan, String jenisCuti);
    public String update(String id, String start, String end, String total, String karyawan, String jenisCuti);
    public String delete(String id);
}
