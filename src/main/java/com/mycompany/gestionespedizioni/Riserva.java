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
public class Riserva extends Thread{
    
    Connection conn=null;
    String url = "jdbc:postgresql://localhost/gestioneSpedizioni";
    String user = "postgres";
    String pass = "root";
    
    private String nomeMitt;
    private String indirizzoMitt;
    private String cap_Mitt;
    private String nomeDest;
    private String indirizzoDest;
    private String cap_Dest;
    private String nddt;
    private String dataAcq;
    private Integer idsped;
    private String stato;

    public Riserva(String nomeMitt, String indirizzoMitt, String cap_Mitt, String nomeDest, String indirizzoDest, String cap_Dest, String nddt, String dataAcq, String stato) {
        this.nomeMitt = nomeMitt;
        this.indirizzoMitt = indirizzoMitt;
        this.cap_Mitt = cap_Mitt;
        this.nomeDest = nomeDest;
        this.indirizzoDest = indirizzoDest;
        this.cap_Dest = cap_Dest;
        this.nddt = nddt;
        this.dataAcq=dataAcq;
        this.stato=stato;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Integer getIdsped() {
        return idsped;
    }

    public void setIdsped(Integer idsped) {
        this.idsped = idsped;
    }

    public String getNomeMitt() {
        return nomeMitt;
    }

    public void setNomeMitt(String nomeMitt) {
        this.nomeMitt = nomeMitt;
    }

    public String getIndirizzoMitt() {
        return indirizzoMitt;
    }

    public void setIndirizzoMitt(String indirizzoMitt) {
        this.indirizzoMitt = indirizzoMitt;
    }

    public String getCap_Mitt() {
        return cap_Mitt;
    }

    public void setCap_Mitt(String cap_Mitt) {
        this.cap_Mitt = cap_Mitt;
    }

    public String getNomeDest() {
        return nomeDest;
    }

    public void setNomeDest(String nomeDest) {
        this.nomeDest = nomeDest;
    }

    public String getIndirizzoDest() {
        return indirizzoDest;
    }

    public void setIndirizzoDest(String indirizzoDest) {
        this.indirizzoDest = indirizzoDest;
    }

    public String getCap_Dest() {
        return cap_Dest;
    }

    public void setCap_Dest(String cap_Dest) {
        this.cap_Dest = cap_Dest;
    }

    public String getNddt() {
        return nddt;
    }

    public void setNddt(String nddt) {
        this.nddt = nddt;
    }

    public String getDataAcq() {
        return dataAcq;
    }

    public void setDataAcq(String dataAcq) {
        this.dataAcq = dataAcq;
    }
    
     public void salvaIntoTab(String idsped,String data, String nddt, String stato){
        try{
            Connection conn=DriverManager.getConnection(url, user, pass);
            String query="INSERT INTO riserve (idsped,nddt,data) VALUES (?,?,?)";
            PreparedStatement state=conn.prepareStatement(query);
            state.setString(1, this.getIdsped().toString());
            state.setString(2, this.getNddt());
            state.setString(3, this.getDataAcq());
            state.executeUpdate();
        }catch(SQLException sql){
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
        
        try{
            Connection conn=DriverManager.getConnection(url, user, pass);
            String query="INSERT INTO spedizione"+nddt+idsped+" (idsped,nddt,data,stato) VALUES (?,?,?,?)";
            PreparedStatement state=conn.prepareStatement(query);
            state.setString(1, this.getIdsped().toString());
            state.setString(2, this.getNddt());
            state.setString(3, this.getDataAcq());
            state.setString(4, "consegnata");
            state.executeUpdate();
        }catch(SQLException sql){
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
    }
    
     public void run(){
         this.salvaIntoTab(this.getIdsped().toString(), this.getDataAcq(), this.getNddt(), this.getStato());
     }
    
}
