class Vehicle {
    String brand;
    int speed;
    Vehicle(String brand , int speed){
        this.brand = brand;
        this.speed = speed;
    }
    void move(){
        System.out.println("vehicle is moving ");
    }
}
class Car extends Vehicle{
    Car(String brand , int speed ){
        super(brand,speed);
    }
    @Override
    void move(){
        System.out.println("Car is driving at " + speed + "kn/h");
    }
    void honk(){
        System.out.println("Car is honking ");
    }
}
public class Main1{
    public static void main (String[] args){
        Car c = new Car("Toyota" ,80);
        c.move();
        c.honk();
    }
}
