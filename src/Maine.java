class Animal{
    void brethe(){
        System.out.println("Animal is breathing ");
        //Every animal can brethe
    }
}
class Mammal extends Animal{
    //Mammal inheritance the Animal
    //therefore mammal get Breathe() by birth (automatically)
    void feedMilk(){
        System.out.println("Mammal feeds milk");
        //all mammal can feed milk
    }
}
class Dog extends Mammal {
    void fetch(){
        System.out.println("Dog is fetching the ball");
    }
    void bark(){
        System.out.println("Dog is barking!!");
    }
}
    public class Maine {
        public static void main(String[] args){
            Dog d = new Dog();
            d.brethe();
            d.feedMilk();
            d.fetch();
            d.bark();

        }
    }


