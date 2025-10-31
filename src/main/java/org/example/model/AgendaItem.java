package org.example.model;

import java.time.LocalDate;

public class AgendaItem {
    private String descripcion;
    private LocalDate fecha;

    public AgendaItem(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}