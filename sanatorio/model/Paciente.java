package sanatorio.model;

public abstract class Paciente {
    private String dni;
    private String nombre;
    private String obraSocial;

    public Paciente(String dni, String nombre, String obraSocial) {
        this.dni = dni;
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }

    // Getters y setters comunes
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getObraSocial() { return obraSocial; }
    public void setObraSocial(String os) { this.obraSocial = os; }
}