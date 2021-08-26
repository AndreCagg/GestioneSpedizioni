/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespedizioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caggi
 */
public class TabZoneAut extends Thread {

    Connection conn = null;
    String url = "jdbc:postgresql://localhost/gestioneSpedizioni";
    String user = "postgres";
    String pass = "root";
    private Autisti a;
    private DefaultTableModel model;

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public Autisti getA() {
        return a;
    }

    public void setA(Autisti a) {
        this.a = a;
    }

    public void compilaZone() {
        this.getModel().setRowCount(0);
        String query = "SELECT * FROM " + this.getA().getNome().toLowerCase() + this.getA().getCognome().toLowerCase() + this.getA().getDataNascita().replaceAll("-", "");

        try {
            conn = DriverManager.getConnection(url, user, pass);

            Statement state = conn.createStatement();
            ResultSet ris = state.executeQuery(query);
            conn.close();
            this.getModel().setRowCount(0);
            while (ris.next()) {
                this.getModel().addRow(new Object[]{ris.getString("loc").toUpperCase(), ris.getString("cap")});
            }
        } catch (SQLException sql) {
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
    }

    public void run() {
        this.compilaZone();
    }
}
