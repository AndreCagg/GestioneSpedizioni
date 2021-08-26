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

/**
 *
 * @author caggi
 */
public class CheckR extends Thread{
    Connection conn=null;
    String url = "jdbc:postgresql://localhost/gestioneSpedizioni";
    String user = "postgres";
    String pass = "root";
    
    private Integer idsped;
    private String ddt;

    public Integer getIdsped() {
        return idsped;
    }

    public void setIdsped(Integer idsped) {
        this.idsped = idsped;
    }

    public String getDdt() {
        return ddt;
    }

    public void setDdt(String ddt) {
        this.ddt = ddt;
    }

    public CheckR(Integer idsped, String ddt) {
        this.idsped = idsped;
        this.ddt = ddt;
    }
    
    
    
    
    public Boolean cerca(Integer id,String ddt){
        Boolean b=false;
        String query="SELECT nddt FROM riserve WHERE nddt=?";
        
        try{
            conn=DriverManager.getConnection(url, user, pass);
            
            PreparedStatement state=conn.prepareStatement(query);
            state.setString(1, this.getDdt());
            ResultSet ris=state.executeQuery();
            
            while(ris.next()){
                b=true;
            }
            
            
            conn.close();
        }catch(SQLException sql){
            Err e = new Err();
            e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
            e.setVisible(true);
        }
        return b;
    }
    public void run() {
        
        this.cerca(this.getIdsped(), this.getDdt());
        
    }
}
