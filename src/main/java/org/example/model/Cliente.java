package org.example.model;

import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String id;

    //Relacionales
    private LinkedList<ServicioSeguridad> listServicioSeguridad;

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        listServicioSeguridad = new LinkedList<>();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<ServicioSeguridad> getListServicioSeguridad() {
        return listServicioSeguridad;
    }

    public void setListServicioSeguridad(LinkedList<ServicioSeguridad> listServicioSeguridad) {
        this.listServicioSeguridad = listServicioSeguridad;
    }


}
