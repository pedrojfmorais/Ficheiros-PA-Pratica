package pt.isec.deis.pa.fichaExercicios.ex5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Totoloto {
    private static final int nNumeros = 5;
    private int [] numeros;
    private int sorte;

    public Totoloto(){
        numeros = new int[nNumeros];
    }

    public Totoloto(Totoloto outro){_copy(outro);}

    private void _copy(Totoloto outro){
        numeros = Arrays.copyOf(outro.numeros, nNumeros);
        sorte = outro.sorte;
    }

    public void add(){

        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < nNumeros; i++) {
            if(numeros[i] == 0)
                break;
        }

        if(i == nNumeros && sorte != 0) {
            System.out.println("Numeros ja preenchidos!!!");

        }else if (i == nNumeros){
            do{
                System.out.println("Insira o numero da sorte entre 1 e 13: ");
                sorte = scan.nextInt();
            }while (sorte < 1 || sorte > 13);

        }else {
            while ((numeros[i] < 1 || numeros[i] > 49) || getPosNum(numeros[i]) != i){
                System.out.println("Insira o numero " + (i+1) + " entre 1 e 49: ");
                numeros[i] = scan.nextInt();
            }
        }
    }

    public void preencheTodosNumeros(){
        for (int i = 0; i < nNumeros+1; i++) {
            add();
        }
    }

    private int getPosNum(int num){
        for (int i = 0; i < nNumeros; i++) {
            if(numeros[i] == num)
                return i;
        }
        return -1;
    }

    public boolean verify(){
        int i;
        for (i = 0; i < nNumeros; i++) {
            if(numeros[i] == 0)
                break;
        }

        return i == nNumeros && sorte != 0;
    }

    public void auto(){
        Random rand = new Random();

        for (int i = 0; i < nNumeros; i++) {
            do {
                numeros[i] = rand.nextInt(49) + 1;
            }while (getPosNum(numeros[i]) != i);
        }
        sorte = rand.nextInt(13) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Totoloto totoloto = (Totoloto) o;
        return sorte == totoloto.sorte && Arrays.equals(numeros, totoloto.numeros);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numeros = " + Arrays.toString(numeros) + "\n");
        sb.append("Sorte = " + sorte + "\n");

        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Totoloto(this);
    }
}
