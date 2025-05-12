package sanatorio.model;

import sanatorio.service.Administracion;
import sanatorio.service.Nutricion;
import sanatorio.service.ClinicaMedica;

public class Internado extends Paciente
        implements Administracion, Nutricion, ClinicaMedica {

    private String habitacion;
    private double presionArterial;
    private String rh;

    public Internado(String dni, String nombre, String os,
                     String hab, double pa, String rh) {
        super(dni, nombre, os);
        this.habitacion = hab;
        this.presionArterial = pa;
        this.rh = rh;
    }

    // Getters/setters propios
    public String getHabitacion() { return habitacion; }
    public void setHabitacion(String h) { this.habitacion = h; }

    public double getPresionArterial() { return presionArterial; }
    public void setPresionArterial(double pa) { this.presionArterial = pa; }

    public String getRh() { return rh; }
    public void setRh(String r) { this.rh = r; }

    // Administracion
    @Override public String getCoberturaOS() {
        return "Cobertura internación para " + getObraSocial();
    }
    @Override public double getDescuento() {
        return 0.02; // 2% de descuento en internación
    }
    @Override public String getVademecum() {
        return "Vademécum hospitalario";
    }

    // Nutricion
    @Override public String getTipoDieta() {
        return "Dieta hospitalaria según estado clínico";
    }

    // ClinicaMedica
    @Override public String recetarRx() {
        return "Rx de abdomen";
    }
    @Override public String recetarSangre() {
        return "Panel metabólico";
    }
}