<<<<<<< HEAD
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
=======
class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {

    double grade;

    Student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void getInfo() {
        super.getInfo();
        System.out.println("Grade: " + grade);
    }

    void study() {
        System.out.println(name + " is studying");
    }
}

class Teacher extends Person {

    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void getInfo() {
        super.getInfo();
        System.out.println("Subject: " + subject);
    }

    void teach() {
        System.out.println(name + " is teaching " + subject);
>>>>>>> abd999a4e7563bdfda5a5b60c0fe0d6638c4932f
    }
}

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) {
        Circle c = new Circle("red");
        Triangle t = new Triangle("blue");

        c.draw();
        t.draw();
    }
=======

    public static void main(String[] args) {

        Person[] people = new Person[5];

        people[0] = new Student("Ravi",20,8.5);
        people[1] = new Student("Arun",21,7.9);
        people[2] = new Student("Kiran",19,9.1);

        people[3] = new Teacher("Meena",35,"Math");
        people[4] = new Teacher("Suresh",40,"Physics");

        for(Person p : people) {
            p.getInfo();
            System.out.println();
        }

    }

>>>>>>> abd999a4e7563bdfda5a5b60c0fe0d6638c4932f
}