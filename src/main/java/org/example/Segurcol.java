package org.example;
import java.time.LocalDateTime;
import java.util.LinkedList;
public class Segurcol  implements IAuditable {
    String nombre;
    String nit;

    //Atributos relacionales

    private LinkedList <ServicioSeguridad> listServicioSeguridad;
    private LinkedList <Empleado> listEmpleados;
    private LinkedList <Cliente> listClientes;
    private LinkedList <RegistroNovedad> listRegistrosNovedades;
    private LinkedList <EquipoAsignado> listEquipoAsignado;
    private LinkedList <AgendaItem> listAgendaItem;


    public Segurcol(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        listServicioSeguridad = new LinkedList<>();
        listEmpleados = new LinkedList<>();
        listClientes = new LinkedList<>();
        listRegistrosNovedades = new LinkedList<>();
    }

    //Implementación interfaz
    public void registroNovedad(RegistroNovedad registroNovedad){
        listRegistrosNovedades.add(registroNovedad);
    }
    public LinkedList<RegistroNovedad> obtenerNovedades(LocalDateTime desde, LocalDateTime hasta){
        LinkedList<RegistroNovedad> resultado = new LinkedList<>();
        for (RegistroNovedad n : listRegistrosNovedades) {
            if (n.fechaHora().isAfter(desde) && n.fechaHora().isBefore(hasta)) {
                resultado.add(n);
            }
        }
        return resultado;
    }

//CRUD MonitoreoRemoto

    public boolean agregarMonitoreoRemoto(MonitoreoRemoto monitoreoRemoto, String idCliente) {
        listServicioSeguridad.add(monitoreoRemoto);
        Cliente c = buscarCliente(idCliente);
        c.getListServicioSeguridad().add(monitoreoRemoto);
        return true;
    }

    public boolean eliminarServicioSeguridad(String codigoContrato) {
        ServicioSeguridad servicioSeguridad = buscarServicioSeguridad(codigoContrato);
        if (servicioSeguridad == null) return false;
        servicioSeguridad.getCliente().getListServicioSeguridad().remove(servicioSeguridad);
        listServicioSeguridad.remove(servicioSeguridad);
        return true;
    }

    public boolean actualizarMonitoreoRemoto(String codigoContrato, MonitoreoRemoto monitoreoRemoto) {
        ServicioSeguridad servicioSeguridadAux = buscarServicioSeguridad(codigoContrato);
        if (!(servicioSeguridadAux instanceof MonitoreoRemoto)) return false;
        MonitoreoRemoto m = (MonitoreoRemoto) servicioSeguridadAux;
        Cliente c = m.getCliente();
        m.setCantDispositivosVigilados(monitoreoRemoto.getCantDispositivosVigilados());
        m.setEstado(monitoreoRemoto.getEstado());
        m.setTarifaMensual(monitoreoRemoto.getTarifaMensual());
        m.setCantDispositivosVigilados(monitoreoRemoto.getCantDispositivosVigilados());
        for (ServicioSeguridad s : c.getListServicioSeguridad()) {
            if (s instanceof MonitoreoRemoto && s.getCodigoContrato().equals(monitoreoRemoto.getCodigoContrato())) {
                MonitoreoRemoto m2 = (MonitoreoRemoto) s;
                m2.setCantDispositivosVigilados(monitoreoRemoto.getCantDispositivosVigilados());
                m2.setEstado(monitoreoRemoto.getEstado());
                m2.setTarifaMensual(monitoreoRemoto.getTarifaMensual());
                m2.setCantDispositivosVigilados(monitoreoRemoto.getCantDispositivosVigilados());
            }
        }
        return true;
    }

    //CRUD PatrullajeMovil

    public boolean agregarPatrullajeMovil(PatrullajeMovil patrullajeMovil, String idCliente) {
        listServicioSeguridad.add(patrullajeMovil);
        Cliente c = buscarCliente(idCliente);
        c.getListServicioSeguridad().add(patrullajeMovil);
        return true;
    }

