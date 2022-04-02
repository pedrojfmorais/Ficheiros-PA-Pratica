package pt.isec.pa.fichaExercicios.ex23.Frota;

public class VeiculoLigeiroPassageiros extends Veiculo implements IPassengers{

    private final int maxPassageiros;

    public VeiculoLigeiroPassageiros(String matricula, int ano, int maxPassageiros){
        super(matricula, ano);
        this.maxPassageiros = maxPassageiros;
    }

    public int getNumberPassengers(){return maxPassageiros;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo Ligeiro de Passageiros").append(System.lineSeparator());
        sb.append(super.toString());

        sb.append("Max passageiros: ").append(maxPassageiros).append(System.lineSeparator());

        return sb.toString();
    }
}
