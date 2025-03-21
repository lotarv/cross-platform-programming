import shapes.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<AbstractShape> shapes = new ArrayList<>();

        AbstractShape[] candidates = {
            new Line(0, 0, 5),
            new Rectangle(1, 1, 3, 4),
            new Circle(2, 2, 2.5),
            new Triangle(3, 3, 3, 4, 5),
            new Line(0, 0, 5), // Дубликат
            new Rectangle(5, 5, 2, 6),
            new Circle(6, 6, 1.5),
            new Triangle(7, 7, 5, 5, 5),
            new Line(8, 8, 10),
            new Rectangle(9, 9, 4, 4),
            new Circle(10, 10, 3),
            new Triangle(11, 11, 6, 8, 10),
            new Line(12, 12, 7),
            new Rectangle(13, 13, 5, 5),
            new Circle(14, 14, 2)
        };

        for (AbstractShape shape : candidates) {
            if (!shapes.contains(shape)) {
                shapes.add(shape);
            }
        }

        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        for (int i = 0; i < shapes.size(); i++) {
            AbstractShape shape = shapes.get(i);
            shape.fill(colors[i % colors.length]);
            System.out.println("Before resizing:");
            System.out.println(shape);
            System.out.println("Square: " + shape.square());
            System.out.println("Perimeter: " + shape.perimeter());

            // Изменяем размер на 20%
            ((Resizable) shape).resize(20);
            System.out.println("After resizing by 20%:");
            System.out.println(shape);
            System.out.println("Square: " + shape.square());
            System.out.println("Perimeter: " + shape.perimeter());
            System.out.println();
        }

        System.out.println("Total unique shapes: " + shapes.size());
    }
}