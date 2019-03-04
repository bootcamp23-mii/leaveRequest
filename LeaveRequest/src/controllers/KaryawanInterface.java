/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;

/**
 *
 * @author Panji Sadewo
 */
public interface KaryawanInterface{
    public boolean login(String username, String password);
    public void getData();
    public String register(String id, String nama, String jenisKelamin, String jumlahCuti, String email, String password, String statusNikah, String idManager);
    public void getById();
    public void delete();
    public void update();
    
}
