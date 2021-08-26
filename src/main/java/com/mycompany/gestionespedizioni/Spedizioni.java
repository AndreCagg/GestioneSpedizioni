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
public class Spedizioni {
    private String id;
    private String nomeC;
    private Integer idC;
    private String stato;
    private String tos;
    private String dataAcq;
    private Cliente mitt;
    private Cliente dest;
    private String nddt;
    private String dataCons;
    private Integer nc;
    private String tel;
    private String vol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getDest() {
        return dest;
    }

    public void setDest(Cliente dest) {
        this.dest = dest;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getDataAcq() {
        return dataAcq;
    }

    public void setDataAcq(String dataAcq) {
        this.dataAcq = dataAcq;
    }

    public Cliente getMitt() {
        return mitt;
    }

    public void setMitt(Cliente mitt) {
        this.mitt = mitt;
    }

    public String getNddt() {
        return nddt;
    }

    public void setNddt(String nddt) {
        this.nddt = nddt;
    }

    public String getDataCons() {
        return dataCons;
    }

    public void setDataCons(String dataCons) {
        this.dataCons = dataCons;
    }

    public Integer getNc() {
        return nc;
    }

    public void setNc(Integer nc) {
        this.nc = nc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String toString() {
        return "Spedizioni{" + "id=" + id + ", nomeC=" + nomeC + ", idC=" + idC + ", stato=" + stato + ", tos=" + tos + ", dataAcq=" + dataAcq + ", mitt=" + mitt + ", dest=" + dest + ", nddt=" + nddt + ", dataCons=" + dataCons + ", nc=" + nc + ", tel=" + tel + ", vol=" + vol + '}';
    }
    
    
    
    
}
