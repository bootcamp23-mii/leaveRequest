/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Karyawan;

/**
 *
 * @author Panji Sadewo
 */
public interface KaryawanInterface {

    public String register(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager);

    public boolean login(String username, String password);

    public List<Karyawan> getAll();

    public List<Karyawan> getKar(String key);

    public List<Karyawan> getKarByMang(String key);

    public List<Karyawan> getIdKar(String key);

    public List<Karyawan> getAll(String key);

    public Karyawan getById(String key);

    public void delete(String key);

    public String update(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager);

}
