package org.example.model;

public class Vigilante extends Empleado {

    private  String numPuesto;
    private TipoArma tipoArma;

    //Atributos relacionales
    private CustodiaFija custodiaFija;

    public Vigilante(String nombre, String id, double salarioBase, int horasExtra, Turno turno, String numPuesto, TipoArma tipoArma) {
        super(nombre, id, salarioBase, horasExtra, turno);
        this.numPuesto = numPuesto;
        this.tipoArma = tipoArma;
    }

    //Metodo abstracto
    public double calcularSalarioTotal() {
        for(int i = 0; i < bonificaciones.size(); i++) {
            salarioBase += bonificaciones.get(i);
        }
        return salarioBase + horasExtra * 15000;
    }

    //Getter y setter
    public String getNumPuesto() {
        return numPuesto;
    }
    public void setNumPuesto(String numPuesto) {
        this.numPuesto = numPuesto;
    }
    public TipoArma getTipoArma() {
        return tipoArma;
    }
    public void setTipoArma(TipoArma tipoArma) {
        this.tipoArma = tipoArma;
    }
    public CustodiaFija getCustodiaFija() {
        return custodiaFija;
    }
    public void setCustodiaFija(CustodiaFija custodiaFija) {
        this.custodiaFija = custodiaFija;
    }
}
