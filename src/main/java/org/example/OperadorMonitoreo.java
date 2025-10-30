package org.example;
import java.util.LinkedList;

public class OperadorMonitoreo extends Empleado{
    private int numeroZonas;

    public OperadorMonitoreo(String nombre, String id, double salarioBase, int horasExtra, Turno turno, int numeroZonas) {
        super(nombre, id, salarioBase, horasExtra, turno);
        this.numeroZonas = numeroZonas;
    }

    //Metodo abstracto
    public double calcularSalarioTotal() {
        for(int i = 0; i < bonificaciones.size(); i++) {
            salarioBase += bonificaciones.get(i);
        }
        return salarioBase + horasExtra * 15000;
    }

    //Getter y setter
    public int getNumeroZonas() {
        return numeroZonas;
    }
    public void setNumeroZonas(int numeroZonas) {
        this.numeroZonas = numeroZonas;
    }
}
