/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespedizioni;

/**
 *
 * @author caggi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class AggAut extends Thread {

    Connection conn = null;
    String url = "jdbc:postgresql://localhost/gestioneSpedizioni";
    String user = "postgres";
    String pass = "root";
    private Autisti a;
    private Autisti v;

    public Autisti getA() {
        return a;
    }

    public void setA(Autisti a) {
        this.a = a;
    }

    public Autisti getV() {
        return v;
    }

    public void setV(Autisti v) {
        this.v = v;
    }

    public void creaTab(String nome, String cognome, String dn) {
        String data = dn.replaceAll("-", "");
        String nomeTab = (nome + cognome + data).replaceAll(" ", "");
        String query = "CREATE TABLE IF NOT EXISTS " + nomeTab + " ("
                + "id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + "cap text NOT NULL,"
                + "loc text NOT NULL"
                + ");";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            Statement state = conn.createStatement();
            state.executeUpdate(query);
            conn.close();
        } catch (SQLException sql) {
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
    }

    public void eliminaTab(String nome, String cognome, String dn) {
        String nomeTab = (nome + cognome + dn).replaceAll(" ", "");
        String query = "DROP TABLE IF EXISTS " + nomeTab;

        try {
            conn = DriverManager.getConnection(url, user, pass);

            Statement state = conn.createStatement();
            state.executeUpdate(query);
            conn.close();
        } catch (SQLException sql) {
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
    }

    public void salva(Autisti a) {
        for (Integer i = 0; i < a.getCompetenza().size(); i++) {
            String query = "INSERT INTO " + a.getNome().toLowerCase() + a.getCognome().toLowerCase() + (a.getDataNascita().replaceAll("-", "")) + " (cap,loc) VALUES(?,?)";

            try {
                conn = DriverManager.getConnection(url, user, pass);

                PreparedStatement state = conn.prepareStatement(query);

                state.setString(1, a.getCompetenza().get(i).getCap());
                state.setString(2, a.getCompetenza().get(i).getLoc().toLowerCase());

                state.executeUpdate();
                conn.close();
            } catch (SQLException sql) {
                Err e = new Err();
                e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
                e.setVisible(true);
            }
        }
    }

    public void run() {
        this.eliminaTab(this.getV().getNome().toLowerCase(), this.getV().getCognome().toLowerCase(), this.getV().getDataNascita().replaceAll("-", ""));
        this.creaTab(this.getA().getNome().toLowerCase(), this.getA().getCognome().toLowerCase(), this.getA().getDataNascita().replaceAll("-", ""));
        this.salva(this.getA());
    }
}
