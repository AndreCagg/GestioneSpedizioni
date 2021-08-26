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
public class Mittente extends Thread{
    
    private String ragsoc;
    private String ind;
    private String cap;
    Modifica m;

    public Modifica getM() {
        return m;
    }

    public void setM(Modifica m) {
        this.m = m;
    }
    

    public String getRagsoc() {
        return ragsoc;
    }

    public void setRagsoc(String ragsoc) {
        this.ragsoc = ragsoc;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Mittente(String ragsoc, String ind, String cap,Modifica m) {
        this.ragsoc = ragsoc;
        this.ind = ind;
        this.cap = cap;
    }
    
    public void inserisci (){
        this.getM().ragsocMitt.setText(this.getRagsoc().toUpperCase());
        this.getM().indMitt.setText(this.getInd().toUpperCase());
        this.getM().capMitt.setText(this.getCap()); 
    }
    
    public void run(){
       this.inserisci();
    }
    
}
