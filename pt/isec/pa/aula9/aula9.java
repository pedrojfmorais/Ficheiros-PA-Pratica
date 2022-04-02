package pt.isec.pa.aula9;

import java.util.HashSet;

class TemperaturaDiaria {

    private int temperaturasHorarias[];
    private String responsavelMedicoes;
    private String localMedicao;

    TemperaturaDiaria(int[] temps, String resp, String local) {
        responsavelMedicoes = resp;
        localMedicao = local;
        temperaturasHorarias = new int[temps.length];
        for (int i = 0; i < temperaturasHorarias.length; i++) {
            temperaturasHorarias[i] = temps[i];
        }

    }
    public boolean equals(Object o) {
        if (!(o instanceof TemperaturaDiaria)) {
            return false;
        }
        TemperaturaDiaria outro = (TemperaturaDiaria) o;
        return getMaximo() == outro.getMaximo()
                && getMinimo() == outro.getMinimo();
    }
    public int hashCode() {
        return getMaximo() + getMinimo();
    }

    int getMaximo() {
        int max = temperaturasHorarias[0];
        for (int t : temperaturasHorarias) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }
    int getMinimo() {
        int min = temperaturasHorarias[0];
        for (int t : temperaturasHorarias) {
            if (t < min) {
                min = t;
            }
        }
        return min;
    }
}

class Temperaturas {

    private HashSet<TemperaturaDiaria> temps = new HashSet<>();

    public void acrescenta(TemperaturaDiaria td) {
        if (temps.contains(td)) {
            System.out.println("Já está registado um dia" +
                    " com máximos e mínimos similares");
        } else {
            System.out.println("Dia com novos máximos e mínimos");

            temps.add(td);
        }

    }

}

public class aula9 {
    public static void main(String[] args) {
        Temperaturas temperaturas = new Temperaturas();

        int [] t_coimbra = { 1, 2, 3, 4, 5, 6, 7}; // min 1 max 7
        int [] t_lisboa  = { 1, 0, 2, 0, 2, 0, 7}; // min 0 max 7
        int [] t_porto   = { 2, 4, 2, 5, 2, 3, 7}; // min 1 max 7
        System.out.println("1 - Coimbra");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_coimbra, "Felisberto", "Coimbra") );
        System.out.println("2 - Lisboa");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_lisboa,  "Pancrácio",  "Lisboa") );
        System.out.println("3 - Porto");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_porto,   "Zeferino",   "Porto") );

    }
}