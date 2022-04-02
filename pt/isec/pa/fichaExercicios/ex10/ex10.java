package pt.isec.pa.fichaExercicios.ex10;

import pt.isec.pa.fichaExercicios.ex10.Interface.JogoEnforcadoIU;
import pt.isec.pa.fichaExercicios.ex10.Modelo.JogoEnforcadoModelo;

public class ex10 {

    public static void main(String[] args) {

        JogoEnforcadoModelo jogo = new JogoEnforcadoModelo();
        JogoEnforcadoIU jogoIU = new JogoEnforcadoIU(jogo);

        jogoIU.jogar();
    }
}
