public class Actividad_3 {
    private int[] cantidades;
    private double[] costos;

    public Actividad_3(int n) {
        cantidades = new int[n];
        costos = new double[n];
    }

    public void setCantidad(int i, int q) {
        if (i >= 0 && i < cantidades.length) cantidades[i] = q;
    }

    public void setCosto(int i, double c) {
        if (i >= 0 && i < costos.length) costos[i] = c;
    }

    public double[] getPreciosTotales() {
        double[] totales = new double[cantidades.length];
        for (int i = 0; i < cantidades.length; i++) {
            totales[i] = cantidades[i] * costos[i];
        }
        return totales;
    }

    public double getPrecioTotalGeneral() {
        double suma = 0;
        for (double p : getPreciosTotales()) suma += p;
        return suma;
    }

    public int[] getIndicesSobre(double umbral) {
        // Productos con precio total > umbral
        return java.util.stream.IntStream.range(0, cantidades.length)
                .filter(i -> cantidades[i] * costos[i] > umbral)
                .toArray();
    }
}