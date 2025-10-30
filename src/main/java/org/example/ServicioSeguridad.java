package org.example;

public abstract class ServicioSeguridad {
    protected String codigoContrato;
    protected double tarifaMensual;
    protected Estado estado;

    public ServicioSeguridad(String codigoContrato, double tarifaMensual, Estado estado) {
        this.codigoContrato = codigoContrato;
        this.tarifaMensual = tarifaMensual;
        this.estado = estado;
    }

    public abstract double calcularCostoMensual();

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public double getTarifaMensual() {
        return tarifaMensual;
    }

    public void setTarifaMensual(double tarifaMensual) {
        this.tarifaMensual = tarifaMensual;
    }

    public Estado getEstado() {
        return estado;
    }
}