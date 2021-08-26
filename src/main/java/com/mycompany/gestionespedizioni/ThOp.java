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
public class ThOp extends Thread {

    private Modifica m;
    private Boolean pulisci;
    private Boolean del;

    public Boolean getPulisci() {
        return pulisci;
    }

    public void setPulisci(Boolean pulisci) {
        this.pulisci = pulisci;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
    

    public Modifica getM() {
        return m;
    }

    public void setM(Modifica m) {
        this.m = m;
    }
    
    public void setV(Boolean pulisci,Boolean del){
        this.getM().pulisciSetV(pulisci);
        this.getM().delRSetV(del);
    }
    
    public void run() {
        
        this.setV(this.getPulisci(),this.getDel());
        
    }
}
