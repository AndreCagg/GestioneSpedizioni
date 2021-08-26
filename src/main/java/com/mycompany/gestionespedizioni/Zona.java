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
public class Zona {
    private String loc;
    private String cap;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String toString() {
        return "Zona{" + "loc=" + loc + ", cap=" + cap + '}';
    }
    
    
    
}
