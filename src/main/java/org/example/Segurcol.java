package org.example;

public class Segurcol {
    private String nombre;
    private String nit;

    public Segurcol(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    //CRUD


    //Getter y setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
}
