package pt.isec.pa.fichaExercicios.ex23.Frota;

public class VeiculoPesadoPassageiros extends Veiculo implements IPassengers, IMaxLoad{

    private final int maxPassageiros;
    private final int maxCarga;

    public VeiculoPesadoPassageiros(String matricula, int ano, int maxPassageiros, int maxCarga){
        super(matricula, ano);
        this.maxPassageiros = maxPassageiros;
        this.maxCarga = maxCarga;
    }

    public int getNumberPassengers(){return maxPassageiros;}

    public int getMaxWeight(){return maxCarga;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo Pesado de Passageiros").append(System.lineSeparator());
        sb.append(super.toString());

        sb.append("Max passageiros: ").append(maxPassageiros).append(System.lineSeparator());
        sb.append("Max Carga: ").append(maxCarga).append(System.lineSeparator());

        return sb.toString();
    }

}
