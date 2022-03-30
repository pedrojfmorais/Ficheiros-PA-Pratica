package pt.isec.deis.pa.fichaExercicios.ex23.Frota;

import java.util.Comparator;

public class CargaComparator implements Comparator<IMaxLoad> {
    @Override
    public int compare(IMaxLoad o1, IMaxLoad o2) {
        return Integer.compare(o1.getMaxWeight(), o2.getMaxWeight());
    }
}
