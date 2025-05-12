// src/main/java/sanatorio/model/Pediatrico.java
package sanatorio.model;

import sanatorio.service.Administracion;
import sanatorio.service.Nutricion;

public class Pediatrico extends Paciente implements Administracion, Nutricion {
    private double peso;
    private String celularTutor;
    private String tutor;

    public Pediatrico(String dni, String nombre, String os,
                      double peso, String celularTutor, String tutor) {
        super(dni, nombre, os);
        this.peso = peso;
        this.celularTutor = celularTutor;
        this.tutor = tutor;
    }

    // Getters/setters propios
    public double getPeso() { return peso; }
    public void setPeso(double p) { this.peso = p; }

    public String getCelularTutor() { return celularTutor; }
    public void setCelularTutor(String c) { this.celularTutor = c; }

    public String getTutor() { return tutor; }
    public void setTutor(String t) { this.tutor = t; }

    // Implementación de Administracion
    @Override public String getCoberturaOS() {
        return "Cobertura pediátrica estándar para " + getObraSocial();
    }
    @Override public double getDescuento() {
        return 0.10; // 10% de descuento, por ejemplo
    }
    @Override public String getVademecum() {
        return "Vademécum pediátrico básico";
    }

    // Implementación de Nutricion
    @Override public String getTipoDieta() {
        return "Dieta blanda adaptada al peso de " + peso + " kg";
    }
}