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
public class Bordero {
    private Autisti a;
    private Spedizioni s;
    private Macchina m;

    public Macchina getM() {
        return m;
    }

    public void setM(Macchina m) {
        this.m = m;
    }

    public Autisti getA() {
        return a;
    }

    public void setA(Autisti a) {
        this.a = a;
    }

    public Spedizioni getS() {
        return s;
    }

    public void setS(Spedizioni s) {
        this.s = s;
    }

    public String toString() {
        return "Bordero{" + "a=" + a + ", s=" + s + ", m=" + m + '}';
    }
 
    
}
    
