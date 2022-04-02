package pt.isec.pa.ex10.Interface;

import pt.isec.pa.ex10.Modelo.JogoEnforcadoModelo;

import java.util.Scanner;

public class JogoEnforcadoIU {

    private JogoEnforcadoModelo jogoEnforcadoModelo;

    public JogoEnforcadoIU(JogoEnforcadoModelo jogoEnforcadoModelo) {
        this.jogoEnforcadoModelo = jogoEnforcadoModelo;
    }

    public void jogar(){

        Scanner scan = new Scanner(System.in);
        String palavraInserida;

        while(!jogoEnforcadoModelo.concluido()){

            System.out.println(jogoEnforcadoModelo);

            System.out.println("Insira uma letra: ");
            palavraInserida = scan.next();

            jogoEnforcadoModelo.setOpcao(palavraInserida);
        }

        System.out.println();

        if(jogoEnforcadoModelo.ganhou())
            System.out.println("Parabéns Ganhou!");
        else
            System.out.println("Fica para a próxima campeão!");

        System.out.println("Palavra: " + jogoEnforcadoModelo.getPalavra());
        System.out.println("Número de tentativas: " + jogoEnforcadoModelo.getTentativas());

        System.out.println("\n\n Pretende jogar novamente? (y/n)");
        palavraInserida = scan.next();

        palavraInserida = palavraInserida.toUpperCase();

        if(palavraInserida.equals("Y")){
            jogoEnforcadoModelo.iniciar();
            jogar();
        }
    }
}
