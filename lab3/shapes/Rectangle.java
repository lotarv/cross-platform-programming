package shapes;

public class Rectangle extends AbstractShape implements Resizable {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double square() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(int percent) {
        this.width = this.width * (1 + percent / 100.0);
        this.height = this.height * (1 + percent / 100.0);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle: " + super.toString() + ", width: " + width + ", height: " + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;
        return this.width == other.width && this.height == other.height && this.x == other.x && this.y == other.y;
    }
}