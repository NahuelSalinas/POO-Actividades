import java.util.ArrayList;
import java.util.List;

public class Actividad_7 {
    private final List<Integer> documentos;
    private final List<Integer> edades;
    private final List<Character> sexos;

    public Actividad_7() {
        documentos = new ArrayList<>();
        edades = new ArrayList<>();
        sexos = new ArrayList<>();
    }

    /** Agrega una persona censada */
    public void agregarPersona(int doc, int edad, char sexo) {
        documentos.add(doc);
        edades.add(edad);
        sexos.add(Character.toUpperCase(sexo));
    }

    /** Total de personas censadas */
    public int getTotal() {
        return documentos.size();
    }

    /** Cantidad de varones */
    public int getCantidadVarones() {
        int cnt = 0;
        for (char s : sexos) if (s == 'M') cnt++;
        return cnt;
    }

    /** Cantidad de mujeres */
    public int getCantidadMujeres() {
        int cnt = 0;
        for (char s : sexos) if (s == 'F') cnt++;
        return cnt;
    }

    /** % de varones (M) con edad entre 16 y 65 sobre el total de varones */
    public double getPorcentajeVarones16a65() {
        int varones = getCantidadVarones();
        if (varones == 0) return 0.0;
        int cnt = 0;
        for (int i = 0; i < sexos.size(); i++) {
            if (sexos.get(i) == 'M'
                    && edades.get(i) >= 16
                    && edades.get(i) <= 65) {
                cnt++;
            }
        }
        return cnt * 100.0 / varones;
    }

    /** Índice de la persona de mayor edad */
    private int indiceMayor() {
        int idx = 0;
        for (int i = 1; i < edades.size(); i++) {
            if (edades.get(i) > edades.get(idx)) {
                idx = i;
            }
        }
        return idx;
    }

    /** Documento de la persona de mayor edad */
    public int getDocMayorEdad() {
        return documentos.get(indiceMayor());
    }

    /** Edad máxima */
    public int getMayorEdad() {
        return edades.get(indiceMayor());
    }

    /** Sexo de la persona de mayor edad */
    public char getSexoMayorEdad() {
        return sexos.get(indiceMayor());
    }
}