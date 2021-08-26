/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespedizioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author caggi
 */
public class MaccOp extends Thread {

    Connection conn = null;
    String url = "jdbc:postgresql://localhost/gestioneSpedizioni";
    String user = "postgres";
    String pass = "root";
    private String targa;
    private String nome;
    private String a;
    private String tipo;
    private String targaV;

    public String getTargaV() {
        return targaV;
    }

    public void setTargaV(String targaV) {
        this.targaV = targaV;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void elimina() {
        String query = "DELETE FROM macchine WHERE targa=?";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, this.getTarga());
            state.executeUpdate();
            conn.close();
        } catch (SQLException sql) {
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }

    }
    
    public void update(){
        String query = "UPDATE macchine SET nome=?,targa=?,autista=? WHERE targa=?";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, this.getNome().toLowerCase());
            state.setString(2, this.getTarga().toLowerCase());
            state.setString(3, this.getA());
            state.setString(4, this.getTargaV());
            state.executeUpdate();
            conn.close();
        }catch(SQLException sql){
            sql.printStackTrace();
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
    }

    public String toString() {
        return "MaccOp{" + "conn=" + conn + ", url=" + url + ", user=" + user + ", pass=" + pass + ", targa=" + targa + ", nome=" + nome + ", a=" + a + ", tipo=" + tipo + '}';
    }

    public void run() {
        if(this.getTipo().equalsIgnoreCase("up")){
            this.update();
            System.out.println("up");
        }else{
            this.elimina();
        }
    }
}
