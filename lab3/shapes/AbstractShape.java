package shapes;

public abstract class AbstractShape implements ShapeMetrics, ShapeStyle {
    protected double x;
    protected double y;
    protected String color;

    public AbstractShape(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = "No color";
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void fill(String color) {
        this.color = color;
    }

    @Override
    public double getX() {
        return x;
    }
    
    @Override
    public double getY() {
        return y;
    }

    @Override
    public String getColor() {
        return color;
    }

    // Абстрактные методы из ShapeMetrics
    @Override
    public abstract double square();

    @Override
    public abstract double perimeter();

    @Override
    public String toString() {
        return "Shape at (" + x + ", " + y + "), color: " + color;
    }
}
