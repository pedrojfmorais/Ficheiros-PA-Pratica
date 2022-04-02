package pt.isec.pa.aula3.ex7;

public class ex7 {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        MatrizExemplo mat = new MatrizExemplo(4,3);
        MatrizExemplo outro = new MatrizExemplo(4,3);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                mat.set(i, j, (float) (Math.random() * 100) + 1 );
                outro.set(i, j, (float) (Math.random() * 100) + 1 );
            }
        }

        mat.show();
        outro.show();

        mat.plus(outro);

        mat.show();

        MatrizExemplo res = MatrizExemplo.somaMatrizes(mat, outro);
        res.show();

        MatrizExemplo asd = (MatrizExemplo) mat.clone();
        asd.show(); 

    }
}
