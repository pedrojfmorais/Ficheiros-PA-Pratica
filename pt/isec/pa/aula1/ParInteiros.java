package pt.isec.pa.aula1;

public class ParInteiros{
    private int i1;
    private int i2;

    public ParInteiros(int i1, int i2){
        this.i1 = i1;
        this.i2 = i2;
    }

    public int getI1(){
        return i1;
    }

    public int getI2(){
        return i2;
    }

    public int getSoma(){
        return i1 + i2;
    }

    @Override
    public String toString(){
        return("{" + i1 + ";" + i2 + "}");
    }
}

