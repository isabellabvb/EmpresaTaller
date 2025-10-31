package org.example.model;

import java.time.LocalDate;
import java.util.LinkedList;
public abstract class Empleado implements IAgendable {
    protected String nombre;
    protected String id;
    protected double salarioBase;
    protected int horasExtra;
    protected Turno turno;
    protected LinkedList<Double> bonificaciones;

    //Atributos relacionales
    protected LinkedList<AgendaItem> agendas;
    private LinkedList <EquipoAsignado> listEquipoAsignado;


    public Empleado(String nombre, String id, double salarioBase, int horasExtra, Turno turno) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
        this.horasExtra = horasExtra;
        this.turno = turno;
        bonificaciones = new LinkedList<>();
        listEquipoAsignado = new LinkedList<>();
    }

    //Implementacion interfaz
    public void programar(LocalDate fecha,String descripcion) {
        AgendaItem agenda = new AgendaItem(descripcion,fecha);
    }

    public LinkedList<AgendaItem> obtenerAgenda(LocalDate desde, LocalDate hasta) {
        for (AgendaItem agenda : agendas) {
            if (agenda.getFecha().isAfter(desde) && agenda.getFecha().isBefore(hasta)) {
                agendas.add(agenda);
            }
        }
        return agendas;
    }

    public abstract double calcularSalarioTotal();

    //Getter y setter
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
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public int getHorasExtra() {
        return horasExtra;
    }
    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
    public Turno getTurno() {
        return turno;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public LinkedList<Double> getBonificaciones() {
        return bonificaciones;
    }
    public void setBonificaciones(LinkedList<Double> bonificaciones) {
        this.bonificaciones = bonificaciones;
    }
    public LinkedList<EquipoAsignado> getListEquipoAsignado() {
        return listEquipoAsignado;
    }
    public void setListEquipoAsignado(LinkedList<EquipoAsignado> listEquipoAsignado) {
        this.listEquipoAsignado = listEquipoAsignado;
    }

}
