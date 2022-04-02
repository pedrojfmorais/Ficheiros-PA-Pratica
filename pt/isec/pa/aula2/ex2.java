package pt.isec.pa.aula2;

import java.util.Random;
import java.util.Scanner;

public class ex2 {
    
    public static void main(String[] args) throws Exception{

        int nTentativas = 1;
        int min = 1, max = 100;

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Pense num numero entre 1 e 100, inclusive.");

        while(true){
            int num = rand.nextInt(max-min) + min;
            
            System.out.println("O seu numero e " + num + "?");
            String res = scan.nextLine();

            if(res.equals("Acertou"))
                break;
            else if(res.equals("Menor"))
                max = num;
            else if(res.equals("Maior"))
                min = num;

            nTentativas+= 1;
        }

        System.out.println("Demorou " + nTentativas + " para acertar no seu valor!");
    }
}
