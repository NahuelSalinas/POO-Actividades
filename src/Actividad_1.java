public class Actividad_1 {
    public double[] notas;

    public Actividad_1(int cantidad) {
        this.notas = new double[cantidad];
    }

    public void setNota(int indice, double nota) {
        if (indice >= 0 && indice < notas.length) {
            this.notas[indice] = nota;
        } else {
            throw new IndexOutOfBoundsException("Índice de nota fuera de rango");
        }
    }

    public double[] getNotas() {
        return this.notas;
    }

    public double getNotaMaxima() {
        double max = notas[0];
        for (double n : notas) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public double getPromedio() {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }
}