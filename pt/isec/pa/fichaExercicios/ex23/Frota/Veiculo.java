package pt.isec.pa.fichaExercicios.ex23.Frota;

import java.util.Objects;

public class Veiculo {
    private final String matricula;
    private int ano;

    private Veiculo(String matricula){this.matricula = matricula;}

    protected Veiculo(String matricula, int ano){
        this.matricula = matricula;
        this.ano = ano;
    }

    public String getMatricula(){return matricula;}

    public int getAno(){return ano;}

    public static Veiculo getDummyVeiculo(String matricula){return new Veiculo(matricula);}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula: ").append(matricula).append(System.lineSeparator());
        sb.append("Ano: ").append(ano).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(matricula, veiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
