import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE ACTIVIDADES ---");
            System.out.println("1. Ejercicio 1 (nota máxima y promedio)");
            System.out.println("2. Ejercicio 2 (aprobados y desaprobados)");
            System.out.println("3. Ejercicio 3 (cantidad y costo de productos)");
            System.out.println("4. Ejercicio 4 (empresa de camiones)");
            System.out.println("5. Ejercicio 5 (empresa de internet)");
            System.out.println("6. Ejercicio 6 (mejor tiempo entre autos)");
            System.out.println("7. Ejercicio 7 (censo provincial)");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ejecutarActividad1(sc);
                    break;
                case 2:
                    ejecutarActividad2(sc);
                    break;
                case 3:
                    ejecutarActividad3(sc);
                    break;
                case 4:
                    ejecutarActividad4(sc);
                    break;
                case 5:
                    ejecutarActividad5(sc);
                    break;
                case 6:
                    ejecutarActividad6(sc);
                    break;
                case 7:
                    ejecutarActividad7(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void ejecutarActividad1(Scanner sc) {
        System.out.print("\n-- Actividad 1 --\nIngrese la cantidad de notas: ");
        int n = sc.nextInt();
        Actividad_1 act1 = new Actividad_1(n);
        for (int i = 0; i < n; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            act1.setNota(i, sc.nextDouble());
        }
        System.out.println("Nota más alta: " + act1.getNotaMaxima());
        System.out.println("Promedio: " + act1.getPromedio());
    }

    private static void ejecutarActividad2(Scanner sc) {
        System.out.print("\n-- Actividad 2 --\nIngrese la cantidad de notas: ");
        int n = sc.nextInt();
        Actividad_2 act2 = new Actividad_2(n);
        for (int i = 0; i < n; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            act2.setNota(i, sc.nextDouble());
        }
        System.out.println("Aprobados: " + act2.contarAprobados());
        System.out.println("Desaprobados: " + act2.contarDesaprobados());
    }

    private static void ejecutarActividad3(Scanner sc) {
        System.out.print("\n-- Actividad 3 --\nIngrese cantidad de productos: ");
        int n = sc.nextInt();
        Actividad_3 act3 = new Actividad_3(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Producto " + (i+1) + " - Cantidad: ");
            act3.setCantidad(i, sc.nextInt());
            System.out.print("Producto " + (i+1) + " - Costo unitario: ");
            act3.setCosto(i, sc.nextDouble());
        }

        double[] totales = act3.getPreciosTotales();
        System.out.println("\nPrecios totales por producto:");
        for (int i = 0; i < totales.length; i++) {
            System.out.printf("  Producto %d: $%.2f%n", i+1, totales[i]);
        }

        System.out.printf("Precio total general: $%.2f%n", act3.getPrecioTotalGeneral());

        int[] idx = act3.getIndicesSobre(1000);
        if (idx.length == 0) {
            System.out.println("Ningún producto supera $1000.");
        } else {
            System.out.print("Productos que superan $1000: ");
            for (int i = 0; i < idx.length; i++) {
                System.out.print((idx[i] + 1) + (i < idx.length-1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    private static void ejecutarActividad4(Scanner sc) {
        System.out.println("\n-- Actividad 4 --");
        Actividad_4 act4 = new Actividad_4();
        sc.nextLine();

        for (int i = 0; i < act4.getN(); i++) {
            System.out.printf("Camión %d - Patente: ", i+1);
            String pat = sc.nextLine();

            System.out.printf("Camión %d - Chofer: ", i+1);
            String ch  = sc.nextLine();

            System.out.printf("Camión %d - Tipo de carga (madera/yerba/té): ", i+1);
            String tp  = sc.nextLine();

            System.out.printf("Camión %d - Hora de egreso (HH:MM): ", i+1);
            String hr  = sc.nextLine();

            act4.setCamion(i, pat, ch, tp, hr);
        }
        act4.mostrarTodos();
    }

    private static void ejecutarActividad5(Scanner sc) {
        System.out.println("\n-- Actividad 5 --");
        Actividad_5 act5 = new Actividad_5();

        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            System.out.printf("Cliente %d - DNI: ", i+1);
            String dni = sc.nextLine();

            System.out.printf(
                    "Cliente %d - Tipo de servicio (1=30MB,$750 | 2=50MB,$1100 | 3=100MB,$1500-5%%): ",
                    i+1
            );
            int tipo = Integer.parseInt(sc.nextLine());

            act5.setCliente(i, dni, tipo);
        }

        act5.mostrarTodos();
    }

    private static void ejecutarActividad6(Scanner sc) {
        System.out.println("\n-- Actividad 6 --");
        Actividad_6 act6 = new Actividad_6();

        for (int i = 0; i < act6.getN(); i++) {
            int numVeh;
            do {
                System.out.printf("Competidor %2d - Número de vehículo: ", i+1);
                numVeh = sc.nextInt();
                if (act6.existeVehiculo(numVeh)) {
                    System.out.println("Ese número ya fue cargado, ingrese otro.");
                } else {
                    break;
                }
            } while (true);

            System.out.printf("Competidor %2d - Tiempo (segundos): ", i+1);
            double tiempo = sc.nextDouble();

            act6.setCompetidor(i, numVeh, tiempo);
        }

        System.out.println("\n--- Resultado ---");
        System.out.println("Mejor tiempo: "
                + act6.getTiempoGanador() + " s");
        System.out.println("Número de vehículo ganador: "
                + act6.getVehiculoGanador());
    }

    private static void ejecutarActividad7(Scanner sc) {
        System.out.println("\n-- Actividad 7: Procesar Censo --");
        Actividad_7 act7 = new Actividad_7();

        System.out.println("Para finalizar el ingreso, ingrese DNI = 0.");
        while (true) {
            System.out.print("DNI: ");
            int dni = sc.nextInt();
            if (dni == 0) break;

            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Sexo (F/M): ");
            char sexo = sc.next().toUpperCase().charAt(0);

            act7.agregarPersona(dni, edad, sexo);
        }

        System.out.println("\n--- Resultados del Censo ---");
        System.out.println("Total personas: " + act7.getTotal());
        System.out.println("Varones: "            + act7.getCantidadVarones());
        System.out.println("Mujeres: "           + act7.getCantidadMujeres());
        System.out.printf(
                "%% Varones entre 16 y 65: %.2f%%%n",
                act7.getPorcentajeVarones16a65()
        );
        System.out.println("Persona de mayor edad:");
        System.out.println("  DNI:  " + act7.getDocMayorEdad());
        System.out.println("  Edad: " + act7.getMayorEdad());
        System.out.println("  Sexo: " + act7.getSexoMayorEdad());
    }
}