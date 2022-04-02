package pt.isec.pa.fichaExercicios.ex23.Frota;

import java.util.Comparator;

public class PassageirosComparator implements Comparator<IPassengers> {
    @Override
    public int compare(IPassengers o1, IPassengers o2) {
        return Integer.compare(o1.getNumberPassengers(), o2.getNumberPassengers());
    }
}
