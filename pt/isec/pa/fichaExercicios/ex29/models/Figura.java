package pt.isec.pa.ex29.models;

public class Figura {

    double x1, y1; // Sup esquerdo ou centro
    double r, g, b;

    public Figura() {
        x1 = y1 = 50;
        r = 0.6;
        g = 0.3;
        b = 1;
    }

    public void setP1(double x, double y) {
        this.x1 = x;
        this.y1 = y;
    }

    public void setRGB(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

}
