package lld.java.oops.animal.model;

public class Chittah extends Animal {

    public Chittah(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Chittah growls");
    }
}
