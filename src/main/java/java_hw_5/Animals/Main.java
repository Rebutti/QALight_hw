package java_hw_5.Animals;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.eat());
        System.out.println(animal.sleep());
        Bird bird = new Bird();
        System.out.println(bird.fly());
        Fish fish = new Fish();
        System.out.println(fish.swim());
        Dog dog = new Dog();
        System.out.println(dog.bark());
        System.out.println(fish.eat());
        System.out.println(bird.sleep());
        System.out.println(dog.eat());
        System.out.println(dog.sleep());
    }
}
