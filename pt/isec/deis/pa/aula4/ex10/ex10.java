package pt.isec.deis.pa.aula4.ex10;

import pt.isec.deis.pa.aula4.ex10.Interface.JogoEnforcadoIU;
import pt.isec.deis.pa.aula4.ex10.Modelo.JogoEnforcadoModelo;

public class ex10 {

    public static void main(String[] args) {

        JogoEnforcadoModelo jogo = new JogoEnforcadoModelo();
        JogoEnforcadoIU jogoIU = new JogoEnforcadoIU(jogo);

        jogoIU.jogar();
    }
}
