package pt.isec.deis.pa.aula1;

public class SomaParInteiros{
    
    public static void main(String[] args) throws Exception {
        int i1;
        int i2;

        System.out.println();

        if(args.length != 2){
            System.out.println("Devem ser passados 2 argumentos na linha de comando!");
            return;
        }

        i1 = Integer.parseInt(args[0]);
        i2 = Integer.parseInt(args[1]);

        ParInteiros p = new ParInteiros(i1, i2);
        System.out.println(p);

        System.out.println(i1 +  " + " + i2 + " = " + p.getSoma());
    }    
}
