package org.example.model;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class ServicioSeguridad implements IAgendable {
    protected String codigoContrato;
    protected double tarifaMensual;
    protected Estado estado;

    //Relaciones
    protected LinkedList<AgendaItem> agendas;
    protected Cliente cliente;

    public ServicioSeguridad(String codigoContrato, double tarifaMensual, Estado estado) {
        this.codigoContrato = codigoContrato;
        this.tarifaMensual = tarifaMensual;
        this.estado = estado;
        agendas = new LinkedList<>();
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}