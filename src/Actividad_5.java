public class Actividad_5 {
    private String[] dnis;
    private int[] servicios;
    private final int N = 5;
    private static final double[] COSTOS = {750, 1100, 1500};

    public Actividad_5() {
        dnis     = new String[N];
        servicios = new int[N];
    }

    public void setCliente(int i, String dni, int servicio) {
        if (i < 0 || i >= N) return;
        dnis[i] = dni;
        servicios[i] = servicio;
    }

    public double getMonto(int i) {
        double base = COSTOS[servicios[i] - 1];
        if (servicios[i] == 3) {
            base *= 0.95;  // 5% de descuento
        }
        return base;
    }

    public void mostrarTodos() {
        System.out.println("\n--- Facturas de Internet ---");
        for (int i = 0; i < N; i++) {
            System.out.printf("Cliente %d: DNI=%s, Servicio=%d, Monto=$%.2f%n",
                    i+1, dnis[i], servicios[i], getMonto(i));
        }
    }
}