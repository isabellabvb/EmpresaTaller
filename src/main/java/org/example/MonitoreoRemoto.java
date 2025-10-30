package org.example;

public class MonitoreoRemoto extends ServicioSeguridad {
    private int cantDispositivosVigilados;

    public MonitoreoRemoto(String codigoContrato, double tarifaMensual, Estado estado, int cantDispositivosVigilados) {
        super(codigoContrato, tarifaMensual, estado);
        this.cantDispositivosVigilados = cantDispositivosVigilados;
    }

    @Override
    public double calcularCostoMensual() {
        return getTarifaMensual() * cantDispositivosVigilados;
    }
}