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
public class Associazione {
    
    private Macchina m;
    private Spedizioni s;
    private Autisti a;

    public Macchina getM() {
        return m;
    }

    public void setM(Macchina m) {
        this.m = m;
    }

    public Spedizioni getS() {
        return s;
    }

    public void setS(Spedizioni s) {
        this.s = s;
    }

    public Autisti getA() {
        return a;
    }

    public void setA(Autisti a) {
        this.a = a;
    }

    public String toString() {
        return "Associazione{" + "m=" + m + ", s=" + s + ", a=" + a + '}';
    }
    
    
    
}
