class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    Circle(String color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing a " + color + " circle");
    }
}

class Triangle extends Shape {
    Triangle(String color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing a " + color + " triangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle("red");
        Triangle t = new Triangle("blue");

        c.draw();
        t.draw();
    }
}