package pt.isec.deis.pa.fichaExercicios.ex23.Frota;

public class VeiculoCarga extends Veiculo implements IMaxLoad{

    private final int maxCarga;

    public VeiculoCarga(String matricula, int ano, int maxCarga){
        super(matricula, ano);
        this.maxCarga = maxCarga;
    }

    public int getMaxWeight(){return maxCarga;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo Carga").append(System.lineSeparator());
        sb.append(super.toString());

        sb.append("Max Carga: ").append(maxCarga).append(System.lineSeparator());

        return sb.toString();
    }
}
