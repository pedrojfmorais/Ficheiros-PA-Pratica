package pt.isec.pa.fichaExercicios.ex10.Modelo;

import java.util.Random;

public class JogoEnforcadoModelo {

    public static final char ESCONDIDO = '_';
    private static final int MAX_TENTATIVAS = 15;

    private String palavra;
    private StringBuilder situacao;
    private StringBuilder letrasUtilizadas;

    private int tentativas;

    public JogoEnforcadoModelo(){
        iniciar();
    }

    public void iniciar(){
        Random rand = new Random();
        palavra = JogoEnforcadoDicionario.getPalavra(rand.nextInt(JogoEnforcadoDicionario.getNrPalavras()));

        situacao = new StringBuilder(String.valueOf(ESCONDIDO).repeat(palavra.length()));

        letrasUtilizadas = new StringBuilder();

        tentativas = 0;
    }

    public boolean concluido(){
        if(!situacao.toString().equals(palavra) && tentativas <= MAX_TENTATIVAS)
            return false;
        return true;
    }

    public boolean ganhou(){
        if(palavra.equals(situacao.toString()))
            return true;
        return false;
    }

    public void setOpcao(String palavraInserida){

        palavraInserida = palavraInserida.toUpperCase();

        int count = 0;
        if(palavraInserida.length() == 1){
            int index = -1;
            do{
                index = palavra.indexOf(palavraInserida, index+1);

                if(index != -1){
                    situacao.setCharAt(index, palavraInserida.toCharArray()[0]);
                    count++;
                }
            }while(index != -1);

            if (count == 0){
                index = letrasUtilizadas.indexOf(palavraInserida);
                if(index == -1)
                    letrasUtilizadas.append(palavraInserida).append(" ");
            }
        }else {
            if(palavraInserida.equals(palavra)){
                situacao.replace(0, situacao.length(), palavraInserida);
            }else{
                count++;
            }
        }
        if(count == 0){
            tentativas++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nSituação atual: ").append(situacao.toString());
        sb.append("\nLetras Utilizadas: ").append(letrasUtilizadas.toString());
        sb.append("\nMáximo tentativas: " + MAX_TENTATIVAS);
        sb.append("\nTentativas Utilizadas: ").append(tentativas);

        return sb.toString();
    }

    public String getPalavra() {return palavra;}

    public int getTentativas(){return tentativas;}
}

