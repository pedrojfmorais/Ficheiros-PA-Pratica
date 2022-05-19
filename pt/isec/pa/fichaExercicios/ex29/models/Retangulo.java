package pt.isec.pa.ex29.models;

public class Retangulo extends Figura {

    double x2, y2; // Inf direito

    public Retangulo() {
        super();
        x2 = 300;
        y2 = 200;
    }

    public void setP2(double x, double y) {
        this.x2 = x;
        this.y2 = y;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }



    public double getMinX() { return Math.min(x1, x2); }
    public double getMinY() { return Math.min(y1, y2); }
    public double getMaxX() { return Math.max(x1, x2); }
    public double getMaxY() { return Math.max(y1, y2); }
    public double getWidth() { return Math.abs(x1 - x2); }
    public double getHeight() { return Math.abs(y1 - y2); }

    public double getCenterX() { return (getMaxX() + getMinX()) / 2; }
    public double getCenterY() { return (getMaxY() + getMinY()) / 2; }

    public void setPs(double cx, double cy, double mx, double my) {

        double x = Math.abs(cx - mx);
        double y = Math.abs(cy - my);
        setP1(cx + x, cy + y);
        setP2(cx - x, cy - y);
    }
}
