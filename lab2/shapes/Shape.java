package shapes;

public abstract class Shape {
    protected double x;
    protected double y;

    protected String color;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = "No color";
    }

    public abstract double square();
    public abstract double perimeter();

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void fill(String color) {
        this.color = color;
    }

    //Gettes and setters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Shape at (" + x + ", " + y + "), color: " + color;
    }


}