    public boolean actualizarPatrullajeMovil(String codigoContrato, PatrullajeMovil patrullajeMovil) {
        ServicioSeguridad servicioSeguridadAux = buscarServicioSeguridad(codigoContrato);
        if (!(servicioSeguridadAux instanceof PatrullajeMovil)) return false;
        PatrullajeMovil p = (PatrullajeMovil) servicioSeguridadAux;
        Cliente c = p.getCliente();
        p.setCantRutas(patrullajeMovil.getCantRutas());
        p.setKmRecorridos(patrullajeMovil.getKmRecorridos());
        p.setEstado(patrullajeMovil.getEstado());
        p.setTarifaMensual(patrullajeMovil.getTarifaMensual());
        for (ServicioSeguridad s : c.getListServicioSeguridad()) {
            if (s instanceof PatrullajeMovil && s.getCodigoContrato().equals(p.getCodigoContrato())) {
                PatrullajeMovil p2 = (PatrullajeMovil) s;
                p2.setCantRutas(patrullajeMovil.getCantRutas());
                p2.setKmRecorridos(patrullajeMovil.getKmRecorridos());
                p2.setEstado(patrullajeMovil.getEstado());
                p2.setTarifaMensual(patrullajeMovil.getTarifaMensual());
            }
        }
        return true;
    }

    //CRUD CustodiaFija

    public boolean agregarCustodiaFija(CustodiaFija custodiaFija, String idCliente) {
        listServicioSeguridad.add(custodiaFija);
        Cliente c = buscarCliente(idCliente);
        c.getListServicioSeguridad().add(custodiaFija);
        return true;
    }

    public boolean actualizarCustodiaFija(String codigoContrato, CustodiaFija custodiaFija) {
        ServicioSeguridad servicioSeguridadAux = buscarServicioSeguridad(codigoContrato);
        if (!(servicioSeguridadAux instanceof CustodiaFija)) return false;
        CustodiaFija c = (CustodiaFija) servicioSeguridadAux;
        Cliente cl = c.getCliente();
        c.setEstado(custodiaFija.getEstado());
        c.setTarifaMensual(custodiaFija.getTarifaMensual());
        for (ServicioSeguridad s : cl.getListServicioSeguridad()) {
            if (s instanceof CustodiaFija && s.getCodigoContrato().equals(custodiaFija.getCodigoContrato())) {
                CustodiaFija c2 = (CustodiaFija) s;
                c2.setEstado(custodiaFija.getEstado());
                c2.setTarifaMensual(custodiaFija.getTarifaMensual());
            }
        }
        return true;
    }

    //CRUD Equipo

    public boolean agregarEquipo (EquipoAsignado equipoAsignado, String idEmpleado){
        listEquipoAsignado.add(equipoAsignado);
        Empleado e = buscarEmpleado(idEmpleado);
        e.getListEquipoAsignado().add(equipoAsignado);
        return true;
    }

    public boolean actualizarEquipo (String codigo, EquipoAsignado equipoAsignado){
        EquipoAsignado e = buscarEquipoAsignado(codigo);
        if ( e== null) return false;
        e.setEstado(equipoAsignado.getEstado());
        e.setValorReposicion(equipoAsignado.getValorReposicion());

        Empleado em = e.getEmpleado();
        for (EquipoAsignado eq : em.getListEquipoAsignado()) {
            if (eq.getCodigo().equals(e.getCodigo())) {

                eq.setEstado(equipoAsignado.getEstado());
                eq.setValorReposicion(equipoAsignado.getValorReposicion());
            }
        }
        return true;
    }

    public boolean eliminarEquipo (String codigo){
        EquipoAsignado e = buscarEquipoAsignado(codigo);
        if ( e== null) return false;
        e.getEmpleado().getListEquipoAsignado().remove(e);
        listEquipoAsignado.remove(e);
        return true;
    }

