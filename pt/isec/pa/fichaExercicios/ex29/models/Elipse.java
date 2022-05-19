package pt.isec.pa.ex29.models;

public class Elipse extends Retangulo {

    double rx, ry;

    public Elipse() {
        super();
        this.rx = 10;
        this.ry = 10;
    }

    public double getRx() {
        return rx;
    }

    public void setRx(double rx) {
        this.rx = rx;
    }

    public double getRy() {
        return ry;
    }

    public void setRy(double ry) {
        this.ry = ry;
    }

    public void setRadius() {
        this.rx = getMaxX() - getCenterX();
        this.ry = getMaxY() - getCenterY();
    }

}
