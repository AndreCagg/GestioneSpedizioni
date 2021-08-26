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
public class Macchina {
    private String nome;
    private String targa;
    private Autisti autistaAss;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Autisti getAutistaAss() {
        return autistaAss;
    }

    public void setAutistaAss(Autisti autistaAss) {
        this.autistaAss = autistaAss;
    }

    public String toString() {
        return "Macchina{" + "nome=" + nome + ", targa=" + targa + ", autistaAss=" + autistaAss + '}';
    }
    
    
}
