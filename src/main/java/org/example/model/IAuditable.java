package org.example.model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface IAuditable {
    void registroNovedad(RegistroNovedad registroNovedad);
    LinkedList<RegistroNovedad> obtenerNovedades(LocalDateTime desde, LocalDateTime hasta);


}