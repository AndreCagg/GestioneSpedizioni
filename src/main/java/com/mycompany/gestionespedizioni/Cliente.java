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
public class Cliente {
    private String ragSoc;
    private String indirizzo;
    private String cap;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

    public String getRagSoc() {
        return ragSoc;
    }

    public void setRagSoc(String ragSoc) {
        this.ragSoc = ragSoc;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String toString() {
        return "Cliente{" + "ragSoc=" + ragSoc + ", indirizzo=" + indirizzo + ", cap=" + cap + ", id=" + id + '}';
    }
    
    
    
}
