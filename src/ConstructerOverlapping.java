class Rectangle{
    double length;
    double width;

    Rectangle(double length , double width ){
        this.length = length;
        this.width = width;
    }
    Rectangle(double side){
        this.length = side ;
        this.width = side ;
    }
    double area(){
        return length*width;
    }
    double perimeter(){
        return 2*(length + width );
    }
    void display(){
        System.out.println("length :" +length);
        System.out.println("Width: " +width);
        System.out.println("Area: " + area());
        System.out.println("perimeter: " + perimeter());

    }
}
public class ConstructerOverlapping {
        public static void main(String[] args){

            Rectangle r1 = new Rectangle(10,5);
            Rectangle r2 = new Rectangle(7);
            System.out.println("Rectangle -------");
            r1.display();

            System.out.println("-------square-------");
            r2.display();
            
        }
}
