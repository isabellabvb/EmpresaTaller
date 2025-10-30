package org.example;

public class CustodiaFija extends ServicioSeguridad {

    public CustodiaFija(String codigoContrato, double tarifaMensual, Estado estado) {
        super(codigoContrato, tarifaMensual, estado);
    }


    @Override
    public double calcularCostoMensual() {
        return getTarifaMensual();
    }
}