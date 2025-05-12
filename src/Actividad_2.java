public class Actividad_2 {
    private double[] notas;

    public Actividad_2(int cantidadNotas) {
        notas = new double[cantidadNotas];
    }

    public void setNota(int indice, double nota) {
        if (indice >= 0 && indice < notas.length) {
            notas[indice] = nota;
        }
    }

    public double[] getNotas() {
        return notas;
    }

    public int contarAprobados() {
        int contador = 0;
        for (double nota : notas) {
            if (nota >= 6) {
                contador++;
            }
        }
        return contador;
    }

    public int contarDesaprobados() {
        int contador = 0;
        for (double nota : notas) {
            if (nota < 6) {
                contador++;
            }
        }
        return contador;
    }
}