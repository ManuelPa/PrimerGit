/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pc
 */
public class PartidosPoliticos {

    private String siglaspar;
    private String nombrepar;
    private String logopar;
    private int votospar;

    public PartidosPoliticos(String siglaspar, String nombrepar, String logopar, int votospar) {
        this.siglaspar = siglaspar;
        this.nombrepar = nombrepar;
        this.logopar = logopar;
        this.votospar = votospar;
    }

    public void setSiglas(String siglaspar) {
        this.siglaspar = siglaspar;
    }

    public String getSiglas() {
        return this.siglaspar;
    }

    public void setNombre(String nombrepar) {
        this.nombrepar = nombrepar;
    }

    public String getNombre() {
        return this.nombrepar;
    }

    public void setLogo(String logopar) {
        this.logopar = logopar;
    }

    public String getLogo() {
        return this.logopar;
    }

    public void setVotos(int votospar) {
        this.votospar = votospar;
    }

    public int getVotos() {
        return this.votospar;
    }

    public String toString() {
        String mes = this.getSiglas() + "-" + this.getNombre() + "-" + this.getLogo() + "-" + this.getVotos();

        return mes;
    }
}
