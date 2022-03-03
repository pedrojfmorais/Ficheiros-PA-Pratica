package pt.isec.deis.pa.aula2;

import java.util.Random;

public class ex4 {

    int[] valores = new int[20];
    int dup = 0;

    public ex4(){
        
        Random rand = new Random();

        for(int i = 0; i < valores.length;){
            int num = rand.nextInt(100) + 1;
            if(existeValor(num)){
                dup++;
                continue;
            }
            valores[i] = num;
            i++;
        }
    }

    boolean existeValor(int valorVerificar){
        
        for(int i = 0; i < valores.length;i++){
            if(valores[i] == valorVerificar)
                return true;
        }
        return false;
    }

    void mostraValores(){

        for(int i = 0; i < valores.length;i++){
            System.out.println(valores[i] + " ");
        }
    }

    void nDuplicados(){
        System.out.println("\n Numeors duplicados: " + dup + " ");
    }

    public static void main(String[] args) throws Exception{
            ex4 a = new ex4();
            a.mostraValores();
            a.nDuplicados();
    }

}
