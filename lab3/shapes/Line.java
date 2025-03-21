package shapes;

public class Line extends AbstractShape implements Resizable{
    private double length;

    public Line(double x, double y, double length) {
        super(x,y);
        this.length = length;
    }

    @Override
    public double square() {
        return 0;
    }

    @Override
    public double perimeter() {
        return length;
    }

    @Override
    public void resize(int percent) {
        this.length = this.length * (1 + percent / 100.0);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Line: " + super.toString() + ", length: " + length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line)) return false;
        Line other = (Line) obj;
        return this.length == other.length && this.x == other.x && this.y == other.y;
    }
}
