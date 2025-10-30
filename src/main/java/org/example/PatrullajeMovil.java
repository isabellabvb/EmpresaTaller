package org.example;

public class PatrullajeMovil extends ServicioSeguridad {

    private int cantRutas;
    private double kmRecorridos;

    public PatrullajeMovil(String codigoContrato, double tarifaMensual, Estado estado, int cantRutas, double kmRecorridos) {
        super(codigoContrato, tarifaMensual, estado);
        this.cantRutas = cantRutas;
        this.kmRecorridos = kmRecorridos;
    }

    @Override
    public double calcularCostoMensual() {
        return getTarifaMensual() * cantRutas * kmRecorridos;
    }
}