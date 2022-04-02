package pt.isec.pa.fichaExercicios.ex7;

import java.util.Arrays;

public class MatrizExemplo {
    private float[][] matriz;

    public MatrizExemplo(int lin, int col){
        matriz = new float[lin][col];
    }

    public MatrizExemplo(MatrizExemplo outro){
        _copy(outro);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return new MatrizExemplo(this);
    }

    public void _copy(MatrizExemplo outro){
        matriz = new float[outro.matriz.length][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Arrays.copyOf(outro.matriz[i], outro.matriz[i].length);
        }
    }

    public float get(int linha, int coluna){
        return matriz[linha][coluna];
    }

    public void set(int linha, int coluna, float value){ matriz[linha][coluna] = value; }

    public void show(){
        for (float[] linha : matriz) {
            for (float coluna : linha) {
                System.out.printf("| %.2f ", coluna);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void plus(MatrizExemplo outro){

        int linhas, colunas;
        if(matriz.length <= outro.matriz.length)
            linhas = matriz.length;
        else
            linhas = outro.matriz.length;

        for (int i = 0; i < linhas; i++) {

            if(matriz[i].length <= outro.matriz[i].length)
                colunas = matriz[i].length;
            else
                colunas = outro.matriz[i].length;

            for (int j = 0; j < colunas; j++) {
                matriz[i][j] += outro.matriz[i][j];
            }
        }
    }

    public static MatrizExemplo somaMatrizes(MatrizExemplo a, MatrizExemplo b) throws CloneNotSupportedException{
        MatrizExemplo res = (MatrizExemplo) a.clone();

        res.plus(b);

        return res;
    }
}
