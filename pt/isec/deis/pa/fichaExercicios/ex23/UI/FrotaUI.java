package pt.isec.deis.pa.fichaExercicios.ex23.UI;

import pt.isec.deis.pa.fichaExercicios.ex23.Frota.Frota;
import pt.isec.deis.pa.fichaExercicios.ex23.Frota.VeiculoCarga;
import pt.isec.deis.pa.fichaExercicios.ex23.Frota.VeiculoLigeiroPassageiros;
import pt.isec.deis.pa.fichaExercicios.ex23.Frota.VeiculoPesadoPassageiros;
import pt.isec.deis.pa.utils.PAInput;

public class FrotaUI {

    private Frota frota;

    public FrotaUI(){frota = new Frota();}

    public void start() {
        while (true) {
            switch (PAInput.chooseOption("Frota",
                    "Add Veiculo","Remove Veiculo","Show All Veiculo","Show Veiculos Passageiros",
                    "Show Veiculos Carga","Quit")) {
                case 1:
                    addVeiculo();
                    break;
                case 2:
                    removeVeiculo();
                    break;
                case 3:
                    System.out.println(frota.infoAllVeiculos());
                    break;
                case 4:
                    System.out.println(frota.infoVeiculosPassageiros());
                    break;
                case 5:
                    System.out.println(frota.infoVeiculosCarga());
                    break;
                case 6:
                    return;
            }
        }
    }

    private void addVeiculo(){
        int tipoVeiculo;
        boolean result = false;
        do {
            tipoVeiculo = PAInput.readInt("""
                    Tipo de Veiculos:
                     1 - Ligeiro Passageiros\s
                     2 - Pesado Passageiros
                     3 - Pesado Carga
                    """);
        } while(tipoVeiculo != 1 && tipoVeiculo != 2 && tipoVeiculo != 3);

        String matricula = PAInput.readString("Matricula Veiculo: ",false);
        int ano = PAInput.readInt("Ano Veiculo: ");

        switch (tipoVeiculo){
            case 1 -> {
                int maxPassageiros = PAInput.readInt("Máximo de Passageiros: ");
                result = frota.addVeiculo(new VeiculoLigeiroPassageiros(matricula, ano, maxPassageiros));
            }
            case 2 -> {
                int maxPassageiros = PAInput.readInt("Máximo de Passageiros: ");
                int maxCarga = PAInput.readInt("Máximo de Carga: ");
                result = frota.addVeiculo(new VeiculoPesadoPassageiros(matricula, ano, maxPassageiros, maxCarga));
            }
            case 3 -> {
                int maxCarga = PAInput.readInt("Máximo de Carga: ");
                result = frota.addVeiculo(new VeiculoCarga(matricula, ano, maxCarga));
            }
        }

        if (result)
            System.out.println("O veiculo foi introduzido!" + System.lineSeparator());
        else
            System.out.println("Não foi desta campeão!" + System.lineSeparator());
    }

    private void removeVeiculo(){
        String matricula = PAInput.readString("Insira a matricula do veiculo a remover: ", false);

        if(frota.removeVeiculo(matricula))
            System.out.println("O veiculo foi removido!" + System.lineSeparator());
        else
            System.out.println("Não foi desta campeão!" + System.lineSeparator());
    }

}
