package shapes;

public class Triangle extends AbstractShape implements Resizable {
    private double a, b, c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double square() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public void resize(int percent) {
        this.a = this.a * (1 + percent / 100.0);
        this.b = this.b * (1 + percent / 100.0);
        this.c = this.c * (1 + percent / 100.0);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle: " + super.toString() + ", sides: " + a + ", " + b + ", " + c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle other = (Triangle) obj;
        return this.a == other.a && this.b == other.b && this.c == other.c && this.x == other.x && this.y == other.y;
    }
}