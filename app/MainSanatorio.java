package app;

import sanatorio.model.*;
import sanatorio.service.*;

import java.util.*;

public class MainSanatorio {
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();

        // Ejemplo de carga manual
        pacientes.add(new Pediatrico("1234", "Ana Pérez", "OSDE", 18.5, "15551234", "Laura"));
        pacientes.add(new Adulto("5678", "Juan López", "Swiss", 120.0, 1.75, 70.0));
        pacientes.add(new Internado("9012", "María Gómez", "Galeno", "A-101", 110.0, "O+"));

        // Recorremos y llamamos a los servicios
        for (Paciente p : pacientes) {
            System.out.println("\nPaciente: " + p.getNombre() + " (DNI " + p.getDni() + ")");
            // Administración
            Administracion adm = (Administracion)p;
            System.out.println(" Cobertura: " + adm.getCoberturaOS());
            System.out.println(" Descuento: " + (adm.getDescuento() * 100) + "%");
            System.out.println(" Vademécum: " + adm.getVademecum());

            // Nutrición
            if (p instanceof Nutricion) {
                Nutricion nut = (Nutricion)p;
                System.out.println(" Dieta: " + nut.getTipoDieta());
            }

            // Clínica Médica
            if (p instanceof ClinicaMedica) {
                ClinicaMedica cm = (ClinicaMedica)p;
                System.out.println(" Rx: " + cm.recetarRx());
                System.out.println(" Sangre: " + cm.recetarSangre());
            }
        }
    }
}