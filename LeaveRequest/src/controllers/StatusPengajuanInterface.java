/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.StatusPengajuan;

/**
 *
 * @author Pandu
 */
public interface StatusPengajuanInterface {

    public List<StatusPengajuan> getHistory(String id, Boolean type);

    public List<StatusPengajuan> getHistoryByMang(String id, Boolean type);

    public List<StatusPengajuan> getAll(String key);

    public List<StatusPengajuan> getData(String key);

//    public String save(String id, String start, String end, String total, String karyawan, String jenisCuti);
    public String update(String id, String date, String keterangan, String Pengajuan, String status);
//    public String delete(String id);
}
