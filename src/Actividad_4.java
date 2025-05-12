public class Actividad_4 {
    private String[] patentes;
    private String[] choferes;
    private String[] tiposCarga;
    private String[] horasEgreso;
    private final int N = 3; // Para ejemplificar el funcionamiento y no cargar los 30

    public int getN() {
        return N;
    }

    public Actividad_4() {
        patentes = new String[N];
        choferes = new String[N];
        tiposCarga = new String[N];
        horasEgreso = new String[N];
    }

    public void setCamion(int i, String patente, String chofer, String tipo, String hora) {
        if (i < 0 || i >= N) return;
        patentes[i] = patente;
        choferes[i] = chofer;
        tiposCarga[i] = tipo.toLowerCase();
        horasEgreso[i] = hora;
    }

    public int contarTe() {
        int c = 0;
        for (String tipo : tiposCarga)
            if ("té".equals(tipo) || "te".equals(tipo))
                c++;
        return c;
    }

    public void mostrarTodos() {
        System.out.println("\n--- Datos de camiones ---");
        for (int i = 0; i < N; i++) {
            System.out.printf("Camión %2d: Patente=%s, Chofer=%s, Carga=%s, Hora=%s%n",
                    i+1,
                    patentes[i],
                    choferes[i],
                    tiposCarga[i],
                    horasEgreso[i]);
        }
        System.out.println("Total de camiones que llevan té: " + contarTe());
    }
}