    // CRUD Cliente

    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getId()) == null) {
            listClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(String id) {
        if (buscarCliente(id) != null) {
            listClientes.remove(buscarCliente(id));
            return true;
        }
        return false;
    }

    public boolean actualizarCliente(String id, Cliente cliente) {
        Cliente c = buscarCliente(id);
        if (c != null) {
            c.setNombre(cliente.getNombre());
            return true;
        }
        return false;

    }

    //Auxiliares

    public ServicioSeguridad buscarServicioSeguridad(String codigoContrato) {
        for(ServicioSeguridad servicioSeguridad : listServicioSeguridad) {
            if(servicioSeguridad.getCodigoContrato().equals(codigoContrato)) {
                return servicioSeguridad;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String id) {
        for(Cliente cliente : listClientes) {
            if(cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public EquipoAsignado buscarEquipoAsignado(String codigo) {
        for(EquipoAsignado equipoAsignado : listEquipoAsignado) {
            if(equipoAsignado.getCodigo().equals(codigo)) {
                return equipoAsignado;
            }
        }
        return null;

    }

    public Empleado buscarEmpleado(String id){
        for (Empleado empleado : listEmpleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }



    //CRUD Supervisor
    public boolean agregarSupervisor(Supervisor supervisor, String id) {
        if (supervisor == null) return false;
        listEmpleados.add(supervisor);
        return true;
    }
    public boolean actualizarSupervisor (String id, Supervisor supervisor) {
        Empleado e = buscarEmpleado(id);
        if (e != null && e instanceof Supervisor) {
            Supervisor s = (Supervisor) e;
            s.setNombre(supervisor.getNombre());
            s.setSalarioBase(supervisor.getSalarioBase());
            s.setHorasExtra(supervisor.getHorasExtra());
            s.setTurno(supervisor.getTurno());
            s.setBonoCoordinacion(supervisor.getBonoCoordinacion());
            return true;
        }
        return false;
    }

    //CRUD OperadorMonitoreo
    public boolean agregarOperadorMonitoreo(OperadorMonitoreo operador, String id) {
        if (operador == null) return false;
        listEmpleados.add(operador);
        return true;
    }
    public boolean actualizarOperadorMonitoreo (String id, OperadorMonitoreo operadorMonitoreo) {
        Empleado e = buscarEmpleado(id);
        if (e != null && e instanceof OperadorMonitoreo) {
            OperadorMonitoreo o = (OperadorMonitoreo) e;
            o.setNombre(operadorMonitoreo.getNombre());
            o.setSalarioBase(operadorMonitoreo.getSalarioBase());
            o.setHorasExtra(operadorMonitoreo.getHorasExtra());
            o.setTurno(operadorMonitoreo.getTurno());
            o.setNumeroZonas(operadorMonitoreo.getNumeroZonas());
            return true;
        }
        return false;
    }

    //CRUD Vigilante
    public boolean agregarVigilante(Vigilante vigilante, String id){
        if (vigilante == null) return false;
        listEmpleados.add(vigilante);
        return true;
    }
    public boolean actualizarVigilante (String id, Vigilante vigilante) {
        Empleado e = buscarEmpleado(id);
        if (e != null && e instanceof Vigilante) {
            Vigilante v = (Vigilante) e;
            v.setNombre(vigilante.getNombre());
            v.setSalarioBase(vigilante.getSalarioBase());
            v.setHorasExtra(vigilante.getHorasExtra());
            v.setTurno(vigilante.getTurno());
            v.setNumPuesto(vigilante.getNumPuesto());
            return true;
        }
        return false;
    }
    //general
    public boolean eliminarEmpleado(String id){
        Empleado empleado = buscarEmpleado(id);
        if (buscarEmpleado(id) != null) {
            listEmpleados.remove(buscarEmpleado(id));
            return true;
        }
        return false;
    }

    //Getter y setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public LinkedList<ServicioSeguridad> getListServicioSeguridad() {
        return listServicioSeguridad;
    }
    public void setListServicioSeguridad(LinkedList<ServicioSeguridad> listServicioSeguridad) {
        this.listServicioSeguridad = listServicioSeguridad;
    }
    public LinkedList<Empleado> getListEmpleados() {
        return listEmpleados;
    }
    public void setListEmpleados(LinkedList<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }
    public LinkedList<Cliente> getListClientes() {
        return listClientes;
    }
    public void setListClientes(LinkedList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }
    public LinkedList<RegistroNovedad> getListRegistrosNovedades() {
        return listRegistrosNovedades;
    }
    public void setListRegistrosNovedades(LinkedList<RegistroNovedad> listRegistrosNovedades) {
        this.listRegistrosNovedades = listRegistrosNovedades;
    }
}
