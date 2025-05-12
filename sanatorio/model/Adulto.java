package sanatorio.model;

import sanatorio.service.Administracion;
import sanatorio.service.ClinicaMedica;

public class Adulto extends Paciente implements Administracion, ClinicaMedica {
    private double presionArterial;
    private double altura;
    private double peso;

    public Adulto(String dni, String nombre, String os,
                  double pa, double altura, double peso) {
        super(dni, nombre, os);
        this.presionArterial = pa;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters/setters propios
    public double getPresionArterial() { return presionArterial; }
    public void setPresionArterial(double pa) { this.presionArterial = pa; }

    public double getAltura() { return altura; }
    public void setAltura(double h) { this.altura = h; }

    public double getPeso() { return peso; }
    public void setPeso(double p) { this.peso = p; }

    // Administracion
    @Override public String getCoberturaOS() {
        return "Cobertura adulta para " + getObraSocial();
    }
    @Override public double getDescuento() {
        return 0.05; // 5% de descuento
    }
    @Override public String getVademecum() {
        return "Vademécum de adultos";
    }

    // ClinicaMedica
    @Override public String recetarRx() {
        return "Rx de tórax";
    }
    @Override public String recetarSangre() {
        return "Estudio hemograma completo";
    }
}