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
public class Votantes {

    private String dni;
    private String clave;
    private String voto;

    public Votantes(String dni, String clave, String voto) {
        this.dni = dni;
        this.clave = clave;
        this.voto = voto;
    }

    public Votantes(String dni, String clave) {
        this.dni = dni;
        this.clave = clave;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return this.dni;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return this.clave;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getVoto() {
        return this.voto;
    }

    public String toString() {
        String mes = this.getDni() + "-" + this.getClave() + "-" + this.getVoto();

        return mes;
    }
}
