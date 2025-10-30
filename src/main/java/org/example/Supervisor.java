package org.example;
import java.util.LinkedList;

public class Supervisor extends Empleado{
    private double bonoCoordinacion;

    public Supervisor(String nombre, String id, double salarioBase, int horasExtra, Turno turno, double bonoCoordinacion) {
        super(nombre, id, salarioBase, horasExtra, turno);
        this.bonoCoordinacion = bonoCoordinacion;
    }

    //Metodo abstracto
    public double calcularSalarioTotal() {
        for(int i = 0; i < bonificaciones.size(); i++) {
            salarioBase += bonificaciones.get(i);
        }
        return salarioBase + bonoCoordinacion + horasExtra * 15000;
    }

    //Getter y setter
    public double getBonoCoordinacion() {
        return bonoCoordinacion;
    }
    public void setBonoCoordinacion(double bonoCoordinacion) {
        this.bonoCoordinacion = bonoCoordinacion;
    }

}
