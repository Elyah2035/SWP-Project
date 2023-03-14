package Vererbung;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic animal", 5);
        Dog dog = new Dog("Rover", 3);

        animal.speak();
        dog.speak();
        System.out.println("Animal name: " + animal.getName() + ", age: " + animal.getAge());
        System.out.println("Dog name: " + dog.getName() + ", age: " + dog.getAge());
    }
}