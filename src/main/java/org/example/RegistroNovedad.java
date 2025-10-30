package org.example;
import java.time.LocalDateTime;

public record RegistroNovedad (String idEmpleado, LocalDateTime fechaHora, String tipoNovedad, String descripcion, String entidadAfectada) {}