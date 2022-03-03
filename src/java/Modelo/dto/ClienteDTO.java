/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dto;

/**
 *
 * @author Alex
 */
public class ClienteDTO {
    int id;
    String dni;
    String nom;
    String dir;
    String es;

    public ClienteDTO() {
    }

    public ClienteDTO(int id, String dni, String nom, String dir, String es) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.dir = dir;
        this.es = es;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }
    
    
}
