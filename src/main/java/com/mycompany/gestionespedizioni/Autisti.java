/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespedizioni;
import java.util.*;
/**
 *
 * @author caggi
 */
public class Autisti {
    private String nome;
    private String cognome;
    private String dataNascita;
    private String sesso;
    private ArrayList<Zona> competenza=new ArrayList<Zona>();
    private String stato;

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public ArrayList<Zona> getCompetenza() {
        return competenza;
    }

    public void setCompetenza(ArrayList<Zona> competenza) {
        this.competenza = competenza;
    }

    public String toString() {
        return "Autisti{" + "nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", sesso=" + sesso + ", competenza=" + competenza + ", stato=" + stato + '}';
    }
    
    
    
}
