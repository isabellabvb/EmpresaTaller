package org.example;

public class EquipoAsignado {
    private String codigo;
    private String estado;
    private double valorReposicion;

    public EquipoAsignado(String codigo, String estado, double valorReposicion) {
        this.codigo = codigo;
        this.estado = estado;
        this.valorReposicion = valorReposicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public double getValorReposicion() {
        return valorReposicion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValorReposicion(double valorReposicion) {
        this.valorReposicion = valorReposicion;
    }
}