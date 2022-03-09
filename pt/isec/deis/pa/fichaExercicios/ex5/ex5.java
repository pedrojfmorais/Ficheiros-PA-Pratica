package pt.isec.deis.pa.fichaExercicios.ex5;

public class ex5 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Totoloto t = new Totoloto();

        t.preencheTodosNumeros();

        System.out.println(t);

        Totoloto a = new Totoloto();
        a.auto();

        System.out.println(a);

        Totoloto b = (Totoloto) a.clone();

        System.out.println(b);

        System.out.println(b.equals(a));
    }
}
