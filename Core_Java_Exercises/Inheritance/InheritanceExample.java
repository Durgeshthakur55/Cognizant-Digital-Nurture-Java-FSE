

 class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeSound();
        
        Dog myDog = new Dog();
        myDog.makeSound();
    }
    
}
