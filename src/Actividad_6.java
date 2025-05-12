public class Actividad_6 {
    private int[] vehiculos;
    private double[] tiempos;
    private final int N = 3;

    public Actividad_6() {
        vehiculos = new int[N];
        tiempos = new double[N];
    }

    public int getN() {
        return N;
    }

    public void setCompetidor(int i, int numeroVehiculo, double tiempoSegundos) {
        if (i < 0 || i >= N) return;
        vehiculos[i] = numeroVehiculo;
        tiempos[i] = tiempoSegundos;
    }

    /** Comprueba si el número de vehículo ya fue ingresado */
    public boolean existeVehiculo(int numeroVehiculo) {
        for (int v : vehiculos) {
            if (v == numeroVehiculo) {
                return true;
            }
        }
        return false;
    }

    private int indiceMejor() {
        int idxMin = 0;
        for (int i = 1; i < N; i++) {
            if (tiempos[i] < tiempos[idxMin]) {
                idxMin = i;
            }
        }
        return idxMin;
    }

    public int getVehiculoGanador() {
        return vehiculos[indiceMejor()];
    }

    public double getTiempoGanador() {
        return tiempos[indiceMejor()];
    }
}