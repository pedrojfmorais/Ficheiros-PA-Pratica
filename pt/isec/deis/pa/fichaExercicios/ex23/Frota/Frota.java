package pt.isec.deis.pa.fichaExercicios.ex23.Frota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Frota {

    HashSet<Veiculo> veiculos;

    public Frota(){veiculos = new HashSet<>();}
    public Frota(HashSet<Veiculo> veiculos){this.veiculos = veiculos;}

    public boolean addVeiculo(Veiculo v){return veiculos.add(v);}

    public boolean removeVeiculo(String matricula){
        return veiculos.remove(Veiculo.getDummyVeiculo(matricula));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Veiculos: ").append(System.lineSeparator()).append(System.lineSeparator());
        for (var v : veiculos) {
            sb.append(v).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String infoAllVeiculos(){return toString();}

    public String infoVeiculosPassageiros(){
        ArrayList<IPassengers> aux = new ArrayList<>();

        for (var v : veiculos) {
            if(v instanceof IPassengers)
                aux.add((IPassengers) v);
        }

        aux.sort(new PassageirosComparator());

        StringBuilder sb = new StringBuilder();

        sb.append("Veiculos Passageiros: ").append(System.lineSeparator()).append(System.lineSeparator());
        for (var v : aux) {
            sb.append(v).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String infoVeiculosCarga(){
        ArrayList<IMaxLoad> aux = new ArrayList<>();

        for (var v : veiculos) {
            if(v instanceof IMaxLoad)
                aux.add((IMaxLoad) v);
        }

        aux.sort(new CargaComparator());
        Collections.reverse(aux);

        StringBuilder sb = new StringBuilder();

        sb.append("Veiculos Carga: ").append(System.lineSeparator()).append(System.lineSeparator());
        for (var v : aux) {
            sb.append(v).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
