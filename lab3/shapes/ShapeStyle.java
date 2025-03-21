package shapes;

public interface ShapeStyle {
    void move(double dx, double dy);
    void fill(String color);
    double getX();
    double getY();
    String getColor();
}
