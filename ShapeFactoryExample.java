interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing a Square"); }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        return switch (type.toLowerCase()) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> throw new IllegalArgumentException("Unknown shape type");
        };
    }
}

public class ShapeFactoryExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw();
        Shape square = ShapeFactory.createShape("square");
        square.draw();
    }
}