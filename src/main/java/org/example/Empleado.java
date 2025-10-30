package org.example;
import java.time.LocalDate;
import java.util.LinkedList;
public abstract class Empleado implements IAgendable {
    protected String nombre;
    protected String id;
    protected double salarioBase;
    protected int horasExtra;
    protected Turno turno;
    protected LinkedList<Double> bonificaciones;

    //Atributoos relacionales
    protected LinkedList<EquipoAsignado> listEquiposAsignados;


    public Empleado(String nombre, String id, double salarioBase, int horasExtra, Turno turno) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
        this.horasExtra = horasExtra;
        this.turno = turno;
        this.bonificaciones = new LinkedList<>();
        this.listEquiposAsignados = new LinkedList<>();
    }

    public void programar(LocalDate fecha, String descripcion){

    }
    public LinkedList<AgendaItem> obtenerAgenda(LocalDate desde, LocalDate hasta){
        return null;
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
    public LinkedList<EquipoAsignado> getListEquiposAsignados() {
        return listEquiposAsignados;
    }
    public void setListEquiposAsignados(LinkedList<EquipoAsignado> listEquiposAsignados) {
        this.listEquiposAsignados = listEquiposAsignados;
    }

}
