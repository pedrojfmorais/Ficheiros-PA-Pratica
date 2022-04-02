package pt.isec.pa.fichaExercicios.ex9;

public class TrianguloPascal {
    
    private int[][] mat;

    public TrianguloPascal(int profundidade){
        mat = new int[profundidade][];

        for (int i = 0; i < mat.length; i++) {
            mat[i] = new int[i+1];
            for (int j = 0; j < mat[i].length; j++) {
                if(i == 0)
                    mat[i][j] = 1;
                else if (j == 0) 
                    mat[i][j] = 1;
                else if (j == mat[i].length-1) 
                    mat[i][j] = 1;
                else
                    mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < (mat.length-i); j++) {
                sb.append("   ");
            }
            sb.append("   ");
            for (int j = 0; j < mat[i].length; j++) {
                sb.append("   " + mat[i][j]);
            }
            sb.append("\n");
        }
        sb.append("\n]");

        return sb.toString();
    }

}
