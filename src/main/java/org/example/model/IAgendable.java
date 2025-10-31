package org.example.model;

import java.time.LocalDate;
import java.util.LinkedList;

public interface IAgendable {
    void programar(LocalDate fecha, String descripcion);
    LinkedList<AgendaItem> obtenerAgenda(LocalDate desde, LocalDate hasta);

}